package _1_Basics;

import _1_Basics.SpringConfig.EmailBeanConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Emailer {
  private final SpellChecker spellChecker;

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
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
    context.register(EmailBeanConfig.class);
    context.refresh();

    // If you had just a single object of a particular type, you could have fetched the object using
    // the type of the object
    EnglishSpellChecker englishSpellChecker = context.getBean(EnglishSpellChecker.class);
    englishSpellChecker.validateText("Directly from the spellchecker");

    Emailer frenchEmailer = (Emailer) context.getBean("emailer.french");
    frenchEmailer.send("This is a french email");

    // If a custom bean name has not been specified, then the method name becomes the name of the bean
    Emailer englishEmailer = (Emailer) context.getBean("englishEmailer");
    englishEmailer.send("This is an english email");
  }
}