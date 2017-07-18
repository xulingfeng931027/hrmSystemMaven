package paul.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * Created by paul on 2017-06-14.
 * 该文件用于配置Spring的视图解析器,为了解析jsp采用ViewResolver对象
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"paul.web.*"})
public class WebMVCConfig extends WebMvcConfigurerAdapter {
    @Bean
    public ViewResolver viewResolver() {
        //配置jsp视图解析器
        InternalResourceViewResolver resolver =
                new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        resolver.setViewClass(JstlView.class);
        resolver.setExposeContextBeansAsAttributes(true);
        return resolver;
    }

//    @Override
//    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/WEB-INF/views/taglib.jsp");
//    }

//    //配置自定义拦截器
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        InterceptorRegistration registration = registry.addInterceptor(new AuthorizedInterceptor());
//        //设置拦截的路径，不设置则拦截所有Servlet
//        // registration.addPathPatterns("/");
//    }

    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        //配置静态资源处理
        configurer.enable();
    }

    //如果在3.0容器可以使用Part对象上传文件,就可以不配置这个解析器
//    @Bean
//    public MultipartResolver multipartResolver() {
//        StandardServletMultipartResolver standardServletMultipartResolver= new StandardServletMultipartResolver();
//        return  standardServletMultipartResolver;
//    }
}
