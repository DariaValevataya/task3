package com.epam.valevataya.composite;

import java.util.List;

public class Symbol implements TextComponent {
  private char symbol;
  private TextType textType;

  public Symbol(char value, TextType textType) {
    this.symbol = value;
    this.textType = textType;
  }

  public Symbol(char value) {
    this.symbol = value;
  }

  @Override
  public boolean add(TextComponent component) {
    throw new UnsupportedOperationException();
  }

  @Override
  public boolean remove(TextComponent component) {
    throw new UnsupportedOperationException();
  }

  @Override
  public TextComponent getSubElement(int index) {
    throw new UnsupportedOperationException();
  }

  @Override
  public List<TextComponent> getTextComponentsList() {
    throw new UnsupportedOperationException();
  }

  @Override
  public TextType getTextType() {
    return textType;
  }

  public void setTextType(TextType textType) {
    this.textType = textType;
  }

  @Override
  public String toString() {
    return String.valueOf(symbol);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Symbol symbol = (Symbol) o;
    return this.symbol == symbol.symbol
            && textType == symbol.textType;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + symbol;
    result = prime * result + (textType == null ? 0 : textType.hashCode());
    return result;
  }
}
