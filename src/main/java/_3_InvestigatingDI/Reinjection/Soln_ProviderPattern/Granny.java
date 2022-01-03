package _3_InvestigatingDI.Reinjection.Soln_ProviderPattern;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Granny {
  private AppleProvider appleProvider;

  Granny(AppleProvider appleProvider) {
    this.appleProvider = appleProvider;
  }

  public void eat() {
    appleProvider.get().consume();
  }
}

class Apple {
  public void consume() {
    System.out.println(this + " apple eaten.");
  }
}

class Test {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter3/reinjection/providerPattern/appleProvider.xml");
    Granny granny = (Granny) injector.getBean("beans.granny");
    granny.eat(); // Apple@683dbc2c apple eaten.
    granny.eat(); // Apple@68267da0 apple eaten.
  }
}