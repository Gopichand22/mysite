package com.mysite.aem.core.models;

import java.util.List;
import java.util.Map;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mysite.aem.core.services.DataResolver;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class DataResolverModel {

	@OSGiService
	DataResolver dataRes;

	public String getPagePath() {
		return dataRes.getPagePath();
	}

	public List<Map<String, Object>> getPageInfo() {
		return dataRes.getPageInfo();
	}
}
