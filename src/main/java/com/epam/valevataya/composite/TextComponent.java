package com.epam.valevataya.composite;

import java.util.List;

public interface TextComponent {
  boolean add(TextComponent component);

  boolean remove(TextComponent component);

  TextComponent getSubElement(int index);
  List<TextComponent> getTextComponentsList();

}
