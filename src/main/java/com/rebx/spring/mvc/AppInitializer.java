package com.rebx.spring.mvc;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitializer implements WebApplicationInitializer {

  private static final String servletName = "appServlet";
  private static final String rootMapping = "/";

  @Override
  public void onStartup(ServletContext servletContext) throws ServletException {

    WebApplicationContext ctx = getContext();

    servletContext.addListener(new ContextLoaderListener(ctx));
    final DispatcherServlet dispServlet = new DispatcherServlet(ctx);
    ServletRegistration.Dynamic dispatcher = servletContext.addServlet(servletName, dispServlet);
    dispatcher.setLoadOnStartup(1);
    dispatcher.addMapping(rootMapping);
  }

  private WebApplicationContext getContext() {
    AnnotationConfigWebApplicationContext wac = new AnnotationConfigWebApplicationContext();
    wac.setConfigLocation("com.rebx.spring.config");
    return wac;
  }

}
