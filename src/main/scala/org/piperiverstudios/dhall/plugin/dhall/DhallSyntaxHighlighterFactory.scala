package org.piperiverstudios.dhall.plugin.dhall

import com.intellij.openapi.fileTypes.{SyntaxHighlighter, SyntaxHighlighterFactory}
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile

class DhallSyntaxHighlighterFactory extends SyntaxHighlighterFactory {

  override def getSyntaxHighlighter(project: Project, virtualFile: VirtualFile): SyntaxHighlighter =
    new DhallSyntaxHighlighter
}
