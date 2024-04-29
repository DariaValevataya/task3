package com.epam.valevataya.parser;

import com.epam.valevataya.composite.Symbol;
import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordHandler extends AbstractTextHandler {
  @Override
  public void parse(String text, TextComponent component) {
    char[] letters = text.toCharArray();
    for (int i = 0; i < letters.length; i++) {
      TextComponent letterComponent = new Symbol(letters[i], TextType.LETTER);
      component.add(letterComponent);
    }
  }
}
