package org.piperiverstudios.dhall.plugin.simple

import com.intellij.openapi.fileTypes.LanguageFileType

import javax.swing.Icon

// todo should that be an object?
final class SimpleFileType extends LanguageFileType(SimpleLanguage) {

  override def getName: String = "Simple File"

  override def getDescription: String = "Simple File Description"

  override def getDefaultExtension: String = "simple"

  override def getIcon: Icon = SimpleIcons.mainIcon
}
