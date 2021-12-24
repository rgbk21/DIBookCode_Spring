package _1_Basics;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class Emailer {
  private final SpellChecker spellChecker;

  @Autowired
  public Emailer(SpellChecker spellChecker) {
    this.spellChecker = spellChecker;
  }

  public void send(String emailText) {
    spellChecker.validateText(emailText);
  }
}

class EmailClient {
  private final Emailer emailer;

  EmailClient(Emailer emailer) {
    this.emailer = emailer;
  }

  public void sendEmail() {
    emailer.send("This is the email text!");
  }
}

class Test {
  public static void main(String[] args) {
    BeanFactory injector = new ClassPathXmlApplicationContext("email-actual-autowire-config.xml");
    Emailer emailer = (Emailer) injector.getBean("emailer");
    emailer.send("This is from the Spring Context");
  }
}