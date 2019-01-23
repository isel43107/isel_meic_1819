package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/403").setViewName("403");
        
        registry.addViewController("/about").setViewName("demos/home");
        registry.addViewController("/hello").setViewName("demos/hello");
        registry.addViewController("/admin").setViewName("demos/admin");
        
        registry.addViewController("/tecnico").setViewName("demos/tecnico");
        registry.addViewController("/gestfin").setViewName("demos/gestor_financeiro");
        registry.addViewController("/comifin").setViewName("demos/comissao_financeiro");
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/jsp/");
        resolver.setSuffix(".jsp");
        resolver.setOrder(2);
        return resolver;
    }
}
