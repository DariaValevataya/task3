package com.epam.valevataya.parser;

import com.epam.valevataya.composite.Symbol;
import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WordHandler extends AbstractTextHandler {
  private static final Logger logger = LogManager.getLogger();
  private static final String LETTER_REGEX = "[a-zA-Zа-яА-Я]";
  private static final String PUNCTUATION_REGEX = "\\p{Punct}";

  @Override
  public void parse(String text, TextComponent component) {
    for (int i = 0; i < text.length(); i++) {
      char ch = text.charAt(i);
      String strCh = String.valueOf(ch);
      if (strCh.matches(LETTER_REGEX)) {
        logger.info("Letter: " + strCh);
        Symbol symbol = new Symbol(ch, TextType.LETTER);
        component.add(symbol);
      } else if (strCh.matches(PUNCTUATION_REGEX)) {
        logger.info("Punct in word: " + strCh);
        Symbol symbol = new Symbol(ch, TextType.PUNCTUATION);
        component.add(symbol);
      } else {
        logger.warn("Unknown textType");
      }
    }
  }
}
