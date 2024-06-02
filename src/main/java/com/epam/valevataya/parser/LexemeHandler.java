package com.epam.valevataya.parser;

import com.epam.valevataya.composite.Symbol;
import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeHandler extends AbstractTextHandler {
  public static final Logger logger = LogManager.getLogger();
  private static final String WORD_REGEX = "(?=[,.!?)])";
  private static final String PUNCTUATION_REGEX = "(\\p{Punct}|\\.{3})";

  public LexemeHandler() {
  setSuccessor(new WordHandler());
  }

  @Override
  public void parse(String text, TextComponent component) {
    String[] words = text.split(WORD_REGEX);
    for (String word: words) {
      if (word.matches(PUNCTUATION_REGEX)) {
        char ch = word.charAt(0);
        Symbol symbol = new Symbol(ch, TextType.PUNCTUATION);
        logger.info("Punctuation: "+word);
        component.add(symbol);
      } else {
        TextComponent wordComponent = new TextComposite(TextType.WORD);
        logger.info("Word: "+word);
        component.add(wordComponent);
        getSuccessor().parse(word, wordComponent);
      }
    }
  }
}
