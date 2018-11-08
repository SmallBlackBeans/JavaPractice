package com.hanxiaocu.rest.config;

import org.beetl.core.GroupTemplate;
import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.simulate.WebSimulate;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;

/**
 * Description:
 * User: hanchenghai
 * Date: 2018/10/28
 */
@Configuration
public class BeetlConfig {

    @Value("${beetl.RESOURCE.root:/templates}")
    private String templatesPath;

    @Bean(initMethod = "init", name = "beetlConf")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ClassLoader                 loader                      = Thread.currentThread().getContextClassLoader();
        if (loader == null) {
            loader = BeetlConfig.class.getClassLoader();
        }
        //beetlGroupUtilConfiguration.setConfigProperties(extProperties);//额外的配置，可以覆盖默认配置，一般不需要
        ClasspathResourceLoader cploder = new ClasspathResourceLoader(loader,
                templatesPath);
        beetlGroupUtilConfiguration.setResourceLoader(cploder);
        beetlGroupUtilConfiguration.init();
        //如果使用了优化编译器，涉及到字节码操作，需要添加ClassLoader
        beetlGroupUtilConfiguration.getGroupTemplate().setClassLoader(loader);
        return beetlGroupUtilConfiguration;
    }

    @Bean(name = "viewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConf") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setPrefix("templates/");
        beetlSpringViewResolver.setSuffix(".btl");
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

    @Bean
    public WebSimulate webSimulate(@Qualifier("viewResolver") BeetlSpringViewResolver resolver) {
        WebSimulate webSimulate = new WebSimulate(resolver.getConfig().getGroupTemplate()) {
        };
        return webSimulate;
    }

}
