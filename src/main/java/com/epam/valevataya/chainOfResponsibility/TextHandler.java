package com.epam.valevataya.chainOfResponsibility;

import com.epam.valevataya.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class TextHandler extends AbstractTextHandler {

  public TextHandler() {
    this.successor = new ParagraphHandler();
  }

  @Override
  public void parse(String text, TextComposite composite) {
    List<String> paragraphs = new ArrayList<>();
    for (int i = 0; i < paragraphs.size(); i++) {
      successor.parse(paragraphs.get(i),composite);
    }
  }
}
