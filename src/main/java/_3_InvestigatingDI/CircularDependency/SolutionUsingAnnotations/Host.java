package _3_InvestigatingDI.CircularDependency.SolutionUsingAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class Host {
  private final Symbiote symbiote;

  @Autowired
  Host(@Lazy Symbiote symbiote) {
    this.symbiote = symbiote;
  }

  public Symbiote getSymbiote() {
    return symbiote;
  }
}
