package com.epam.valevataya.reader.impl;

import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.reader.TextReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextReaderImpl implements TextReader {
  static final Logger logger = LogManager.getLogger();
  private static final String DEFAULT_FILENAME = "data\\textData.txt";
  private static final String SPACE_DELIMITER = "\\s+";
  @Override
  public String readFile(String filename) throws TextException {
    if (filename == null) {
      throw new TextException("Null was passed");
    }
    Path path = Path.of(filename);
    if (!Files.exists(path)) {
      logger.warn("file " + filename + " not exists");
      filename = DEFAULT_FILENAME;
    }
    String line;
    StringBuilder text = new StringBuilder();    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      while ((line = reader.readLine()) != null) {
        text.append(line).append("\n");
      }
    } catch (IOException e) {
      logger.error(e.getMessage());
      throw new TextException(e);
    }
    return text.toString();
  }
}
