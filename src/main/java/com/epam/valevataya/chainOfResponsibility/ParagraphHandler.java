package com.epam.valevataya.chainOfResponsibility;

import com.epam.valevataya.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class ParagraphHandler extends AbstractTextHandler {
  public ParagraphHandler() {
    this.successor = new SentenseHandler();
  }
  @Override
  public void parse(String text, TextComposite composite) {
    List<String> sentences = new ArrayList<>();
    for (int i = 0; i < sentences.size(); i++) {
      successor.parse(sentences.get(i), composite);
    }
  }
}
