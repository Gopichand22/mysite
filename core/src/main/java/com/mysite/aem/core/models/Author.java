package com.mysite.aem.core.models;

import javax.inject.Inject;

import org.apache.sling.api.SlingHttpServletRequest;
import org.apache.sling.models.annotations.DefaultInjectionStrategy;
import org.apache.sling.models.annotations.Model;
import org.apache.sling.models.annotations.Via;

@Model(adaptables = SlingHttpServletRequest.class, defaultInjectionStrategy = DefaultInjectionStrategy.OPTIONAL)

public class Author {

	@Inject
	@Via("resource")
	String name;

	@Inject
	@Via("resource")
	int age;

	@Inject
	@Via("resource")
	boolean check;

	public String getFullName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean getCheck() {
		return check;
	}
	


}
