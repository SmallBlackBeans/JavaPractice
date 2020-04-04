package com.hanxiaocu.ws.webservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.server.EndpointInterceptor;
import org.springframework.ws.soap.SoapVersion;
import org.springframework.ws.soap.saaj.SaajSoapMessageFactory;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

import javax.servlet.ServletRegistration;
import java.util.List;

/**
 * @desc: wx 配置
 * @author: hanchenghai
 * @date: 2018/11/13 11:50 AM
 *
 * http://127.0.0.1:8099/ws/author.wsdl
 */
@Configuration
//开启webservice
@EnableWs
public class WebServiceConfig extends WsConfigurerAdapter {
	@Bean
	public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
		MessageDispatcherServlet servlet = new MessageDispatcherServlet();
		servlet.setApplicationContext(context);
		//true 地址会进行转换，不然都是本地地址
		servlet.setTransformWsdlLocations(true);
		//这里可以设置 请求的工厂类，实现有两个：SaajSoapMessageFactory 和 AxiomSoapMessageFactory
		//默认是 SaajSoapMessageFactory
		//servlet.setMessageFactoryBeanName(messageFactoryBeanName);
		return new ServletRegistrationBean(servlet, "/ws/*");
	}

	//name 就是对应 wsdl名如 ：/ws/author.wsdl
	@Bean(name = "author")
	public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema authorSchema) {
		DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
		wsdl11Definition.setPortTypeName("AuthorPort");
		wsdl11Definition.setLocationUri("/ws");
		wsdl11Definition.setSchema(authorSchema);
		wsdl11Definition.setTargetNamespace(WsConst.NAMESPACE_URI);
		return wsdl11Definition;
	}

	//可自定义SaajSoapMessageFactory 然后指定其SOAP版本
	@Bean
	public SaajSoapMessageFactory messageFactory() {
		SaajSoapMessageFactory messageFactory = new SaajSoapMessageFactory();
		//指定版本
		messageFactory.setSoapVersion(SoapVersion.SOAP_11);
		return messageFactory;
	}

	@Bean
	public XsdSchema authorSchema() {
		return new SimpleXsdSchema(new ClassPathResource("xsd/author.xsd"));
	}

	@Override
	public void addInterceptors(List<EndpointInterceptor> interceptors) {
		//可以自定义拦截器
	}
}
