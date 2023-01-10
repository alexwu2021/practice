package com.docmatter.ims.config;

import com.docmatter.ims.service.kafka.DwEventStreamService;
import com.docmatter.ims.service.kafka.DwFeedEventStoringFacility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.docmatter.ims.config")
public class DwEventStreamServiceConfig {

    @Autowired
    private DwFeedEventStoringFacility dwFeedEventStoringFacility;

    private static DwEventStreamService _dwEventStreamService;

    @Bean
    public DwEventStreamService getDwEventStreamService() {
        if(_dwEventStreamService == null){
            _dwEventStreamService = new DwEventStreamService(this.dwFeedEventStoringFacility);
        }
        return _dwEventStreamService;
    }
}