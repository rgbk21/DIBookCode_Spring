package _1_Basics;


public class SpellChecker {
  private Dict dictionary;

  SpellChecker(Dict dictionary) {
    this.dictionary = dictionary;
  }

  public boolean validateText(String emailText) {
    System.out.println("Validating email text:" + emailText);
    return dictionary.isValidText(emailText);
  }
}
