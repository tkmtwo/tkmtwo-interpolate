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
 *
 */
public final class PositionalInterpolatorCallback
    extends AbstractInterpolatorCallback {
  
  
  
  /** internal array of <code>String</code>s. */
  private String[] strings;
  
  
  /**
   * Creates a new <code>PositionalInterpolatorCallback</code> instance.
   *
   * @param ss a <code>String[]</code> value
   */
  public PositionalInterpolatorCallback(String[] ss) {
    if (ss != null) {
      strings = new String[ss.length];
      for (int i = 0; i < ss.length; i++) {
        strings[i] = ss[i];
      }
    }
  }
  
  
  
  /**
   * @see AbstractInterpolatorCallback#replaceInternal(String, int, CharSequence, CharSequence)
   */
  @Override
  protected String replaceInternal(String token,
                                   int tokenNumber,
                                   CharSequence tokenStart,
                                   CharSequence tokenStop) {
    if (tokenNumber >= strings.length) {
      return null;
    }
    return strings[tokenNumber];
  }
  
  
}
