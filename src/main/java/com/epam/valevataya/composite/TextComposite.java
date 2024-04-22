package com.epam.valevataya.composite;

import java.util.ArrayList;
import java.util.List;

public class TextComposite implements TextComponent {
  List<TextComponent> componentsList = new ArrayList<>();

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

  public String toString() {
    String result = "";
    for (TextComponent component : componentsList) {
      result += component.toString() + " ";
    }
    result += '\n';
    return result;
  }
}
