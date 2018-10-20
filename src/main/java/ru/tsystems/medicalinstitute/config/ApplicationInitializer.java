package ru.tsystems.medicalinstitute.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class ApplicationInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext annotationConfigWebApplicationContext = new AnnotationConfigWebApplicationContext();

        annotationConfigWebApplicationContext.setServletContext(servletContext);
        annotationConfigWebApplicationContext.scan("ru.tsystems.medicalinstitute.config");

        servletContext.addListener(new ContextLoaderListener(annotationConfigWebApplicationContext));
        servletContext.addListener(new RequestContextListener());

        ServletRegistration.Dynamic dynamic = servletContext.addServlet("dispatcher", new DispatcherServlet(annotationConfigWebApplicationContext));
        dynamic.addMapping("/");
        dynamic.setLoadOnStartup(1);
    }
}
