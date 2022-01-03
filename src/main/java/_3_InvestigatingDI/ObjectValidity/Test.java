package _3_InvestigatingDI.ObjectValidity;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Test {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter3/objectValidity/unsafeObject.xml");
    UnsafeObject unsafeObject = (UnsafeObject) injector.getBean("unsafeObject");
  }
}
