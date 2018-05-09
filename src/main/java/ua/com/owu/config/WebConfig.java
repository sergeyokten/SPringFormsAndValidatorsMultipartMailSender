package ua.com.owu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.File;
import java.util.Properties;

@Configuration // this class will be generator for beans
@EnableWebMvc // activate MVC model
@ComponentScan("ua.com.owu.*") // look for some annotations (Repos ,Services , Controllers etc in defined packages)
public class WebConfig extends WebMvcConfigurerAdapter {

    @Bean // bean - object singleton
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/pages/");
        resolver.setSuffix(".jsp");
        return resolver;
    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //                           /avax/asdasdqsd.jpg
        registry.addResourceHandler("/avax/**")
                .addResourceLocations("file:" + System.getProperty("user.home") + File.separator
                        + "pics" + File.separator);

        // /myStyle/main.css ->
        registry.addResourceHandler("/myStyle/**").addResourceLocations("/styles/");
    }


    @Bean
    public JavaMailSender mailSender() {
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        mailSender.setUsername("sergey.okten@gmail.com");
        mailSender.setPassword("");


        Properties javaMailProperties = mailSender.getJavaMailProperties();

        javaMailProperties.setProperty("mail.transport.protocol", "smtp");
        javaMailProperties.setProperty("mail.smtp.auth", "true");
        javaMailProperties.setProperty("mail.smtp.starttls.enable", "true");
        javaMailProperties.setProperty("mail.debug", "true");
        return mailSender;

    }
}
