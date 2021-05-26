package com.mysite.aem.core.models;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.OSGiService;

import com.mysite.aem.core.services.CsvReader;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CsvData {

	    @OSGiService

CsvReader csvReader;

	    public String getAsset() {
	        return csvReader.getDataFromCsvFile();
	    }

}
