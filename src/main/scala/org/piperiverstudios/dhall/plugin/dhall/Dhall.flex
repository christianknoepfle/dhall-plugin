// Copyright 2000-2022 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.piperiverstudios.dhall.plugin.dhall;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import org.piperiverstudios.dhall.plugin.dhall.psi.DhallTypes;
import com.intellij.psi.TokenType;

%%

%class DhallLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

LINE_TERMINATOR=\r|\n|\r\n
WHITE_SPACE=[\ \n\t\f]

COMMENT = "{-" [^-] ~"-}" | "{-" "-"+ "}"

COMBINE       = %x2227 | "/\\"
COMBINE_TYPES = %x2A53 | "//\\\\"
EQUIVALENT   = %x2261  | "==="
PREFER        = %x2AFD | "//"
LAMBDA        = %x3BB  | "\\"
ARROW        = %x2192  | "->"
COMPLETE      = "::"
COLON      = ":"

NUMBER_INT = [:jletterdigit:]+
NUMBER_FP = [:digit:]+ "." [:digit:]+

FILE_PATH = ("\.\./" | "\./") [^{WHITE_SPACE}]+
URI = "http" [s]? "://" [^\ \n\r\t]+ // "http" [s]? "://" "[^ \n\r]+"
STRING = "\"" [^\"]* "\""

IDENTIFIER = [:jletter:] [:jletterdigit:]*

%%

<YYINITIAL> {
    // keywords
    "if"                    { return DhallTypes.IF;}
    "then"                  { return DhallTypes.THEN;}
    "else"                  { return DhallTypes.ELSE;}
    "let"                   { return DhallTypes.LET;}
    "in"                    { return DhallTypes.IN;}
    "as"                    { return DhallTypes.AS;}
    "using"                 { return DhallTypes.USING;}
    "merge"                 { return DhallTypes.MERGE;}
    "missing"               { return DhallTypes.MISSING;}
    "Infinity"              { return DhallTypes.INFINITY;}
    "NaN"                   { return DhallTypes.NAN;}
    "Some"                  { return DhallTypes.SOME;}
    "toMap"                 { return DhallTypes.TO_MAP;}
    "assert"                { return DhallTypes.ASSERT;}
    "forall"                { return DhallTypes.FORALL;}
    "with"                  { return DhallTypes.WITH;}
    "showConstructor"       { return DhallTypes.SHOW_CONSTRUCTOR;}

    "Bool"                  { return DhallTypes.BOOL;}
    "True"                  { return DhallTypes.TRUE;}
    "False"                 { return DhallTypes.FALSE;}
    "Optional"              { return DhallTypes.OPTIONAL;}
    "None"                  { return DhallTypes.NONE;}
    "Natural"               { return DhallTypes.NATURAL;}
    "Integer"               { return DhallTypes.INTEGER;}
    "Double"                { return DhallTypes.DOUBLE;}
    "Text"                  { return DhallTypes.TEXT;}
    "Bytes"                 { return DhallTypes.BYTES;}
    "Date"                  { return DhallTypes.DATE;}
    "TimeZone"              { return DhallTypes.TIMEZONE;}
    "Time"                  { return DhallTypes.TIME;}
    "List"                  { return DhallTypes.LIST;}
    "Type"                  { return DhallTypes.TYPE;}
    "Kind"                  { return DhallTypes.KIND;}
    "Sort"                  { return DhallTypes.SORT;}

    // imports
    {URI}                       {return DhallTypes.URI;}
    {FILE_PATH}                 {return DhallTypes.FILE_PATH;}

    {IDENTIFIER}            { return DhallTypes.IDENTIFIER; }

    // comments
    {COMMENT}               { return DhallTypes.COMMENT; }

    // Symbols
    {COMBINE}               {return DhallTypes.COMBINE;}
    {COMBINE_TYPES}         {return DhallTypes.COMBINE_TYPES;}
    {EQUIVALENT}            {return DhallTypes.EQUIVALENT;}
    {PREFER}                {return DhallTypes.PREFER;}
    {LAMBDA}                {return DhallTypes.LAMBDA;}
    {ARROW}                 {return DhallTypes.ARROW;}
    {COMPLETE}              {return DhallTypes.COMPLETE;}
    {COLON}                 {return DhallTypes.COLON;}

    "=="                           { return DhallTypes.EQEQ; }
    "="                            { return DhallTypes.EQ; }
    "+"                            { return DhallTypes.PLUS; }
    "-"                            { return DhallTypes.MINUS; }
    ">"                            { return DhallTypes.GREATER; }
    "<"                            { return DhallTypes.SMALLER; }
    ">="                           { return DhallTypes.GREATER_EQ; }
    "<="                           { return DhallTypes.SMALLER_EQ; }
    "("                      { return DhallTypes.OPEN_BRACE; }
    ")"                      { return DhallTypes.CLOSE_BRACE; }
    "{"                      { return DhallTypes.OPEN_CURLY_BRACE; }
    "}"                      { return DhallTypes.CLOSE_CURLY_BRACE; }
    "["                      { return DhallTypes.OPEN_BRACKET; }
    "]"                      { return DhallTypes.CLOSE_BRACKET; }
    ","                      { return DhallTypes.COMMA; }
    "%"                      { return DhallTypes.PERCENT; }
    "?"                     { return DhallTypes.QUESTION_MARK; }
    // Strings
    {STRING}                      {return DhallTypes.STRING;}

    // numbers
    {NUMBER_INT}                 {return DhallTypes.NUMBER_INT;}
    {NUMBER_FP}                  {return DhallTypes.NUMBER_FP;}

    {WHITE_SPACE}                { /* ignore */ }
    {LINE_TERMINATOR}            { /* ignore */ }

}