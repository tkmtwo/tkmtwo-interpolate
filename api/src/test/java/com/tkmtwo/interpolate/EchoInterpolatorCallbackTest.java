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

import static org.junit.Assert.assertEquals;

import org.junit.Test;


/**
 *
 */
public class EchoInterpolatorCallbackTest {
  

  protected void runEdges(InterpolatorCallback ic,
                          String tokenStart, String tokenPrefix, String tokenStop,
                          String stringForName, String stringForAge) {
    
    String outBegin = String.format("%s is my name and %s is my age", stringForName, stringForAge);
    String inBegin = String.format("%s%sname%s is my name and %s%sage%s is my age",
                                   tokenStart, tokenPrefix, tokenStop,
                                   tokenStart, tokenPrefix, tokenStop);
    String evaledBegin = Interpolator.interpolate(inBegin, ic, tokenStart, tokenStop);
    assertEquals(outBegin, evaledBegin);
                 
    
    
    String outEnd = String.format("my name is %s and my age is %s", stringForName, stringForAge);
    String inEnd = String.format("my name is %s%sname%s and my age is %s%sage%s",
                                 tokenStart, tokenPrefix, tokenStop,
                                 tokenStart, tokenPrefix, tokenStop);
    String evaledEnd = Interpolator.interpolate(inEnd, ic, tokenStart, tokenStop);
    assertEquals(outEnd, evaledEnd);
                 
    
    
    
    String outPadded = String.format("my name is %s and i am %s years old", stringForName, stringForAge);
    String inPadded = String.format("my name is %s%sname%s and i am %s%sage%s years old",
                                    tokenStart, tokenPrefix, tokenStop,
                                    tokenStart, tokenPrefix, tokenStop);
    String evaledPadded = Interpolator.interpolate(inPadded, ic, tokenStart, tokenStop);
    assertEquals(outPadded, evaledPadded);
                 



    String outPlain = String.format("%s%s", stringForName, stringForAge);
    String inPlain = String.format("%s%sname%s%s%sage%s",
                                   tokenStart, tokenPrefix, tokenStop,
                                   tokenStart, tokenPrefix, tokenStop);
    String evaledPlain = Interpolator.interpolate(inPlain, ic, tokenStart, tokenStop);
    assertEquals(outPlain, evaledPlain);
  }
  
  
  
  
  
  
  
  
  
  /**
   * Tests the edges on the default token markers.
   *
   * <p>
   * Default markers are "${" at the start and "}" at the stop.
   * For example: "${token}"
   *
   */
  @Test
  public void testEdgesDefaultStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    runEdges(ic,
             "${", "", "}",
             "name", "age");

    String tp = "pre.";
    ic.setTokenPrefix(tp);
    runEdges(ic,
             "${", tp, "}",
             "name", "age");
  }
  @Test
  public void testDefaultStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    assertEquals("name",
                 Interpolator.interpolate("${name}", ic));
    assertEquals("name",
                 Interpolator.interpolate("${name}", ic, "${", "}"));
  }
  @Test
  public void testDefaultStylePrefix() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback("pre.");
    
    assertEquals("${name} is name",
                 Interpolator.interpolate("${name} is ${pre.name}", ic));
    assertEquals("${name} is name",
                 Interpolator.interpolate("${name} is ${pre.name}", ic,
                                          "${", "}"));
  }
  
  
  
  
  
  
  
  
  
  
  /**
   * Tests the edges on the hug style.
   *
   * <p>
   * Hug markers are a single (but different) marker on either side.
   * For example, "{token}"
   */
  @Test
  public void testEdgesHugStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    runEdges(ic,
             "{", "", "}",
             "name", "age");

    String tp = "pre.";
    ic.setTokenPrefix(tp);
    runEdges(ic,
             "{", tp, "}",
             "name", "age");

    assertEquals("{name} is name",
                 Interpolator.interpolate("{name} is {pre.name}",
                                          ic, "{", "}"));

  }
  
  
  @Test
  public void testHugStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    assertEquals("name",
                 Interpolator.interpolate("{name}",
                                          ic, "{", "}"));

  }
  @Test
  public void testHugStylePrefix() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback("pre.");
    assertEquals("{name} is name",
                 Interpolator.interpolate("{name} is {pre.name}",
                                          ic, "{", "}"));

  }
  
  
  
  
  
  
  
  
  

  
  
  /**
   * Tests the edges on the single marker style.
   *
   * <p>
   * Single markers are a single (and same) marker on either side.
   * For example, "@token@"
   */
  @Test
  public void testEdgesSingleStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    runEdges(ic,
             "@", "", "@",
             "name", "age");

    String tp = "pre.";
    ic.setTokenPrefix(tp);
    runEdges(ic,
             "@", tp, "@",
             "name", "age");

    assertEquals("@name@ is name",
                 Interpolator.interpolate("@name@ is @pre.name@",
                                          ic, "@", "@"));

  }

  
  
  
  @Test
  public void testSingleStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    assertEquals("name",
                 Interpolator.interpolate("@name@",
                                          ic, "@", "@"));

  }
  @Test
  public void testSingleStylePrefix() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback("pre.");
    assertEquals("@name@ is name",
                 Interpolator.interpolate("@name@ is @pre.name@",
                                          ic, "@", "@"));

  }
  
  
  
  
  
  
  
  
  
  
  
  /**
   * Tests the edges on the label style.
   *
   * <p>
   * Label markers are multi-character labels on either side.
   * For example, ":START:token:STOP:"
   */
  @Test
  public void testEdgesDifferentLabelStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    runEdges(ic,
             ":START:", "", ":STOP:",
             "name", "age");

    String tp = "pre.";
    ic.setTokenPrefix(tp);
    runEdges(ic,
             ":START:", tp, ":STOP:",
             "name", "age");
  }
  
  
  
  
  @Test
  public void testDifferentLabelStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    assertEquals("name",
                 Interpolator.interpolate(":START:name:STOP:",
                                          ic, ":START:", ":STOP:"));


  }
  @Test
  public void testDifferentLabelStylePrefix() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback("pre.");
    assertEquals(":START:name:STOP: is name",
                 Interpolator.interpolate(":START:name:STOP: is :START:pre.name:STOP:",
                                          ic, ":START:", ":STOP:"));


  }
  
  
  
  
  
  




  /**
   * Tests the edges on the label style.
   *
   * <p>
   * Label markers are multi-character labels on either side.
   * For example, ":START:token:STOP:"
   */
  @Test
  public void testEdgesSameLabelStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    runEdges(ic,
             ":TOKEN:", "", ":TOKEN:",
             "name", "age");

    String tp = "pre.";
    ic.setTokenPrefix(tp);
    runEdges(ic,
             ":TOKEN:", tp, ":TOKEN:",
             "name", "age");
  }
  
  @Test
  public void testSameLabelStyle() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    assertEquals("name",
                 Interpolator.interpolate(":TOKEN:name:TOKEN:",
                                          ic, ":TOKEN:", ":TOKEN:"));


  }
  @Test
  public void testSameLabelStylePrefix() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback("pre.");
    assertEquals(":TOKEN:name:TOKEN: is name",
                 Interpolator.interpolate(":TOKEN:name:TOKEN: is :TOKEN:pre.name:TOKEN:",
                                          ic, ":TOKEN:", ":TOKEN:"));


  }
  




  
  
  
  
}
