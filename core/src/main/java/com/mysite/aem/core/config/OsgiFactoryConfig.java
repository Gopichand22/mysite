package com.mysite.aem.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My Site-Factory Modular Osgi Factory Configuration", description = "Osgi factory module")
public @interface OsgiFactoryConfig {
	@AttributeDefinition(name = "Student ID", description = "Enter student id.", type = AttributeType.INTEGER)
	int studentId();

	@AttributeDefinition(name = "Student Name", description = "Enter student name.", type = AttributeType.STRING)
	public String studentName() default "P gopichand #";

}
