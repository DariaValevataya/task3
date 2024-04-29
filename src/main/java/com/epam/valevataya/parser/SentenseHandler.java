package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SentenseHandler extends AbstractTextHandler {
  private static final String WORD_REGEX = "\\b[A-Za-z]+\\b";
  private static final String PUNCTUATION_REGEX = "\\p{Punct}";
  public SentenseHandler() {
    setSuccessor(new WordHandler());
  }

  @Override
  public void parse(String text, TextComponent component) {
    Pattern wordPattern = Pattern.compile(WORD_REGEX);
    Matcher wordMatcher = wordPattern.matcher(text);

    Pattern punctuationPattern = Pattern.compile(PUNCTUATION_REGEX);
    Matcher punctuationMatcher = punctuationPattern.matcher(text);

    while (wordMatcher.find()) {
      String word = wordMatcher.group();
      TextComponent wordComponent = new TextComposite(TextType.WORD);
      component.add(wordComponent);
      getSuccessor().parse(word, component);
    }

    while (punctuationMatcher.find()) {
      String punctuation = punctuationMatcher.group();
      TextComponent punctuationComponent = new TextComposite(TextType.PUNCTUATION);
      component.add(punctuationComponent);
      getSuccessor().parse(punctuation, component);

    }
  }
}
