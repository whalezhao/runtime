/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alipay.sofa.koupleless.ext.web.gateway;

import com.alipay.sofa.koupleless.ext.autoconfigure.web.gateway.ForwardAutoConfiguration;
import org.apache.catalina.Context;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * <p>CrossContextConfiguration class.</p>
 *
 * @author zzl_i
 * @version 1.0.0
 */
@Configuration
@AutoConfigureAfter(ForwardAutoConfiguration.class)
@ComponentScan(basePackages = "com.alipay.sofa.koupleless.ext.web")
public class CrossContextConfiguration {
    /**
     * <p>tomcatCrossContextCustomizer.</p>
     *
     * @return a {@link org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer} object
     */
    @Bean
    @ConditionalOnClass(Context.class)
    @ConditionalOnBean(TomcatServletWebServerFactory.class)
    public TomcatContextCustomizer tomcatCrossContextCustomizer() {
        return ctx -> ctx.setCrossContext(true);
    }
}
