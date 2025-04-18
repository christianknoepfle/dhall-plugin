package org.piperiverstudios.dhall.plugin.dhall

import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType

class DhallSyntaxHighlighter extends SyntaxHighlighterBase {

  override def getHighlightingLexer: Lexer = new DhallLexerAdapter()

  override def getTokenHighlights(tokenType: IElementType): Array[TextAttributesKey] = {

    if (DhallTokens.KEYWORDS.contains(tokenType))
      DhallSyntaxHighlighter.KEYWORDS
    else
      DhallSyntaxHighlighter.EMPTY_KEYS;
  }

}

object DhallSyntaxHighlighter {

  val KEYWORDS =
    Array[TextAttributesKey](createTextAttributesKey("DHALL_KEYWORDS", DefaultLanguageHighlighterColors.KEYWORD))
  val EMPTY_KEYS = new Array[TextAttributesKey](0)

}
