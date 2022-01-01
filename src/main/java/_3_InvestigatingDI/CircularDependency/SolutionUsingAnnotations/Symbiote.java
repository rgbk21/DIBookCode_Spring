package _3_InvestigatingDI.CircularDependency.SolutionUsingAnnotations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Symbiote {
  private final Host host;

  @Autowired
  Symbiote(Host host) {
    this.host = host;
  }

  public Host getHost() {
    return host;
  }
}
