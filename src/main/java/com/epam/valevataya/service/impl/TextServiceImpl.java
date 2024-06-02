package com.epam.valevataya.service.impl;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextType;
import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.service.TextService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
  @Override
  public List<TextComponent> sortParagraphsByCountOfSentences(TextComponent text) throws TextException {
    List<TextComponent> textComponents = text.getTextComponentsList();
    System.out.println(textComponents);
    List<TextComponent> sortedParagraphs = textComponents.stream()
            .filter(p -> p.getTextType() == TextType.PARAGRAPH && p instanceof TextComponent)
            .map(p -> (TextComponent) p)
            .sorted(Comparator.comparingInt(p -> p.getTextComponentsList().size()))
            .toList();
    return sortedParagraphs;
  }

  @Override
  public List<TextComponent> findSentenceWithLongestWord(TextComponent text) throws TextException {
    return null;
  }

  @Override
  public void removeSentences(TextComponent text, int wordsCount) throws TextException {

  }

  @Override
  public Map<String, Integer> findAndCountSameWords(TextComponent text) throws TextException {
    return null;
  }

  @Override
  public int countVowels(TextComponent composite) throws TextException {
    return 0;
  }

  @Override
  public int countConsonants(TextComponent composite) throws TextException {
    return 0;
  }
}
