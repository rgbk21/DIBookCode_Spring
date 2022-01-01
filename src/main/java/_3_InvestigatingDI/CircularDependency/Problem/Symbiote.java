package _3_InvestigatingDI.CircularDependency.Problem;

class Symbiote {
  private final Host host;

  Symbiote(Host host) {
    this.host = host;
  }
}
