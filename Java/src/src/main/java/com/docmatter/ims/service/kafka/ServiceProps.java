package com.docmatter.ims.service.kafka;

import com.docmatter.util.PropertiesUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * DM kafka stream services context listener.
 * 
 * @author hho
 *
 */
public class ServiceProps {
    
    private static final Logger logger = LoggerFactory.getLogger(ServiceProps.class);
    
    private static final String PROP_FILE = "prod/service.properties";
      
    public ServiceProps() {
    	
    }
    
    /**
     * 
     */ 
    public List<String> getServiceClasses() 
    throws Exception {
        logger.info("ServiceProps starting");
        try {
        	
        	Properties props = PropertiesUtil.loadProperties(PROP_FILE);
        	if (props == null) {
        		throw new Exception("No prop file found: "+PROP_FILE);
        	}
        	// get service Ids
        	String value = props.getProperty("service.ids");
        	String[] serviceIds = value.split(",");
        	List<String> services = new ArrayList<String>();
        	logger.info("service.ids: "+value);
        	for (String sid: serviceIds) {
        		sid = sid.trim();
        		if (sid != null && sid.length() > 0) {
        			// get service class
        			String serviceClassProp = "service."+sid;
        			String serviceClassName = props.getProperty(serviceClassProp).trim();
        			logger.info("service class name: "+serviceClassName);
        			if (serviceClassName !=null && serviceClassName.length() > 0) {
        				services.add(serviceClassName);
        			}
        		}
        	}
            logger.info("{} services found", services.size());
            return services;
        } catch (final Exception ex) {
            logger.error("Fail to initialize kafka context", ex);
            throw ex;
        }
    }
    
}
