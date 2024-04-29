package com.epam.valevataya.composite;

import java.util.List;

public class Symbol implements TextComponent {
  private char symbol;
  private TextType textType;

  public Symbol(char value, TextType textType) {

    this.symbol = value;
    this.textType=textType;
  }

  @Override
  public boolean add(TextComponent component) {
    return false;
  }

  @Override
  public boolean remove(TextComponent component) {
    return false;
  }

  @Override
  public TextComponent getSubElement(int index) {
    return null;
  }

  @Override
  public List<TextComponent> getTextComponentsList() {
    return null;
  }

  @Override
  public String toString() {
    return symbol+"";
  }
}
