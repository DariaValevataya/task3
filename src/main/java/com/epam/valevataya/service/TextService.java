package com.epam.valevataya.service;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.exception.TextException;

import java.util.List;
import java.util.Map;

public interface TextService {
  List<TextComponent> sortParagraphsByCountOfSentences(TextComponent text) throws TextException;

  List<TextComponent> findSentenceWithLongestWord(TextComponent text) throws TextException;

  void removeSentences(TextComponent text, int wordsCount) throws TextException;

  Map<String, Integer> findAndCountSameWords(TextComponent text) throws TextException;

  int countVowels(TextComponent composite) throws TextException;

  int countConsonants(TextComponent composite) throws TextException;
}
