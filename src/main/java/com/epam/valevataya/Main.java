package com.epam.valevataya;

import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.reader.TextReader;
import com.epam.valevataya.reader.impl.TextReaderImpl;

public class Main {
  public static void main(String[] args) throws TextException {
    TextReader reader = new TextReaderImpl();
    String text = reader.readFile("data/textData.txt");

  }
}
