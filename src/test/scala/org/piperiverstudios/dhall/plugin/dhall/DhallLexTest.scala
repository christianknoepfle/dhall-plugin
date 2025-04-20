package org.piperiverstudios.dhall.plugin.dhall

import com.intellij.psi.tree.IElementType
import org.scalatest
import org.scalatest.wordspec.AnyWordSpec

import scala.io.Source

class DhallLexTest extends AnyWordSpec {

  def testLexer(fileName: String, expectedTokens: Seq[String]): scalatest.Assertion = {
    val source = Source.fromFile(getClass.getResource(s"/lexer/${fileName}.dhall").getFile)
    val content =
      try source.mkString
      finally source.close()
    val lexer = new DhallLexerAdapter()
    lexer.start(content)
    val tokens = scala.collection.mutable.ArrayBuffer.empty[String]

    while ({
      println(s"$fileName - ${lexer.getTokenType}: =>${lexer.getTokenText}<=")
      tokens += lexer.getTokenType.getDebugName
      lexer.advance()
      lexer.getTokenType != null
    }) {}

    assert(tokens == expectedTokens)

  }

  "Dhall" can {

    "process single line comment" in { testLexer("comment1", Seq("COMMENT", "COMMENT")) }
    "process multi line comment" in { testLexer("comment2", Seq("COMMENT")) }
    "simple assignment" in { testLexer("assignment1", Seq("IDENTIFIER", "EQ", "NUMBER_INT")) }
    "string1" in { testLexer("string1", Seq("STRING")) }
    "string2" in { testLexer("string2", Seq("STRING")) }
    "number1" in { testLexer("number1", Seq("NUMBER_FP")) }
    "file path imports and check with combine" in {
      testLexer(
        "filepath",
        Seq("FILE_PATH", "FILE_PATH", "COMBINE", "COMBINE_TYPES")
      )
    }
    "uri imports" in {
      testLexer(
        "uri",
        Seq("URI", "URI")
      )
    }

  }

}
