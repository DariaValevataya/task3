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
    int wordCountInSentence = 5;
    System.out.println("Sorted paragraphs by count of sentences: " + service.sortParagraphsByCountOfSentences(component));
    System.out.println("Sentence with the longest word in the text: " + service.findSentenceWithLongestWord(component));
    System.out.println("All sentences without removed sentence(s): " + service.removeSentences(component, wordCountInSentence));
    System.out.println("Same words and count: " + service.findAndCountSameWords(component));
    System.out.println("Count of vowels in the text: " + service.countVowels(component));
    System.out.println("Count of consonants in the text: " + service.countConsonants(component));
  }
}
