package org.piperiverstudios.dhall.plugin.dhall

import java.io.File

import com.intellij.openapi.util.io.FileUtil
import com.intellij.testFramework.ParsingTestCase

abstract class ParserTestBase (dataPath: String)
  extends ParsingTestCase(dataPath, "dhall", new DhallParserDefinition) {

  override def getTestDataPath: String =
    "src/test/resources/parser"

  // Regrettably, the default load file implementation
  // trims whitespace away, thus modifying the precise
  // contents of the file we specify.
  // (https://intellij-support.jetbrains.com/hc/en-us/community/posts/360001800000-ParsingTestCase-ignores-trailing-whitespace)
  // This implementation preserves the file precisely
  // as it was loaded.
  override def loadFile(name: String) = {
    FileUtil.loadFile(new File(this.myFullDataPath, name), "UTF-8", true)
  }

  override def skipSpaces(): Boolean = {
    false
  }

  override def includeRanges(): Boolean = {
    true
  }
}
