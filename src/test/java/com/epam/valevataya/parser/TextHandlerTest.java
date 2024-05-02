package com.epam.valevataya.parser;

import com.epam.valevataya.composite.TextComponent;
import com.epam.valevataya.composite.TextComposite;
import com.epam.valevataya.composite.TextType;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class TextHandlerTest {

  @Test
  public void testParse() {
    String text = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!  \n" +
            "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?  \n" +
            "\tIt is a established fact that a reader will be of a page when looking at its layout…  \n" +
            "\tBye бандерлоги  \n";

    TextComponent component = new TextComposite(TextType.TEXT);
    AbstractTextHandler parser = new TextHandler();
    parser.parse(text, component);
    String actual = component.toString();
    String expected = "\tIt has survived - not only (five) centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the \"Динамо\" (Рига) with the release of Letraset sheets.toString() containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker Faclon9 including versions of Lorem Ipsum!  \n" +
            "\tIt is a long a!=b established fact that a reader will be distracted by the readable content of a page when looking at its layout. The point of using Ipsum is that it has a more-or-less normal distribution ob.toString(a?b:c), as opposed to using (Content here), content here's, making it look like readable English?  \n" +
            "\tIt is a established fact that a reader will be of a page when looking at its layout…  \n" +
            "\tBye бандерлоги  \n";
    Assert.assertEquals(actual, expected);
  }
}