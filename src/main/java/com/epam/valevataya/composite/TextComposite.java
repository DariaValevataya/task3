package com.epam.valevataya.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
  private List<TextComponent> componentsList;
  private TextType textType;

  public TextComposite(TextType textType) {
    this.textType = textType;
    this.componentsList=new ArrayList<>();
  }
  public TextComposite() {
  }
  public TextType getTextType() {
    return textType;
  }

  @Override
  public boolean add(TextComponent component) {
    return componentsList.add(component);
  }

  @Override
  public boolean remove(TextComponent component) {
    return componentsList.remove(component);
  }

  @Override
  public TextComponent getSubElement(int index) {
    return componentsList.get(index);
  }

  @Override
  public List<TextComponent> getTextComponentsList() {
    return componentsList;
  }

  public String toString() {
    StringBuilder stringBuilder = new StringBuilder();
    for (TextComponent component : componentsList) {
      stringBuilder.append(component);
    }
    return stringBuilder.toString();
  }
}

