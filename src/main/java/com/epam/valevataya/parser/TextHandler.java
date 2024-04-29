package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextHandler extends AbstractTextHandler {
  private static final String PARAGRAPH_REGEX = "\\t";

  public TextHandler() {
    setSuccessor(new ParagraphHandler());
  }

  @Override
  public void parse(String text, TextComponent component) {
    Pattern paragraphPattern = Pattern.compile(PARAGRAPH_REGEX);
    Matcher paragraphMatcher = paragraphPattern.matcher(text);

    while (paragraphMatcher.find()) {
      String paragraph = paragraphMatcher.group();
      TextComponent paragraphComponent = new TextComposite(TextType.PARAGRAPH);
      component.add(paragraphComponent);
      getSuccessor().parse(paragraph, component);
    }
  }
}
