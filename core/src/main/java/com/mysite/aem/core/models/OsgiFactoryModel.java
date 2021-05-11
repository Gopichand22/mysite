package com.mysite.aem.core.models;

import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mysite.aem.core.services.OsgiFactoryConfigModule;

@Model(adaptables=SlingHttpServletRequest.class,defaultInjectionStrategy=DefaultInjectionStrategy.OPTIONAL)
public class OsgiFactoryModel {
	
	@OSGiService
	OsgiFactoryConfigModule osgiFactoryConfigModule;
	
	public List<OsgiFactoryConfigModule> getAllConfigs(){
		return osgiFactoryConfigModule.getAllConfigs();
	}

}
