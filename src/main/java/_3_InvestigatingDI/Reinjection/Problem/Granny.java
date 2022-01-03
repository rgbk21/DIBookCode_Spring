package _3_InvestigatingDI.Reinjection.Problem;

public class Granny {
  private Apple apple;

  Granny(Apple apple) {
    this.apple = apple;
  }

  public void eat() {
    apple.consume();
    apple.consume();
  }
}

class Apple {
  public void consume() {
    System.out.println("Apple eaten.");
  }
}
