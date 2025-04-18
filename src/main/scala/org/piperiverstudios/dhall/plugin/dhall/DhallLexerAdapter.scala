package org.piperiverstudios.dhall.plugin.dhall

import com.intellij.lexer.FlexAdapter

class DhallLexerAdapter extends FlexAdapter(new DhallLexer(null)) {}
