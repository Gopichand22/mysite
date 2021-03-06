package com.mysite.aem.core.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.wcm.api.Page;

@Component(service = DataResolver.class, immediate = true)
public class DataResolverImpl implements DataResolver {

	@Reference
	ResourceResolverFactory resourceResolverFactory;

	public static final String SERVICE_NAME = "gopiSysUsr";
	String path = null;

	public static final String RESOURCE_PATH = "/content/mysite/en";

	ResourceResolver resourceResolver = null;

	@Activate
	@Modified
	public void getResourceResolver() {
		Map<String, Object> mapData = new HashMap<>();
		mapData.put(ResourceResolverFactory.SUBSERVICE, SERVICE_NAME);
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(mapData);
		} catch (LoginException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String getPagePath() {
		Resource resource = resourceResolver.getResource(RESOURCE_PATH);
		path = resource.getPath();
		if (!path.isEmpty()) {
			return path;
		} else {
			return "Resource Resolver is NULL";
		}
	}

	@Override
	public List<Map<String, Object>> getPageInfo() {
		List<Map<String, Object>> pageInfo = new ArrayList<>();
		Resource resource = resourceResolver.getResource(RESOURCE_PATH);
		Page page = resource.adaptTo(Page.class);
		Iterator<Page> childPages = page.listChildren();
		while (childPages.hasNext()) {
			Page childPage = childPages.next();
			Map<String, Object> childInfo = new HashMap<>();
			childInfo.put("parent", childPage.getParent().getName());
			childInfo.put("title", childPage.getTitle());
			childInfo.put("path", childPage.getPath());
			childInfo.put("depth", childPage.getDepth());
			childInfo.put("lastModified", childPage.getLastModified().getInstance().getTime().toString());
			childInfo.put("allInfo", childPage.getProperties());
			pageInfo.add(childInfo);
		}
		return pageInfo;
	}

}
