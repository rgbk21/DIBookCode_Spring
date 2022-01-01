package _3_InvestigatingDI.CircularDependency.SolutionUsingSetters;

import com.google.common.base.Preconditions;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

class Test {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter3/setter/symbioteSetter.xml");
    Host host = (Host) injector.getBean("host");
    Symbiote symbiote = (Symbiote) injector.getBean("symbiote");

    Preconditions.checkState(symbiote.getHost() == host);
    Preconditions.checkState(host.getSymbiote() == symbiote);
  }
}
