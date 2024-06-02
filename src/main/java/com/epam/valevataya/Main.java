package com.epam.valevataya;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;
import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.parser.AbstractTextHandler;
import com.epam.valevataya.parser.TextHandler;
import com.epam.valevataya.reader.TextReader;
import com.epam.valevataya.reader.impl.TextReaderImpl;
import com.epam.valevataya.service.TextService;
import com.epam.valevataya.service.impl.TextServiceImpl;

public class Main {
  public static void main(String[] args) throws TextException {
    TextReader reader = new TextReaderImpl();
    String text = reader.readFile("data/textData.txt");
    AbstractTextHandler handler = new TextHandler();
    TextComponent component = new TextComposite(TextType.TEXT);
    handler.parse(text, component);
    System.out.println(component);

    TextService service = new TextServiceImpl();
    System.out.println(service.sortParagraphsByCountOfSentences(component));
  }
}
