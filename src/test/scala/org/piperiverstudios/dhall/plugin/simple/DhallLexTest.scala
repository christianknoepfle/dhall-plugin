package org.piperiverstudios.dhall.plugin.simple

import org.scalatest.wordspec.AnyWordSpec

import java.io.FileReader
import java.nio.file
import scala.io.Source

class DhallLexTest extends AnyWordSpec {
  "Simple" can {
    // val path = getClass.getResource("/lexer/simple.dhall").getPath
    val source = Source.fromFile(getClass.getResource("/lexer/foo.simple").getFile)
    val content =
      try source.mkString
      finally source.close()
    val lexer = new SimpleLexerAdapter()
    lexer.start(content)
    while ({
      lexer.advance()
      val token = lexer.getTokenType
      token != null
    }) {
      println(s"${lexer.getTokenType}: ${lexer.getTokenText}")
    }

  }

}
