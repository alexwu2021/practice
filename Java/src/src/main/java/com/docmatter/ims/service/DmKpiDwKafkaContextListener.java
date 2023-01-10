package com.docmatter.ims.service;

import com.docmatter.ims.config.DwEventStreamServiceConfig;
import com.docmatter.ims.service.kafka.BaseStreamService;
import com.docmatter.ims.service.kafka.DMKafkaStreamService;
import com.docmatter.ims.service.kafka.ServiceProps;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * DM KPI Dw kafka stream services context listener.
 * 
 * 
 *
 */
public class DmKpiDwKafkaContextListener implements ServletContextListener{
    
    private static final Logger logger = LoggerFactory.getLogger(DmKpiDwKafkaContextListener.class);

    private static final List<DMKafkaStreamService> streamServices = new LinkedList<>();


    @Override
    public void contextDestroyed(ServletContextEvent event) {
        logger.info("DmKpiDwKafkaContextListener destroying");
        System.out.println("*******************************DmKpiDwKafkaContextListener destroying****************************");
        try {
            List<Thread> shutdownThreads = new LinkedList<>();
            for (final DMKafkaStreamService service : streamServices) {
                shutdownThreads.add(service.stopService());
            }
            for (final Thread shutdownThread : shutdownThreads) {
                shutdownThread.join();
            }
            logger.info("DmKpiDwKafkaContextListener all streaming services destoryed");
        } catch (final Exception ex) {
            logger.error("Fail to destroy kafka context", ex);
        }
    }

    /**
     * 
     */
    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("------------------------------DmKpiDwKafkaContextListener contextInitializing-----------------------------");
        logger.info("DmKpiDwKafkaContextListener contextInitialized");
        try {
            ServiceProps props = new ServiceProps();
            List<String> serviceNames = props.getServiceClasses();
            List<BaseStreamService> services = new ArrayList<BaseStreamService>();
            if (serviceNames != null && serviceNames.size() > 0) {
                for (String serviceClassName: serviceNames) {
                    logger.info("service class name: "+serviceClassName);
                    if (serviceClassName != null && serviceClassName.length() > 0) {
                        BaseStreamService service = null;
                        try {
                            Class<?> cls = Class.forName(serviceClassName);
                            //service = (BaseStreamService)cls.newInstance();
                            if(true){
                                service = (new DwEventStreamServiceConfig()).getDwEventStreamService();
                                System.out.println("service was created from DwEventStreamServiceConfig");
                                if(service == null){
                                    System.out.println("service is still null");
                                }else{
                                    System.out.println("service is not null");
                                }
                            }

                            services.add(service);
                            logger.info("service class instance added: "+service.getClass().getName());
                            System.out.println("service class instance added: "+service.getClass().getName());
                        } catch (Exception ex) {
                            logger.error("Service class instance Error: "+serviceClassName, ex);
                            System.out.println(String.format("Service class instance Error: "+serviceClassName + "{}", ex));
                        }
                    }
                }
            }
            streamServices.clear();
            for (BaseStreamService service: services) {
                service.startService();
                streamServices.add(service);
                System.out.println(String.format("Service {} started", service.getClass().getName()));
                logger.info("Service {} started", service.getClass().getName());
            }

            logger.info("{} services started", streamServices.size());
        } catch (final Exception ex) {
            System.out.println(String.format("Fail to initialize kafka context exception {}", ex));
            logger.error("Fail to initialize kafka context", ex);
        }
        System.out.println("------------------------------DmKpiDwKafkaContextListener contextInitialized-----------------------------");
    }
    
}
