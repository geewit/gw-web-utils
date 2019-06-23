package io.geewit.web.springmvc.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@ConditionalOnExpression("${request.mappings.info.endpoint.enable:true}")
@ConditionalOnClass({RequestMappingHandlerMapping.class})
@Configuration
public class RequestMappingInfoConfiguration {

}
