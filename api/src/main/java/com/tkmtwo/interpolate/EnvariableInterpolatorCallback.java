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
 * Replaces tokens with values from the system environment.
 *
 * <p>
 * The default prefix is "env."
 *
 */
public final class EnvariableInterpolatorCallback
  extends AbstractInterpolatorCallback {


  /**
   * Creates a new <code>EnvariableInterpolatorCallback</code> with
   * prefix "env.".
   *
   */
  public EnvariableInterpolatorCallback() {
    this("env.");
  }
  
  
  /**
   * Creates a new <code>EnvariableInterpolatorCallback</code> with
   * the supplied prefix.
   *
   * @param prefix - The prefix to use for this callback.
   */
  public EnvariableInterpolatorCallback(String prefix) {
    setTokenPrefix(prefix);
  }




  /**
   * @see AbstractInterpolatorCallback#replaceInternal(String, int, CharSequence, CharSequence)
   */
  @Override
  protected String replaceInternal(String token,
                                   int tokenNumber,
                                   CharSequence tokenStart,
                                   CharSequence tokenStop) {
    return System.getenv(token);
  }
  
  
  
}
