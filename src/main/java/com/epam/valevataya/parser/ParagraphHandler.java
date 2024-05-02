package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends AbstractTextHandler {
  private static final String SENTENCE_REGEX = "[\\.\\?!…]\\b";

  public ParagraphHandler() {
    setSuccessor(new SentenseHandler());
  }
  @Override
  public void parse(String text, TextComponent component) {
    Pattern sentencePattern = Pattern.compile(SENTENCE_REGEX);
    Matcher sentenceMatcher = sentencePattern.matcher(text);

    while(sentenceMatcher.find()){
      String sentence= sentenceMatcher.group();;
      TextComponent sentenceComponent=new TextComposite(TextType.SENTENCE);
      component.add(sentenceComponent);
      getSuccessor().parse(sentence,component);
    }
  }
}
