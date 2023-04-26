package com.uniovi.sdi;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class CustomConfiguration extends WsConfigurerAdapter {
    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext
                                                                    applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/webservice/*");
    }

    @Bean(name = "marks")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema marksSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("MarksPort");
        wsdl11Definition.setLocationUri("/webservice/marks");
        wsdl11Definition.setTargetNamespace("http://uniovi.com/sdi/soap/ws");
        wsdl11Definition.setSchema(marksSchema);
        return wsdl11Definition;
    }

    @Bean
    public XsdSchema marksSchema() {
        return new SimpleXsdSchema(new ClassPathResource("xsd/marks.xsd"));
    }
}
