package com.epam.valevataya.composite;

public interface TextComponent {
  boolean add(TextComponent component);

  boolean remove(TextComponent component);

  TextComponent getSubElement(int index);

}
