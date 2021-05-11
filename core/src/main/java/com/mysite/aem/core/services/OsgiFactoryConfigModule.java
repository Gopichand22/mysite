package com.mysite.aem.core.services;

import java.util.List;

public interface OsgiFactoryConfigModule {
	 public int getStudentId();
	    public String getStudentName();
	    
	public List<OsgiFactoryConfigModule> getAllConfigs();
}
