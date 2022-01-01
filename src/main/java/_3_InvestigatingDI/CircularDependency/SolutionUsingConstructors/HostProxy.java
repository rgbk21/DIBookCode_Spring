package _3_InvestigatingDI.CircularDependency.SolutionUsingConstructors;

/** A zero-dependency proxy wrapper for the HostImpl object that implements
 *  the same interface that HostImpl implements.
 * Any method called on the proxy */
public class HostProxy implements Host {
  private Host delegate;

  public void setDelegate(Host delegate) {
    this.delegate = delegate;
  }

  @Override
  public Symbiote getSymbiote() {
    return delegate.getSymbiote();
  }

  @Override
  public int calculateAge() {
    return delegate.calculateAge();
  }
}
