package com.mysite.aem.core.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.injectorspecific.SlingObject;
import org.apache.sling.models.annotations.injectorspecific.ValueMapValue;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class AuthorDetails {
	@SlingObject
	SlingHttpServletRequest slingHttpServletRequest;

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
	public String getSelectit() {
		return selectit;
	}

	public boolean getGender() {
		return gender;
	}

	public List<String> getBooks() {
		if(books!=null) {
			return new ArrayList<String>(books);
		}else {
			return Collections.emptyList();
		}
	}
	
}
