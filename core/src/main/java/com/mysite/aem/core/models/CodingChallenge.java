package com.mysite.aem.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;

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
//list. 	
@Model(adaptables = Resource.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)
public class CodingChallenge {
	
	@Inject
	private String name;

	@Inject
	private boolean gender;

	@Inject
	private List<String> books;
	
	@Inject
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
