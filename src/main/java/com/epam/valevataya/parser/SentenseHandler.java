package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;

public class SentenseHandler extends AbstractTextHandler {
  private static final String LEXEME_REGEX = "\\s";

  public SentenseHandler() {
    setSuccessor(new LexemeHandler());
  }

  @Override
  public void parse(String text, TextComponent component) {
    String[] lexemes = text.split(LEXEME_REGEX);
    for (String lexeme : lexemes) {
      TextComponent lexemeComponent = new TextComposite(TextType.LEXEME);
      component.add(lexemeComponent);
      getSuccessor().parse(lexeme, lexemeComponent);
    }
  }
}
