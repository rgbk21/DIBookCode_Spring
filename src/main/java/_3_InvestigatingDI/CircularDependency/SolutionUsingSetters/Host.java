package _3_InvestigatingDI.CircularDependency.SolutionUsingSetters;

class Host {
  private Symbiote symbiote;

  Host() {}

  public void setSymbiote(Symbiote symbiote) {
    this.symbiote = symbiote;
  }

  public Symbiote getSymbiote() {
    return symbiote;
  }
}
