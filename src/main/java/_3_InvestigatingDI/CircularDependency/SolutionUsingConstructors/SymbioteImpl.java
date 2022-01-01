package _3_InvestigatingDI.CircularDependency.SolutionUsingConstructors;

public class SymbioteImpl implements Symbiote {
  private final Host host;
  private final int hostAge;

  public SymbioteImpl(Host host) {
    this.host = host;
    this.hostAge = host.calculateAge();
  }

  @Override
  public Host getHost() {
    return host;
  }

  @Override
  public int calculateAge() {
    return 21;
  }
}
