package com.arief.mvc.configs;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{
            SpringRootAppContext.class
        };
    }

    protected Class<?>[] getServletConfigClasses() {
        return new Class[]{
            MyWebApplicationContext.class
        };
    }

    protected String[] getServletMappings() {
        return new String[]{
                "/mvc/*"
        };
    }
}
