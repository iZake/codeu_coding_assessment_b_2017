// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.mathlang.impl;

import java.io.*;

import com.google.codeu.mathlang.core.tokens.*;
import com.google.codeu.mathlang.parsing.TokenReader;

// MY TOKEN READER
//
// This is YOUR implementation of the token reader interface. To know how
// it should work, read src/com/google/codeu/mathlang/parsing/TokenReader.java.
// You should not need to change any other files to get your token reader to
// work with the test of the system.
public final class MyTokenReader implements TokenReader {

  public String source;
  private int pos;

  public MyTokenReader(String source) {
    // Your token reader will only be given a string for input. The string will
    // contain the whole source (0 or more lines).
    this.source = source;

  }

  @Override
  public Token next() throws IOException {
    // Most of your work will take place here. For every call to |next| you should
    // return a token until you reach the end. When there are no more tokens, you
    // should return |null| to signal the end of input.

    // If for any reason you detect an error in the input, you may throw an IOException
    // which will stop all execution.

    Token token = null;
    if( source.length() == 0) {
      return null;
    } else if ( source.length() == 1) {
      return token = new SymbolToken(source.charAt(0));
    } else {
      for(int i = 1; i < source.length(); i++) {
        if(Character.isWhiteSpace(source.charAt(i))) {
          token = new StringToken(source);
        } else if (!Character.isWhiteSpace(source.charAt(i))) {
          return token = new NameToken(source);
        } else {
            if(isNumber(source.charAt(i))) {
              double j = i;
              return token = new NumberToken(j);
            }
        }
      }
    }
    return token;
  }

  public boolean isNumber(char x) {
    String value = x + "";
    boolean num = false;
    for (int i = 0; i < 10; i++) {
      if(String.getValueOf(i) == value) {
        return num = true;
      }
    }
    return num;
  }
}
