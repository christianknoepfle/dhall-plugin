package org.piperiverstudios.dhall.plugin.dhall

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class DhallFile(viewProvider: FileViewProvider) extends PsiFileBase(viewProvider, DhallLanguage) {
  def getFileType: FileType = new DhallFileType // todo should that be an object

  override def toString = "Dhall File"
}
