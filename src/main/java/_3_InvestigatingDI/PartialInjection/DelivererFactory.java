package _3_InvestigatingDI.PartialInjection;

/** Factory to help Spring build the objects. This factory will be injected wherever code requires
 * an instance of Deliverer object. */
public interface DelivererFactory {
  public Deliverer create(NewsLetter newsLetter, String date);
}
