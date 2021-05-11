package com.mysite.aem.core.services;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.metatype.annotations.Designate;

import com.mysite.aem.core.config.OsgiConfig;

@Component(service = OsgiConfigModule.class, immediate = true)
@Designate(ocd=OsgiConfig.class)
public class OsgiConfigModuleImpl implements OsgiConfigModule {
	int studentId;
	String studentName;
	
	@Activate
	protected void activate(OsgiConfig osgiConfig) {
		studentId=osgiConfig.studentId();
		studentName=osgiConfig.studentName();
	}
	
	@Override
	public int getStudentId() {
		return studentId;
	}

	@Override
	public String getStudentName() {
		return studentName;
	}

}
