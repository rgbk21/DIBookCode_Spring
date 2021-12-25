package _1_Basics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class EnglishSpellChecker implements SpellChecker {

  private final Dict dictionary;

  public EnglishSpellChecker(Dict dictionary) {
    this.dictionary = dictionary;
  }

  @Override
  public boolean validateText(String emailText) {
    dictionary.isValidText(emailText);
    System.out.println("In English SpellChecker");
    return true;
  }
}
