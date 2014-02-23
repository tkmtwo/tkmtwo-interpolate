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
 * Simple <code>InterpolatorCallback</code> which echoes the token back.
 *
 * This callback is used primarily in testing.
 *
 * @author Tom Mahaffey
 */
public final class EchoInterpolatorCallback
  extends AbstractInterpolatorCallback {

  public EchoInterpolatorCallback() { }

  public EchoInterpolatorCallback(String tokenPrefix) {
    setTokenPrefix(tokenPrefix);
  }
  
  
  
  
  /**
   * Echoes the token name back.
   *
   * @see AbstractInterpolatorCallback#replaceInternal(String, int, CharSequence, CharSequence)
   */
  protected String replaceInternal(String token,
                                   int tokenNumber,
                                   CharSequence tokenStart,
                                   CharSequence tokenStop) {
    return token;
  }
  
  
}
