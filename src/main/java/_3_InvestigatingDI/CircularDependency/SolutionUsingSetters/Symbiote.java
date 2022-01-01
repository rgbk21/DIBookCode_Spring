package _3_InvestigatingDI.CircularDependency.SolutionUsingSetters;

public class Symbiote {
  private Host host;

  Symbiote() {}

  public void setHost(Host host) {
    this.host = host;
  }

  public Host getHost() {
    return host;
  }
}
