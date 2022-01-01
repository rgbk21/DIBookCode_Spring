package _3_InvestigatingDI.CircularDependency.SolutionUsingConstructors;
import com.google.common.base.Preconditions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static com.google.common.base.Preconditions.checkState;

class Test {
  public static void main(String[] args) {
    // This is what we are basically doing. Comment to compile.
    HostProxy proxy = new HostProxy();
    SymbioteImpl symbiote = new SymbioteImpl(proxy);
    HostImpl host = new HostImpl(symbiote);
    proxy.setDelegate(host);

//    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter3/constructor/symbioteConstructor.xml");
//    Host host = (Host) injector.getBean("host");
//    Symbiote symbiote = (Symbiote) injector.getBean("symbiote");
//
//    checkState(host.getSymbiote() == symbiote);
//    checkState(symbiote.getHost() != host);
  }
}
