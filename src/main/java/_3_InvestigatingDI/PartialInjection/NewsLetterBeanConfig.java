package _3_InvestigatingDI.PartialInjection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NewsLetterBeanConfig {
  @Bean
  public EmailService emailService() {
    return new EmailService();
  }

  @Bean
  public NewsLetterManager newsLetterManager() {
    return new NewsLetterManager(delivererFactory());
  }

  @Bean
  public DelivererFactory delivererFactory() {
    return new DelivererFactoryImpl();
  }
}
