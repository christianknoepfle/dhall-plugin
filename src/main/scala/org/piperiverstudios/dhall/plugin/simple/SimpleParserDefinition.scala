package org.piperiverstudios.dhall.plugin.simple

import com.intellij.lang.{ASTNode, ParserDefinition, PsiParser}
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.{FileViewProvider, PsiElement, PsiFile}
import com.intellij.psi.tree.{IFileElementType, TokenSet}
import org.piperiverstudios.dhall.plugin.simple.parser.SimpleParser
import org.piperiverstudios.dhall.plugin.simple.psi.SimpleTypes

class SimpleParserDefinition extends ParserDefinition {

  override def createLexer(project: Project): Lexer = new SimpleLexerAdapter()

  override def createParser(project: Project): PsiParser = new SimpleParser()

  override def getFileNodeType: IFileElementType = new IFileElementType(SimpleLanguage)

  override def getCommentTokens: TokenSet = SimpleTokens.COMMENTS

  override def getStringLiteralElements: TokenSet = TokenSet.EMPTY

  override def createElement(node: ASTNode): PsiElement = SimpleTypes.Factory.createElement(node)

  override def createFile(viewProvider: FileViewProvider): PsiFile = new SimpleFile(viewProvider)
}
