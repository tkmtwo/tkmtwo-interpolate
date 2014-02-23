/*
 *
 * Copyright 2014 Tom Mahaffey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */
package com.tkmtwo.interpolate;

/**
 * A callback interface for building <code>String</code>s.
 *
 *
 */
public interface InterpolatorCallback {
  
  /**
   * Appends to the result string.
   *
   * @param cs a <code>String</code> value
   */
  void append(CharSequence cs);
  
  
  
  /**
   * Replaces a portion of the string.
   *
   *
   *
   * @param token the <code>String</code> value of the token.
   *        In the case of ${this.is.my.token}, token == "this.is.my.token"
   * @param tokenNumber an <code>int</code> value for the token number.
   *        This tells the callback which token number is being passed in.
   * @param tokenStart the <code>CharSequence</code> detected as starting the token.
   *        In the case of ${this.is.my.token}, tokenStart == "%{"
   * @param tokenStop  the <code>CharSequence</code> detected as stopping the token.
   *        In the case of ${this.is.my.token}, tokenStop == "}"
   */
  void replace(String token, int tokenNumber, CharSequence tokenStart, CharSequence tokenStop);
  
  
  
  /**
   * Gets the result string.
   *
   * Normally called after all token processing is complete.
   *
   * @return a <code>String</code> value
   */
  String getResult();
  
  /**
   * Resets the callback, if necessary.
   *
   */
  void reset();
  
}
