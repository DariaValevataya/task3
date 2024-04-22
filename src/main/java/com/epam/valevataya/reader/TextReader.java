package com.epam.valevataya.reader;

import com.epam.valevataya.exception.TextException;

import java.util.List;

public interface TextReader {
  String readFile(String filename) throws TextException;

}
