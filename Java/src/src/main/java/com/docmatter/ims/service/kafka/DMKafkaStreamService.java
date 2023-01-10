package com.docmatter.ims.service.kafka;

/**
 * Kafka streaming service interface.
 * 
 * @author hho
 *
 */
public interface DMKafkaStreamService {
    
    /** Start service. */
    public void startService();
    
    /**
     * Stop service.
     * This method should not block, and should return a shutdown thread.
     * 
     * @return shutdown thread.
     */
    public Thread stopService();
    
}