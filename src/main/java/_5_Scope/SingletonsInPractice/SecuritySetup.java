package _5_Scope.SingletonsInPractice;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

public class SecuritySetup {

}

class MasterTerminal {
  public MasterTerminal() {
    System.out.println("MasterTerminal Constructor Called");
  }
}

class SimpleCamera {
  private final MasterTerminal masterTerminal;

  public SimpleCamera(MasterTerminal masterTerminal) {
    this.masterTerminal = checkNotNull(masterTerminal);
  }

  public MasterTerminal getMasterTerminal() {
    return masterTerminal;
  }
}

class Test {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter5/SingletonsInPractice/terminal.xml");
    SimpleCamera basementCam1 = (SimpleCamera) injector.getBean("camera.basement");
    SimpleCamera penthouseCam1 = (SimpleCamera) injector.getBean("camera.penthouse");

    // We are verifying that the same instance of MasterTerminal is injected into both the dependents
    checkState(basementCam1 != penthouseCam1);
    checkState(basementCam1.getMasterTerminal() == penthouseCam1.getMasterTerminal());

    // Since 'camera.basement' and 'camera.penthouse' are defined as prototype, obtaining more beans from the injector will create and return
    // new instances of the SimpleCamera class
    SimpleCamera basementCam2 = (SimpleCamera) injector.getBean("camera.basement");
    SimpleCamera penthouseCam2 = (SimpleCamera) injector.getBean("camera.penthouse");
    checkState(basementCam1 != basementCam2);
    checkState(penthouseCam1 != penthouseCam2);

  }
}

class SingletonTest {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter5/SingletonsInPractice/singletonTerminal.xml");
    SimpleCamera basementCam1 = (SimpleCamera) injector.getBean("camera.basement");
    SimpleCamera penthouseCam1 = (SimpleCamera) injector.getBean("camera.penthouse");

    checkState(basementCam1 != penthouseCam1);
    checkState(basementCam1.getMasterTerminal() == basementCam1.getMasterTerminal());

    // The same class, SimpleCamera, now has two instances. Despite being bound to a Singleton key.
    System.out.println("basementCam1: " + basementCam1); // SimpleCamera@610f7aa
    System.out.println("penthouseCam1: " + penthouseCam1); // SimpleCamera@6a03bcb1

    System.out.println("basementCam1.getMasterTerminal(): " + basementCam1.getMasterTerminal()); // MasterTerminal@21b2e768
    System.out.println("penthouseCam1.getMasterTerminal(): " + penthouseCam1.getMasterTerminal()); // MasterTerminal@21b2e768

    // Asking the injector for new instances of the cams now returns the previously created instances
    SimpleCamera basementCam2 = (SimpleCamera) injector.getBean("camera.basement");
    SimpleCamera penthouseCam2 = (SimpleCamera) injector.getBean("camera.penthouse");

    checkState(basementCam1 == basementCam2);
    checkState(penthouseCam1 == penthouseCam2);

    System.out.println("basementCam2: " + basementCam2); // SimpleCamera@610f7aa
    System.out.println("penthouseCam2: " + penthouseCam2); // SimpleCamera@6a03bcb1
  }
}

class MixedTest {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter5/SingletonsInPractice/mixedTerminal.xml");
    SimpleCamera basementCam1 = (SimpleCamera) injector.getBean("camera.basement");
    SimpleCamera penthouseCam1 = (SimpleCamera) injector.getBean("camera.penthouse");

    // We are verifying that the same instance of MasterTerminal is injected into both the dependents
    checkState(basementCam1 != penthouseCam1);
    checkState(basementCam1.getMasterTerminal() == penthouseCam1.getMasterTerminal());

    System.out.println("basementCam1: " + basementCam1); // SimpleCamera@610f7aa
    System.out.println("penthouseCam1: " + penthouseCam1); // SimpleCamera@6a03bcb1

    // 'camera.basement' is now defined as a singleton, and hence the instance returned by the injector
    // should be the same as the previous instance
    SimpleCamera basementCam2 = (SimpleCamera) injector.getBean("camera.basement");
    checkState(basementCam1 == basementCam2);
    System.out.println("basementCam2: " + basementCam2); // SimpleCamera@610f7aa

    // 'camera.penthouse' is defined as prototype, obtaining more beans from the injector will create and return
    // new instances of the SimpleCamera class
    SimpleCamera penthouseCam2 = (SimpleCamera) injector.getBean("camera.penthouse");
    checkState(penthouseCam1 != penthouseCam2);
    System.out.println("penthouseCam2: " + penthouseCam2); // SimpleCamera@21b2e768
  }
}