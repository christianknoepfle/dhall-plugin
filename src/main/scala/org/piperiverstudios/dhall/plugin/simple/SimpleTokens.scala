package org.piperiverstudios.dhall.plugin.simple

import com.intellij.psi.tree.TokenSet
import org.piperiverstudios.dhall.plugin.simple.psi.SimpleTypes

object SimpleTokens {
  val IDENTIFIERS: TokenSet = TokenSet.create(SimpleTypes.KEY)

  val COMMENTS: TokenSet = TokenSet.create(SimpleTypes.COMMENT)
}
