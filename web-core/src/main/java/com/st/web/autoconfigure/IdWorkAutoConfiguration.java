package com.st.web.autoconfigure;

import com.st.core.exception.keygen.IPSectionKeyGenerator;
import com.st.core.exception.keygen.KeyGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * IdWorkAutoConfiguration
 *
 * @author 枫竹
 * @version V1.0.0
 * @Title: IdWorkAutoConfiguration
 * @Package com.st.web.autoconfigure
 * @date 2018/11/9 15:15
 */
@Configuration
public class IdWorkAutoConfiguration{
        private static final Logger LOGGER = LoggerFactory.getLogger(IdWorkAutoConfiguration.class);

        @Bean
        @ConditionalOnClass(KeyGenerator.class)
        @ConditionalOnMissingBean
        public KeyGenerator initKeyGenerator() {
            LOGGER.debug("Init IdWork success.");
            return new IPSectionKeyGenerator();
        }
}
