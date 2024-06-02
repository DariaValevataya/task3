package com.epam.valevataya.service.impl;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextType;
import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.service.TextService;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
  @Override
  public List<TextComponent> sortParagraphsByCountOfSentences(TextComponent text) throws TextException {
    List<TextComponent> sortedParagraphs = new ArrayList<>();
    if (text.getTextType() == TextType.TEXT) {
      sortedParagraphs = text.getTextComponentsList()
              .stream()
              .sorted(Comparator.comparingInt(c -> c.getTextComponentsList().size()))
              .toList();
    }
    return sortedParagraphs;
  }

  @Override
  public List<TextComponent> findSentenceWithLongestWord(TextComponent text) throws TextException {
    List<TextComponent> sentence = new ArrayList<>();
    if (text.getTextType() == TextType.PARAGRAPH) {
      sentence = text.getTextComponentsList()
              .stream()
              .sorted(Comparator.comparingInt(c -> {
                int sum = 0;
                for (TextComponent component : c.getTextComponentsList()) {
                  sum += component.getTextComponentsList().size();
                }
                return sum;
              }))
              .toList();
    }
    return sentence;
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
