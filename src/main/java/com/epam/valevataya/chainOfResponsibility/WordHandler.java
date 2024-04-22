package com.epam.valevataya.chainOfResponsibility;

import com.epam.valevataya.composite.TextComposite;

public class WordHandler extends AbstractTextHandler {
  @Override
  public void parse(String text, TextComposite composite) {
    System.out.println(text);
  }
}
