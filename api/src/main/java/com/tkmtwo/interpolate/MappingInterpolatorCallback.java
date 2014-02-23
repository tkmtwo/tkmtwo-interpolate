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

import static com.google.common.base.Preconditions.checkNotNull;
import com.google.common.collect.ImmutableMap;
import java.util.Map;



/**
 *
 * @param <T> any Object.  The <code>toString()</code> method is called during token replacement.
 */
public final class MappingInterpolatorCallback<T>
  extends AbstractInterpolatorCallback {
  
  /** internal map of token/values. */
  private Map<String, T> map;
  
  
  /**
   * Creates a new interpolator with an empty map.
   *
   */  
  public MappingInterpolatorCallback() {
    map = ImmutableMap.of();
  }
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings.
   *
   * @param m a map from which to copy entries
   */
  public MappingInterpolatorCallback(Map<String, T> m) {
    map = ImmutableMap.copyOf(checkNotNull(m));
  }
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings in the supplied prefix.
   *
   * @param tokenPrefix
   * @param m a map from which to copy entries
   */
  public MappingInterpolatorCallback(String tokenPrefix,
                                     Map<String, T> m) {
    setTokenPrefix(tokenPrefix);
    map = ImmutableMap.copyOf(checkNotNull(m));
  }
  
  
  
  
  
  
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mapping.
   *
   *
   * @param k1 a String key
   * @param v1 an Object value
   */
  public MappingInterpolatorCallback(String k1, T v1) {
    map = ImmutableMap.of(k1, v1);
  }
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings in the supplied prefix.
   *
   * @param tokenPrefix - prefix for this callback
   * @param k1 a String key
   * @param v1 an Object value
   */
  public MappingInterpolatorCallback(String tokenPrefix,
                                     String k1, T v1) {
    setTokenPrefix(tokenPrefix);
    map = ImmutableMap.of(k1, v1);
  }
  
  
  
  
  
  
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings.
   *
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   */
  public MappingInterpolatorCallback(String k1, T v1,
                                     String k2, T v2) {
    map = ImmutableMap.of(k1, v1,
                          k2, v2);
  }
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings in the supplied prefix.
   *
   * @param tokenPrefix - prefix for this callback
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   */
  public MappingInterpolatorCallback(String tokenPrefix,
                                     String k1, T v1,
                                     String k2, T v2) {
    setTokenPrefix(tokenPrefix);
    map = ImmutableMap.of(k1, v1,
                          k2, v2);
  }
  
  
  
  
  
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings.
   *
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   * @param k3 a String key
   * @param v3 an Object value
   */
  public MappingInterpolatorCallback(String k1, T v1,
                                     String k2, T v2,
                                     String k3, T v3) {
    map = ImmutableMap.of(k1, v1,
                          k2, v2,
                          k3, v3);
  }
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings in the supplied prefix.
   *
   * @param tokenPrefix - prefix for this callback
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   * @param k3 a String key
   * @param v3 an Object value
   */
  public MappingInterpolatorCallback(String tokenPrefix,
                                     String k1, T v1,
                                     String k2, T v2,
                                     String k3, T v3) {
    setTokenPrefix(tokenPrefix);
    map = ImmutableMap.of(k1, v1,
                          k2, v2,
                          k3, v3);
  }
  
  
  
  
  
  
  
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings.
   *
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   * @param k3 a String key
   * @param v3 an Object value
   * @param k4 a String key
   * @param v4 an Object value
   */
  public MappingInterpolatorCallback(String k1, T v1,
                                     String k2, T v2,
                                     String k3, T v3,
                                     String k4, T v4) {
    map = ImmutableMap.of(k1, v1,
                          k2, v2,
                          k3, v3,
                          k4, v4);
  }
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings in the supplied prefix.
   *
   * @param tokenPrefix - prefix for this callback
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   * @param k3 a String key
   * @param v3 an Object value
   * @param k4 a String key
   * @param v4 an Object value
   */
  public MappingInterpolatorCallback(String tokenPrefix,
                                     String k1, T v1,
                                     String k2, T v2,
                                     String k3, T v3,
                                     String k4, T v4) {
    setTokenPrefix(tokenPrefix);
    map = ImmutableMap.of(k1, v1,
                          k2, v2,
                          k3, v3,
                          k4, v4);
  }
  
  
  
  
  
  
  
  
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings.
   *
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   * @param k3 a String key
   * @param v3 an Object value
   * @param k4 a String key
   * @param v4 an Object value
   * @param k5 a String key
   * @param v5 an Object value
   */
  public MappingInterpolatorCallback(String k1, T v1,
                                     String k2, T v2,
                                     String k3, T v3,
                                     String k4, T v4,
                                     String k5, T v5) {
    map = ImmutableMap.of(k1, v1,
                          k2, v2,
                          k3, v3,
                          k4, v4,
                          k5, v5);
  }
  
  
  /**
   * Creates a new interpolator callback using the 
   * supplied mappings in the supplied prefix.
   *
   * @param tokenPrefix - prefix for this callback
   * @param k1 a String key
   * @param v1 an Object value
   * @param k2 a String key
   * @param v2 an Object value
   * @param k3 a String key
   * @param v3 an Object value
   * @param k4 a String key
   * @param v4 an Object value
   * @param k5 a String key
   * @param v5 an Object value
   */
  public MappingInterpolatorCallback(String tokenPrefix,
                                     String k1, T v1,
                                     String k2, T v2,
                                     String k3, T v3,
                                     String k4, T v4,
                                     String k5, T v5) {
    setTokenPrefix(tokenPrefix);
    map = ImmutableMap.of(k1, v1,
                          k2, v2,
                          k3, v3,
                          k4, v4,
                          k5, v5);
  }
  
  
  /**  
   * Copies an addition entry into the map.
   *
   *
   * @param k a String key
   * @param v an Object value
   */
  public void put(String k, T v) {
    map = new ImmutableMap.Builder<String, T>()
      .putAll(map)
      .put(k, v)
      .build();
  }
  
  
  /**  
   * Copies addition entries into the map.
   *
   *
   * @param m - another map.  All entries are copied in.
   */
  public void putAll(Map<String, T> m) {
    map = new ImmutableMap.Builder<String, T>()
      .putAll(map)
      .putAll(m)
      .build();
  }

  
  
  
  
  /**
   * @see AbstractInterpolatorCallback#replaceInternal(String, int, CharSequence, CharSequence)
   */
  @Override
  protected String replaceInternal(String token,
                                   int tokenNumber,
                                   CharSequence tokenStart,
                                   CharSequence tokenStop) {
    logger.trace("Searching map for '{}' relplacement...", token);
    if (map.containsKey(token)) {
      String s = map.get(token).toString();
      logger.trace("Value found is '{}'", s);
      return s;
    }
    logger.trace("Value not found.");
    return null;
  }
  
  
  
}
