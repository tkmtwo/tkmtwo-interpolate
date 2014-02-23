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

import static com.google.common.base.Preconditions.checkArgument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * A convenient base class for implementing <code>InterpolatorCallback</code>.
 *
 * <p>
 * As the <code>IntrpolatorCallback</code> methods are called, this class appends
 * to an internal <code>StringBuffer</code>.
 *
 * <p>
 * An optional "prefix" may be specified.  If a prefix is specified, only tokens 
 * starting with the prefix are replaced.
 *
 * <p>
 * Sublasses need to implement <code>replaceInternal</code>.
 * The method signature is the same as <code>InterpolatorCallback.replace()</code>.
 * Subclasses may assume that any configured prefix has been removed from the token name
 * prior to calling <code>replaceInternal</code>. *(
 *
 * @author Tom Mahaffey
 */
public abstract class AbstractInterpolatorCallback
  implements InterpolatorCallback {

  //
  //TODO(mahaffey): run through this and make sure it's thread safe.
  //                ...or...
  //                say that it's not
  //

  protected final Logger logger = LoggerFactory.getLogger(getClass());

  /** The default prefix is an empty String. */
  public static final String DEFAULT_PREFIX = "";
  private String tokenPrefix = DEFAULT_PREFIX;
  

  /** dynamic string. */
  private StringBuffer stringBuffer = new StringBuffer();
  

  public String getTokenPrefix() {
    if (tokenPrefix == null) {
      tokenPrefix = DEFAULT_PREFIX;
    }
    return tokenPrefix;
  }
  public void setTokenPrefix(String s) { tokenPrefix = s; }

  /*
  protected boolean isPrefixed(String token) {
    if (token == null || token.isEmpty()) { return false; }
    if (getTokenPrefix().isEmpty()) { return false; }
    return token.startsWith(getTokenPrefix());
  }
  */

  /**
   * Removes the prefix (if it exists) from a token.
   *
   */
  protected String normalizeToken(String s) {
    return removePrefix(s, getTokenPrefix());
  }
  private static String removePrefix(String s, String p) {
    if (p == null || p.isEmpty()) { return s; }
    if (s == null || s.isEmpty()) { return s; }
    if (!s.startsWith(p)) { return s; }

    int prefixPos = s.indexOf(p);
    return s.substring(prefixPos + p.length());
  }

  
    

  /**
   * @see InterpolatorCallback#append(CharSequence)
   */
  public void append(CharSequence cs) {
    logger.trace("Appending '{}'", cs);
    stringBuffer.append(cs);
  }



  /**
   * @see InterpolatorCallback#replace(String, int, CharSequence, CharSequence)
   */
  public void replace(String token, int tokenNumber, CharSequence tokenStart, CharSequence tokenStop) {
    checkArgument((token != null && !token.isEmpty()), "Token is empty.");
    checkArgument((tokenStart != null && tokenStart.length() > 0), "Token start is empty.");
    checkArgument((tokenStop != null && tokenStop.length() > 0), "Token stop is empty.");


    logger.trace("Evaluating replacement for '{}'", token);
    
    if (!getTokenPrefix().isEmpty()
        && !token.startsWith(getTokenPrefix())) {
      logger.trace("Expecting prefix '{}' but did not find it.", getTokenPrefix());
      append(tokenStart);
      append(token);
      append(tokenStop);
      return;
    }
      
    String tokenRepl = replaceInternal(normalizeToken(token), tokenNumber, tokenStart, tokenStop);
    if (tokenRepl == null) {
      logger.trace("Replacement not found.");
      append(tokenStart);
      append(token);
      append(tokenStop);
      return;
    }

    logger.trace("Replacement found: '{}'", tokenRepl);
    append(tokenRepl);
  }

  

  /**
   * Replace the token with a supplied value.
   *
   * Any prefixes are removed prior to calling this method.
   *
   * @param token a String representing the token, with any configured prefix removed
   * @param tokenNumber an integer specifying the zero-based token number
   * @param tokenStart a CharSequence marking the start/beginning of the token
   * @param tokenStop a CharSequence marking the stop/end of the token
   */
  protected abstract String replaceInternal(String token, int tokenNumber,
                                            CharSequence tokenStart, CharSequence tokenStop);

  /**
   * @see InterpolatorCallback#getResult()
   */
  public String getResult() {
    return stringBuffer.toString();
  }

  /**
   * @see InterpolatorCallback#reset()
   */
  public void reset() {
    logger.trace("Resetting the StringBuffer");
    stringBuffer.setLength(0);
  }



}
