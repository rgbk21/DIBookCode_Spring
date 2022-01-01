package _3_InvestigatingDI.CircularDependency.SolutionUsingConstructors;

public class HostImpl implements Host {
  private final Symbiote symbiote;

  public HostImpl(Symbiote symbiote) {
    this.symbiote = symbiote;
  }

  @Override
  public Symbiote getSymbiote() {
    return symbiote;
  }

  @Override
  public int calculateAge() {
    return 42;
  }
}
