package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SentenceHandler extends AbstractTextHandler {
  private static final Logger logger = LogManager.getLogger();
  private static final String LEXEME_REGEX = "\\s+";

  public SentenceHandler() {
    setSuccessor(new LexemeHandler());
  }

  @Override
  public void parse(String text, TextComponent component) {
    String[] lexemes = text.split(LEXEME_REGEX);
    for (String lexeme : lexemes) {
      logger.info("Lexeme: " + lexeme);
      TextComponent lexemeComponent = new TextComposite(TextType.LEXEME);
      component.add(lexemeComponent);
      getSuccessor().parse(lexeme, lexemeComponent);
    }
  }
}
