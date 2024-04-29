package com.epam.valevataya;

import com.epam.valevataya.composite.Symbol;
import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.parser.AbstractTextHandler;
import com.epam.valevataya.parser.TextHandler;
import com.epam.valevataya.reader.TextReader;
import com.epam.valevataya.reader.impl.TextReaderImpl;

public class Main {
  public static void main(String[] args) throws TextException {
    TextReader textReader=new TextReaderImpl();
    String text= textReader.readFile("data/textData.txt");
    TextComponent textComponent=new TextComposite();
    AbstractTextHandler textHandler=new TextHandler();
    textHandler.parse(text, textComponent);
  System.out.println();
  }
}
