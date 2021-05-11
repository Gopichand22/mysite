package com.mysite.aem.core.services;

import java.util.List;
import java.util.Map;


public interface DataResolver {
	
	public String getPagePath();
	public List<Map<String,Object>> getPageInfo();

}
