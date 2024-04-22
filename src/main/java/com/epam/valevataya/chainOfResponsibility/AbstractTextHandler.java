package com.epam.valevataya.chainOfResponsibility;

import com.epam.valevataya.composite.TextComposite;

public abstract class AbstractTextHandler {
  public AbstractTextHandler successor;

  public abstract void parse(String text, TextComposite composite);
}
