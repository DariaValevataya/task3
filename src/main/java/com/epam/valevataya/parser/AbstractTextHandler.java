package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;

public abstract class AbstractTextHandler {
  private AbstractTextHandler successor;
  public void setSuccessor(AbstractTextHandler successor) {
    this.successor = successor;
  }
  public AbstractTextHandler getSuccessor() {
    return successor;
  }
  public abstract void parse(String text, TextComponent component);
}
