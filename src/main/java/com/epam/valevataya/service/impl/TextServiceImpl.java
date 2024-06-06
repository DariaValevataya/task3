package com.epam.valevataya.service.impl;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextType;
import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.service.TextService;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextServiceImpl implements TextService {
  private static final String ENG_VOWEL_REGEX = "[EYUIOAeyuioa]";
  private static final String RUS_VOWEL_REGEX = "[УЕЫАОЭЯИЮЁуеыаоэяиюё]";
  private static final String ENG_CONSONANT_REGEX = "[QWRTPSDFGHJKLZXCVBNMqwrtpsdfghjklzxcvbnm]";
  private static final String RUS_CONSONANT_REGEX = "[ЙЦКНГШЩЗХФВПРЛДЖЧСМТБйцкнгшщзхфвпрлджчсмтб]";

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
    if (text.getTextType() == TextType.TEXT) {
      List<TextComponent> paragraphs = text.getTextComponentsList();
      sentence = paragraphs.stream()
              .flatMap(p -> p.getTextComponentsList().stream())
              .filter(s -> s.getTextType() == TextType.SENTENCE)
              .sorted(Comparator.comparingInt(c -> {
                return c.getTextComponentsList().stream()
                        .mapToInt(w -> w.toString().length())
                        .max()
                        .orElse(0);
              }))
              .findFirst()
              .stream().toList();
    }
    return sentence;
  }

  @Override
  public List<TextComponent> removeSentences(TextComponent text, int wordsCount) throws TextException {
    List<TextComponent> sentences = new ArrayList<>();
    if (text.getTextType() == TextType.TEXT) {
      List<TextComponent> paragraphs = text.getTextComponentsList();
      sentences = paragraphs.stream()
              .flatMap(p -> p.getTextComponentsList().stream())
              .filter(s -> s.getTextType() == TextType.SENTENCE)
              .filter(c -> c.getTextComponentsList().size() >= wordsCount)
              .toList();
    }
    return sentences;
  }

  @Override
  public Map<String, Integer> findAndCountSameWords(TextComponent text) throws TextException {
    Map<String, Integer> map = new HashMap<>();
    List<TextComponent> paragraphs = text.getTextComponentsList();
    paragraphs.stream()
            .flatMap(paragraph -> paragraph.getTextComponentsList().stream())
            .filter(sentence -> sentence.getTextType() == TextType.SENTENCE)
            .flatMap(sentence -> sentence.getTextComponentsList().stream())
            .filter(lexeme -> lexeme.getTextType() == TextType.LEXEME)
            .flatMap(lexeme -> lexeme.getTextComponentsList().stream())
            .filter(word -> word.getTextType() == TextType.WORD)
            .map(w -> w.toString().toLowerCase())
            .forEach(word -> map.merge(word, 1, Integer::sum));
    map.entrySet().removeIf(word -> word.getValue() == 1);
    return map;
  }

  @Override
  public int countVowels(TextComponent text) throws TextException {
    List<TextComponent> paragraphs = text.getTextComponentsList();
    int countVowels = (int) paragraphs.stream()
            .flatMap(paragraph -> paragraph.getTextComponentsList().stream())
            .filter(sentence -> sentence.getTextType() == TextType.SENTENCE)
            .flatMap(sentence -> sentence.getTextComponentsList().stream())
            .filter(lexeme -> lexeme.getTextType() == TextType.LEXEME)
            .flatMap(lexeme -> lexeme.getTextComponentsList().stream())
            .filter(word -> word.getTextType() == TextType.WORD)
            .flatMap(word -> word.getTextComponentsList().stream())
            .filter(letter -> letter.getTextType() == TextType.LETTER)
            .filter(letter -> Pattern.matches(ENG_VOWEL_REGEX, letter.toString()) || Pattern.matches(RUS_VOWEL_REGEX, letter.toString()))
            .count();
    return countVowels;
  }

  @Override
  public int countConsonants(TextComponent text) throws TextException {
    List<TextComponent> paragraphs = text.getTextComponentsList();
    int countConsonants = (int) paragraphs.stream()
            .flatMap(paragraph -> paragraph.getTextComponentsList().stream())
            .filter(sentence -> sentence.getTextType() == TextType.SENTENCE)
            .flatMap(sentence -> sentence.getTextComponentsList().stream())
            .filter(lexeme -> lexeme.getTextType() == TextType.LEXEME)
            .flatMap(lexeme -> lexeme.getTextComponentsList().stream())
            .filter(word -> word.getTextType() == TextType.WORD)
            .flatMap(word -> word.getTextComponentsList().stream())
            .filter(letter -> letter.getTextType() == TextType.LETTER)
            .filter(letter -> Pattern.matches(ENG_CONSONANT_REGEX, letter.toString()) || Pattern.matches(RUS_CONSONANT_REGEX, letter.toString()))
            .count();
    return countConsonants;
  }
}
