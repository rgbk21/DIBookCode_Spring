package _3_InvestigatingDI.CircularDependency.Problem;

class Host {
  private final Symbiote symbiote;

  Host(Symbiote symbiote) {
    this.symbiote = symbiote;
  }
}
