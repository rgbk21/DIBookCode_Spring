package _1_Basics;

public class FrenchSpellChecker implements SpellChecker {
  private final Dict dictionary;

  public FrenchSpellChecker(Dict dictionary) {
    this.dictionary = dictionary;
  }

  @Override
  public boolean validateText(String emailText) {
    System.out.println("In French SpellChecker");
    dictionary.isValidText(emailText);
    return true;
  }
}
