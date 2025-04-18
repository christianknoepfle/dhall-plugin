package org.piperiverstudios.dhall.plugin.dhall

import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.tree.{IFileElementType, TokenSet}
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile}
import org.piperiverstudios.dhall.plugin.dhall.parser.DhallParser
import org.piperiverstudios.dhall.plugin.dhall.psi.DhallTypes

class DhallParserDefinition extends ParserDefinition {

  override def createLexer(project: Project): Lexer = new DhallLexerAdapter()

  override def createParser(project: Project): PsiParser = new DhallParser()

  override def getFileNodeType: IFileElementType = new IFileElementType(DhallLanguage)

  override def getCommentTokens: TokenSet = DhallTokens.COMMENTS

  override def getStringLiteralElements: TokenSet = TokenSet.EMPTY

  override def createElement(node: ASTNode): PsiElement = DhallTypes.Factory.createElement(node)

  override def createFile(viewProvider: FileViewProvider): PsiFile = new DhallFile(viewProvider)
}
