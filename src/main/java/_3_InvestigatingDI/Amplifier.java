package _3_InvestigatingDI;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Amplifier {
  private Guitar guitar;
  private Speaker speaker;
  private Footpedal footpedal;

  public Amplifier setGuitar(Guitar guitar) {
    this.guitar = guitar;
    return this;
  }

  public Amplifier setSpeaker(Speaker speaker) {
    this.speaker = speaker;
    return this;
  }

  public Amplifier setFootpedal(Footpedal footpedal) {
    this.footpedal = footpedal;
    return this;
  }

  public void playMusic() {
    System.out.println("WAAAAAH!");
  }
}

class Guitar {}
class Speaker {}
class Footpedal {}

class Test {
  public static void main(String[] args) {
    BeanFactory injector = new FileSystemXmlApplicationContext("src/main/resources/chapter3/amplifier.xml");
    Amplifier amplifier = (Amplifier) injector.getBean("amplifier-encapsulated");
    amplifier.playMusic();
  }
}