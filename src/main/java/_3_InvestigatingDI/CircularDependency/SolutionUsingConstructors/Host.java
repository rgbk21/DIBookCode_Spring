package _3_InvestigatingDI.CircularDependency.SolutionUsingConstructors;

public interface Host {
  Symbiote getSymbiote();
  int calculateAge();
}
