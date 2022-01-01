package _3_InvestigatingDI;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static com.google.common.base.Preconditions.checkState;

public class Dispenser {
  /** Always returns null. The return of null here indicates that this is a dummy impl and should never be called. */
  public Candy dispense() {
    return null;
  }
}

class Candy {
  private final Sugar sugar;
  Candy(Sugar sugar) {
    this.sugar = sugar;
  }

  public Sugar getSugar() {return sugar;}
}

class Sugar {}

class TestDispenser {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter3/candy.xml");
    Dispenser dispenser = (Dispenser) injector.getBean("dispenser");
    Candy candy1 = dispenser.dispense();
    Candy candy2 = dispenser.dispense();
    checkState(candy1 != candy2);
    checkState(candy1.getSugar() != candy2.getSugar());
  }
}