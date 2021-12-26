package _1_Basics.SpringConfig;

import _1_Basics.Dict;
import _1_Basics.Emailer;
import _1_Basics.EnglishSpellChecker;
import _1_Basics.FrenchSpellChecker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmailBeanConfig {

  @Bean
  public Emailer englishEmailer() {
    return new Emailer(englishSpellChecker());
  }

  @Bean("emailer.french")
  public Emailer frenchEmailer() {
    return new Emailer(frenchSpellChecker());
  }

  @Bean
  public EnglishSpellChecker englishSpellChecker() {
    return new EnglishSpellChecker(dictionary());
  }

  @Bean
  public FrenchSpellChecker frenchSpellChecker() {
    return new FrenchSpellChecker(dictionary());
  }

  @Bean
  public Dict dictionary() {
    return new Dict();
  }
}
