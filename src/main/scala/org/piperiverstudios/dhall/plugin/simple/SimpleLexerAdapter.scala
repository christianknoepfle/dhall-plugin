package org.piperiverstudios.dhall.plugin.simple

import com.intellij.lexer.FlexAdapter

class SimpleLexerAdapter extends FlexAdapter(new SimpleLexer(null)) {}
