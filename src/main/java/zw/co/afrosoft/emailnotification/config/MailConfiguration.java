package zw.co.afrosoft.emailnotification.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

public class MailConfiguration {

    @Autowired
    private Environment environment;

    @Bean
    public JavaMailSender getMailSender(){
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(environment.getProperty("spring.mail.host"));
        mailSender.setPassword("spring.mail.password");
        mailSender.setUsername("spring.mail.username");
        mailSender.setPort(Integer.valueOf(environment.getProperty("spring.mail.port")));

        Properties javaMailProperties = new Properties();
        javaMailProperties.put("mail.smpt.starttls.enable","true");
        javaMailProperties.put("mail.smpt.auth","true");
        javaMailProperties.put("mail.transport.protocol","true");
        javaMailProperties.put("mail.debug","true");

        mailSender.setJavaMailProperties(javaMailProperties);
        return mailSender;
    }
}
