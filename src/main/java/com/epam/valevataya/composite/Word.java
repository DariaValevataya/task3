package com.epam.valevataya.composite;

public class Word implements TextComponent {
  private String value;

  public Word(String value) {
    this.value = value;
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
  public String toString() {
    return value;
  }
}
