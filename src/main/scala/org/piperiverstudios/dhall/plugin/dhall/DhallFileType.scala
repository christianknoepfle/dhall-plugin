package org.piperiverstudios.dhall.plugin.dhall

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.Icon

// todo should that be an object?
final class DhallFileType extends LanguageFileType(DhallLanguage) {

  override def getName: String = "Dhall File"

  override def getDescription: String = "Dhall File Description"

  override def getDefaultExtension: String = "dhall"

  override def getIcon: Icon = DhallIcons.mainIcon
}
