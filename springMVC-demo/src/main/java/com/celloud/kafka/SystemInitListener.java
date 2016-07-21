package com.celloud.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

@Component
public class SystemInitListener implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(SystemInitListener.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("inited......");
    }

}
