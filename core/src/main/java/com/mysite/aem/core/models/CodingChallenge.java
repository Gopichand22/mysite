package com.mysite.aem.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

//********dialog/component creation*************
//multifield,
//boolean,
//selection,
//image.
//***********Sightly things************
//data-sly-template,
//resource,
//test,
//call,
//use,
//repeat,
//list,
//attribute. 	
@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CodingChallenge {
	
	@ValueMapValue
	private String name;

	@ValueMapValue
	private boolean gender;

	@ValueMapValue
	private List<String> books;
	
	@ValueMapValue
	private String selectit;
	
	public String getName() {
		return name;
	}
	
	public boolean getGender() {
		return gender;
	}
	
	public String getSelectit() {
		return selectit;
	}
	
	public List<String> getBooks() {
		if(books!=null) {
			return new ArrayList<String>(books);
		}else {
			return Collections.emptyList();
		}
	}
}
