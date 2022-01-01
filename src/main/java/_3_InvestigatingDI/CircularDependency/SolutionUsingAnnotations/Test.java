package _3_InvestigatingDI.CircularDependency.SolutionUsingAnnotations;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static com.google.common.base.Preconditions.checkState;

public class Test {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter3/annotations/symbioteAnnotations.xml");
    Host host = (Host) injector.getBean("host");
    Symbiote symbiote = (Symbiote) injector.getBean("symbiote");

    checkState(symbiote.getHost() == host);
    checkState(host.getSymbiote() != symbiote);
  }
}
