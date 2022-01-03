package _3_InvestigatingDI.Reinjection.Soln_MethodDecoration;

public class Granny {

  // Drawback: The object dependency now no longer makes it explicit that Granny
  // depends on an Apple
  Granny() {}

  /** Use method decoration to return a new instance of Apple everytime this is called */
  public Apple getApple() {
    return null;
  }

  public void eat() {
    getApple().consume();
    getApple().consume();
  }
}

class Apple {
  public void consume() {
    System.out.println("Apple eaten.");
  }
}
