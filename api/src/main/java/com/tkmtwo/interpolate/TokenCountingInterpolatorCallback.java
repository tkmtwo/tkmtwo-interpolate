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
public final class TokenCountingInterpolatorCallback
    extends AbstractInterpolatorCallback {


  /** The running count of tokens seen. */
  private int tokenCount = 0;
  
  
  
  /**
   * Gets the current count of tokens seen during processing.
   *
   * @return an <code>int</code> value
   */
  public int getCount() {
    return this.tokenCount;
  }
  
  
  
  /**
   * @see AbstractInterpolatorCallback#replaceInternal(String, int, CharSequence, CharSequence)
   */
  protected String replaceInternal(String token,
                                 int tokenNumber,
                                 CharSequence tokenStart,
                                 CharSequence tokenStop) {
    return null;
  }
}

