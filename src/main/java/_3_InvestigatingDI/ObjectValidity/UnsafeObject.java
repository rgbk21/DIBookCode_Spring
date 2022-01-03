package _3_InvestigatingDI.ObjectValidity;

import java.util.List;

public class UnsafeObject {
  private List<Slippery> slippery;
  private Shady shady;

  // Nullary constructor that does nothing
  public UnsafeObject() {
    System.out.println("Inside the UnsafeObject constructor");
  }

  public void setSlippery(Slippery slippery) {
    System.out.println("Inside the setSlippery method");
    this.slippery = List.of(slippery);
  }

  public void setShady(Shady shady) {
    System.out.println("Inside the setShady method");
    this.shady = shady;
  }

  public void init() {
    System.out.println("Inside the init method");
  }
}

class Slippery {
  Slippery() {
    System.out.println("Inside the constructor for Slippery");
  }
}
class Shady {
  Shady() {
    System.out.println("Inside the constructor for Shady");
  }
}
