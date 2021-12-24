package _1_Basics;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SpellChecker {
  private Dict dictionary;

  @Autowired
  SpellChecker(Dict dictionary) {
    this.dictionary = dictionary;
  }

  public boolean validateText(String emailText) {
    System.out.println("Validating email text:" + emailText);
    return dictionary.isValidText(emailText);
  }
}
