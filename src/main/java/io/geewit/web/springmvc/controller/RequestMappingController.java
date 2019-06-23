package io.geewit.web.springmvc.controller;

import io.geewit.web.springmvc.model.UriModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
public class RequestMappingController {
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    Map<UriModel, String> mappings = null;

    @ResponseBody
    @RequestMapping(name = "请求资源表", value = {"/request_mappings"})
    public Map<UriModel, String> mappings() {
        if(mappings != null) {
            return mappings;
        }
        mappings = new HashMap<>();
        Map<RequestMappingInfo, HandlerMethod> handlerMethods = requestMappingHandlerMapping.getHandlerMethods();
        for(Map.Entry<RequestMappingInfo, HandlerMethod> requestMappingInfoEntry : handlerMethods.entrySet()) {
            RequestMappingInfo requestMappingInfo = requestMappingInfoEntry.getKey();
            HandlerMethod handlerMethod = requestMappingInfoEntry.getValue();
            Set<String> patterns = requestMappingInfo.getPatternsCondition().getPatterns();
            for(String pattern : patterns) {
                Set<RequestMethod> methods = requestMappingInfo.getMethodsCondition().getMethods();
                for(RequestMethod method : methods) {
                    UriModel uriModel = new UriModel(pattern, method);
                    RequestMapping requestMapping = handlerMethod.getMethodAnnotation(RequestMapping.class);
                    String resourceCode = requestMapping.name();
                    mappings.put(uriModel, resourceCode);
                }
            }
        }
        return mappings;
    }
}
