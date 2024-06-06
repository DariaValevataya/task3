package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TextHandler extends AbstractTextHandler {
  private static final Logger logger = LogManager.getLogger();

  private static final String PARAGRAPH_REGEX = "\\s{4}";

  public TextHandler() {
    setSuccessor(new ParagraphHandler());
  }

  @Override
  public void parse(String text, TextComponent component) {
    String[] paragraphs = text.split(PARAGRAPH_REGEX);
    for (String paragraph : paragraphs) {
      logger.info("Paragraph: " + paragraph);
      TextComponent paragraphComponent = new TextComposite(TextType.PARAGRAPH);
      component.add(paragraphComponent);
      getSuccessor().parse(paragraph.trim(), paragraphComponent);
    }
  }
}
