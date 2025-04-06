package org.piperiverstudios.dhall.plugin.simple

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class SimpleFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, SimpleLanguage) {
  def getFileType: FileType = new SimpleFileType // todo should that be an object

  override def toString = "Simple File"
}
