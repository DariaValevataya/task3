package com.epam.valevataya.chainOfResponsibility;

import com.epam.valevataya.composite.TextComposite;

import java.util.ArrayList;
import java.util.List;

public class SentenseHandler extends AbstractTextHandler {
  public SentenseHandler() {
    this.successor = new WordHandler();
  }

  @Override
  public void parse(String text, TextComposite composite) {
    List<String> words = new ArrayList<>();
    for (int i = 0; i < words.size(); i++) {
      successor.parse(words.get(i), composite);
    }
  }
}
