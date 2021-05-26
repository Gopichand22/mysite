package com.mysite.aem.core.services;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.sling.api.resource.LoginException;
import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;

import com.day.cq.dam.api.Asset;
import com.day.cq.dam.api.Rendition;

@Component(service = CsvReader.class, immediate = true)
public class CsvReaderImpl implements CsvReader {

	@Reference
	ResourceResolverFactory resourceResolverFactory;

	public static final String SERVICE_NAME = "gopiSysUsr";

	
	public static final String RESOURCE_PATH = "/content/dam/mysite/100 Records.csv";

	ResourceResolver resourceResolver = null;

	String csvFile = null;
	String str = null;

	@Activate
	@Modified
	public void activate() {
		Map<String, Object> map = new HashMap<>();
		map.put(ResourceResolverFactory.SUBSERVICE, SERVICE_NAME);
		try {
			resourceResolver = resourceResolverFactory.getServiceResourceResolver(map);
		} catch (LoginException e) {

		}
	}

	@Override
	public String getDataFromCsvFile() {
		try {
			Resource resource = resourceResolver.getResource(RESOURCE_PATH);
			Asset asset = resource.adaptTo(Asset.class);
			Rendition rendition = asset.getOriginal();
			InputStream inputStream = rendition.adaptTo(InputStream.class);
			if (inputStream != null) {
				csvFile = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
				return csvFile;
			} else {
				return "failed grab data from csv";
			}
		} catch (Exception e) {
		}
		return "No operations are performed";
	}
}
