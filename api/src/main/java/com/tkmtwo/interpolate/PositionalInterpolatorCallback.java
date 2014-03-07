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

import com.google.common.collect.ImmutableList;
import java.util.List;

/**
 *
 */
public class PositionalInterpolatorCallback<T>
    extends AbstractInterpolatorCallback {
  
  
  
  private List<T> values;
  
  
  /**
   * Creates a new <code>PositionalInterpolatorCallback</code> instance.
   *
   * @param vs a List of <code>T</code> values
   */
  public PositionalInterpolatorCallback(List<T> vs) {
    if (vs == null) {
      values = ImmutableList.of();
    } else {
      values = ImmutableList.copyOf(vs);
    }
  }



  /**
   * Creates a new <code>PositionalInterpolatorCallback</code> instance.
   *
   * @param tokenPrefix
   * @param vs a List of <code>T</code> values
   */
  public PositionalInterpolatorCallback(String tokenPrefix,
                                        List<T> vs) {
    setTokenPrefix(tokenPrefix);
    if (vs == null) {
      values = ImmutableList.of();
    } else {
      values = ImmutableList.copyOf(vs);
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
    if (tokenNumber >= values.size()) {
      return null;
    }
    return formatValue(values.get(tokenNumber));
  }
  
  
  
  

  /**
   * Formats a value into a String.
   *
   * This implementation calls <code>T.toString()</code>.  Sublasses
   * should override for custom formatting.
   *
   * @param value a <code>T</code> value
   */
  protected String formatValue(T value) {
    return value.toString();
  }

  
}
