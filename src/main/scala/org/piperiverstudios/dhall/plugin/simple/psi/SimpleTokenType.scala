package org.piperiverstudios.dhall.plugin.simple.psi

import com.intellij.psi.tree.IElementType
import org.piperiverstudios.dhall.plugin.simple.SimpleLanguage

class SimpleTokenType(debugName: String) extends IElementType(debugName, SimpleLanguage) {
  override def toString: String = "SimpleTokenType" + super.toString
}
