package com.mysite.aem.core.services;

import java.util.ArrayList;
import java.util.List;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.ConfigurationPolicy;
import org.osgi.service.component.annotations.Modified;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.component.annotations.ReferenceCardinality;
import org.osgi.service.component.annotations.ReferencePolicy;
import org.osgi.service.metatype.annotations.Designate;

import com.mysite.aem.core.config.OsgiFactoryConfig;

@Component(service = OsgiFactoryConfigModule.class, configurationPolicy = ConfigurationPolicy.REQUIRE)
@Designate(ocd = OsgiFactoryConfig.class, factory = true)
public class OsgiFactoryConfigModuleImpl implements OsgiFactoryConfigModule {

//	    private static final Logger LOGGER = LoggerFactory.getLogger(OSGiFactoryConfigImpl.class);

	private int studentId;
	private String studentName;
	private List<OsgiFactoryConfigModule> configsList;

	@Activate
	@Modified
	protected void activate(final OsgiFactoryConfig config) {
		studentId = config.studentId();
		studentName = config.studentName();
	}

	@Reference(service = OsgiFactoryConfigModule.class, cardinality = ReferenceCardinality.MULTIPLE, policy = ReferencePolicy.DYNAMIC)
	public void bindOSGiFactoryConfig(final OsgiFactoryConfigModule configs) {
		if (configsList == null) {
			configsList = new ArrayList<>();
		}
		configsList.add(configs);

	}

	public void unbindOSGiFactoryConfig(final OsgiFactoryConfigModule config) {
		configsList.remove(config);
	}

	@Override
	public int getStudentId() {
		return studentId;
	}

	@Override
	public String getStudentName() {
		return studentName;
	}

	@Override
	public List<OsgiFactoryConfigModule> getAllConfigs() {
		return configsList;
	}
}
