package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParagraphHandler extends AbstractTextHandler {
  private static final Logger logger = LogManager.getLogger();
  private static final String SENTENCE_REGEX = "(\\.|\\?|!|\\.{3})($|\\s)";

  public ParagraphHandler() {
    setSuccessor(new SentenceHandler());
  }

  @Override
  public void parse(String text, TextComponent component) {
    Matcher matcher = Pattern.compile(SENTENCE_REGEX).matcher(text);
    int start = 0;
    while (matcher.find()) {
      String sentence = text.substring(start, matcher.start() + 1);
      logger.info("Sentence: " + sentence);
      TextComponent sentenceComponent = new TextComposite(TextType.SENTENCE);
      component.add(sentenceComponent);
      getSuccessor().parse(sentence, component);
      start = matcher.end();
    }
  }
}
