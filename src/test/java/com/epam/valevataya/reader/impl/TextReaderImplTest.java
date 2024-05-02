package com.epam.valevataya.reader.impl;

import com.epam.valevataya.exception.TextException;
import com.epam.valevataya.reader.TextReader;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class TextReaderImplTest {
  private TextReader reader;

  @BeforeMethod
  public void initialize () {
   reader = new TextReaderImpl();
  }

  @Test
  public void testReadFile() throws TextException {
    String actual=reader.readFile("data/textData.txt");
    String expected="    It has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the “Динамо” (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum! " +
            "    It is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English? " +
            "    It is a established fact that a reader will be of a page when looking at its layout... " +
            "    Bye бандерлоги ";
    Assert.assertEquals(actual,expected);
  }
}