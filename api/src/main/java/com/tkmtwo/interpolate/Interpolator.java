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
import java.util.Collection;
import java.util.List;

/**
 * Static processing of <code>String</code>s using <code>InterpolatorCallback</code>s.
 *
 *
 * @author Tom Mahaffey
 */
public final class Interpolator {

  /** The default token start is '${'. */
  public static final String DEFAULT_TOKEN_START = "${";

  /** The default token stop is '}'. */
  public static final String DEFAULT_TOKEN_STOP  = "}";
  
  

  /**
   * Interpolates a <code>String</code> using a single <code>InterpolatorCallback</code>
   * and default token markers.
   *
   * @param s a String to interpolate
   * @param ic an InterpolatorCallback to use
   * @return an interpolated String
   */
  public static String interpolate(String s, InterpolatorCallback ic) {
    return interpolate(s, ic, DEFAULT_TOKEN_START, DEFAULT_TOKEN_STOP);
  }
  
  /**
   * Interpolates a <code>String</code> using a single <code>InterpolatorCallback</code>
   * and custom token markers.
   *
   * @param s a String to interpolate
   * @param ic an InterpolatorCallback to use
   * @param tokenStart a String marking the start/beginning of a token
   * @param tokenStop a String marking the stop/end of a token
   * @return an interpolated String
   */
  public static String interpolate(String s,
                                   InterpolatorCallback ic,
                                   String tokenStart,
                                   String tokenStop) {

    checkNotNull(s, "String to interpolate is null.");
    checkNotNull(ic, "InterpolatorCallback is null.");
    checkNotNull(tokenStart, "Token start is null.");
    checkNotNull(tokenStop, "Token stop is null.");
    
    int replCnt = 0;
    int begin = -1;
    int end = -1;
    int prec = 0 - tokenStop.length();
    
    while (((begin = s.indexOf(tokenStart, prec + tokenStop.length())) > -1)
           && ((end = s.indexOf(tokenStop, begin + 1)) > -1)) {
      
      
      ic.append(s.substring(prec + tokenStop.length(), begin));

      /*
      System.out.println(String.format("s                 is %s", s));
      System.out.println(String.format("begin             is %s", String.valueOf(begin)));
      System.out.println(String.format("tokenStart.length() is %s", String.valueOf(tokenStart.length())));
      System.out.println(String.format("end               is %s", String.valueOf(end)));
      System.out.println();
      */
      
      ic.replace(s.substring(begin + tokenStart.length(), end),
                 replCnt++,
                 tokenStart, tokenStop);
      
      prec = end;
    }
    
    ic.append(s.substring(prec + tokenStop.length(), s.length()));

    String result = ic.getResult();
    ic.reset();
    return result;
  }
  
  
  
  
  /**
   * Interpolates a <code>String</code> using a list of <code>InterpolatorCallback</code>s
   * and default token markers.
   *
   * <p>
   * The input <code>String</code> is serially run through each callback, in order.
   *
   * @param s a String to interpolate
   * @param ics a list of InterpolatorCallbacks to use
   * @return an interpolated String
   */
  public static String interpolate(String s,
                                   List<InterpolatorCallback> ics) {
    return interpolate(s, ics, DEFAULT_TOKEN_START, DEFAULT_TOKEN_STOP);
  }
  
  
  
  /**
   * Interpolates a <code>String</code> using a list of <code>InterpolatorCallback</code>s
   * and custom token markers.
   *
   * <p>
   * The input <code>String</code> is serially run through each callback, in order.
   *
   * @param s a String to interpolate
   * @param ics a list of InterpolatorCallbacks to use
   * @param tokenStart a String marking the start/beginning of a token
   * @param tokenStop a String marking the stop/end of a token
   * @return an interpolated String
   */
  public static String interpolate(String s,
                                   List<InterpolatorCallback> ics,
                                   String tokenStart,
                                   String tokenStop) {
    checkNotNull(ics, "InterpolatorCallback list is null.");
    String result = s;
    for (InterpolatorCallback ic : ics) {
      result = interpolate(result, ic, tokenStart, tokenStop);
    }
    return result;
  }
  
  
  
  
  /**
   * Interpolates a <code>Collection</code> of <code>String</code>s using a single
   *  <code>InterpolatorCallback</code> and default token markers.
   *
   * @param srcCollection a Collection of Strings to interpolate
   * @param dstCollection a Collection of Strings to .add(String) to
   * @param ic an InterpolatorCallback to use
   */
  public static void interpolate(Collection<String> srcCollection,
                                 Collection<String> dstCollection,
                                 InterpolatorCallback ic) {
    interpolate(srcCollection, dstCollection, ic, DEFAULT_TOKEN_START, DEFAULT_TOKEN_STOP);
  }
  
  
  /**
   * Interpolates a <code>Collection</code> of <code>String</code>s using a single
   *  <code>InterpolatorCallback</code> and custom token markers.
   *
   * @param srcCollection a Collection of Strings to interpolate
   * @param dstCollection a Collection of Strings to add to
   * @param ic an InterpolatorCallback to use
   * @param tokenStart a String marking the start/beginning of a token
   * @param tokenStop a String marking the stop/end of a token
   */
  public static void interpolate(Collection<String> srcCollection,
                                 Collection<String> dstCollection,
                                 InterpolatorCallback ic,
                                 String tokenStart,
                                 String tokenStop) {
    for (String s : srcCollection) {
      dstCollection.add(interpolate(s, ic, tokenStart, tokenStop));
    }
  }
  
  
  
}
