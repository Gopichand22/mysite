package com.mysite.aem.core.config;

import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.AttributeType;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;

@ObjectClassDefinition(name = "My Site-Modular Osgi Configuration", description = "Modular OSGi cofig")
public @interface OsgiConfig {

	@AttributeDefinition(name = "Student Id", description = "Enter student id", type = AttributeType.INTEGER)
	int studentId() default 578;

	@AttributeDefinition(name = "Student Name", description = "Enter student name", type = AttributeType.STRING)
	String studentName() default "Gopichand";
}
