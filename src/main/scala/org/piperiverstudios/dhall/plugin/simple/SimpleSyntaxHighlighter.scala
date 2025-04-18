package org.piperiverstudios.dhall.plugin.simple

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.{DefaultLanguageHighlighterColors, HighlighterColors}
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import org.piperiverstudios.dhall.plugin.simple.psi.SimpleTypes

class SimpleSyntaxHighlighter extends SyntaxHighlighterBase {

  override def getHighlightingLexer: Lexer = new SimpleLexerAdapter()

  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = {

    if (tokenType.equals(SimpleTypes.SEPARATOR)) {
      SimpleSyntaxHighlighter.SEPARATOR_KEYS;
    } else if (tokenType.equals(SimpleTypes.KEY)) {
      SimpleSyntaxHighlighter.KEY_KEYS;
    } else if (tokenType.equals(SimpleTypes.VALUE)) {
      SimpleSyntaxHighlighter.VALUE_KEYS;
    } else if (tokenType.equals(SimpleTypes.COMMENT)) {
      SimpleSyntaxHighlighter.COMMENT_KEYS;
    } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
      SimpleSyntaxHighlighter.BAD_CHAR_KEYS;
    } else
      SimpleSyntaxHighlighter.EMPTY_KEYS;
  }

}

object SimpleSyntaxHighlighter {
  val SEPARATOR: TextAttributesKey =
    createTextAttributesKey("SIMPLE_SEPARATOR", DefaultLanguageHighlighterColors.OPERATION_SIGN)
  val KEY: TextAttributesKey   = createTextAttributesKey("SIMPLE_KEY", DefaultLanguageHighlighterColors.KEYWORD)
  val VALUE: TextAttributesKey = createTextAttributesKey("SIMPLE_VALUE", DefaultLanguageHighlighterColors.STRING)
  val COMMENT: TextAttributesKey =
    createTextAttributesKey("SIMPLE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT)
  val BAD_CHARACTER: TextAttributesKey =
    createTextAttributesKey("SIMPLE_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER)

  val BAD_CHAR_KEYS  = Array[TextAttributesKey](BAD_CHARACTER)
  val SEPARATOR_KEYS = Array[TextAttributesKey](SEPARATOR)
  val KEY_KEYS       = Array[TextAttributesKey](KEY)
  val VALUE_KEYS     = Array[TextAttributesKey](VALUE)
  val COMMENT_KEYS   = Array[TextAttributesKey](COMMENT)
  val EMPTY_KEYS     = new Array[TextAttributesKey](0)

}
