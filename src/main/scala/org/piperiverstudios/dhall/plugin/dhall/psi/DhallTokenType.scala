package org.piperiverstudios.dhall.plugin.dhall.psi

import com.intellij.psi.tree.IElementType
import org.piperiverstudios.dhall.plugin.dhall.DhallLanguage

class DhallTokenType(debugName: String) extends IElementType(debugName, DhallLanguage) {
  override def toString: String = "DhallTokenType " + super.toString
}
