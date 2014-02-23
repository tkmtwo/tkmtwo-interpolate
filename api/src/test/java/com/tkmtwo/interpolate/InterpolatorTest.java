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
import static org.junit.Assert.assertTrue;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.List;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;


/**
 *
 */
public class InterpolatorTest {
  
  @Rule
  public ExpectedException expectedEx = ExpectedException.none();
  
  
  
  
  @Test
  public void testChainDocumentation() {
    String inString = "JDK says ${system.user.home}, but host says ${env.HOME}";
    String outString = String.format("JDK says %s, but host says %s",
                                     System.getProperty("user.home"),
                                     System.getenv("HOME"));
    
    List<InterpolatorCallback> ics = new ArrayList<>();
    ics.add(new EnvariableInterpolatorCallback());
    ics.add(new SystemPropertiesInterpolatorCallback());
    assertEquals(outString,
                 Interpolator.interpolate(inString, ics));
  }


  
  
  
  @Test
  public void testNullStringToInterpolate() {
    expectedEx.expect(NullPointerException.class);
    expectedEx.expectMessage("String to interpolate is null.");
    Interpolator.interpolate((String) null,
                             new EchoInterpolatorCallback(),
                             "someStart",
                             "someStop");
  }
  
  @Test
  public void testNullInterpolatorCallback() {
    expectedEx.expect(NullPointerException.class);
    expectedEx.expectMessage("InterpolatorCallback is null.");
    Interpolator.interpolate("someString",
                             (InterpolatorCallback) null,
                             "someStart",
                             "someStop");
  }
  
  @Test
  public void testNullTokenStart() {
    expectedEx.expect(NullPointerException.class);
    expectedEx.expectMessage("Token start is null.");
    Interpolator.interpolate("someString",
                             new EchoInterpolatorCallback(),
                             (String) null,
                             "someStop");
  }
  @Test
  public void testNullTokenStop() {
    expectedEx.expect(NullPointerException.class);
    expectedEx.expectMessage("Token stop is null.");
    Interpolator.interpolate("someString",
                             new EchoInterpolatorCallback(),
                             "someStart",
                             (String) null);
  }
  
  
  
  
  
  
  
  
  
  
  


  @Test
  public void testChain() {
    String inString = "JDK says ${system.user.home}, but host says ${env.HOME}";
    String outString = String.format("JDK says %s, but host says %s",
                                     System.getProperty("user.home"),
                                     System.getenv("HOME"));
    
    List<InterpolatorCallback> ics = new ArrayList<>();
    ics.add(new EnvariableInterpolatorCallback());
    ics.add(new SystemPropertiesInterpolatorCallback());
    assertEquals(outString,
                 Interpolator.interpolate(inString, ics));
  }
  
  
  
  
  
  
  @Test
  public void testCollection() {
    EchoInterpolatorCallback ic = new EchoInterpolatorCallback();
    
    List<String> srcList = Lists.newArrayList("${name} is my name",
                                              "Friend's name is ${name}",
                                              "Dog's name was ${name} while growing up");
    List<String> dstList = Lists.newArrayList();
    Interpolator.interpolate(srcList, dstList, ic);
    assertTrue(dstList.contains("name is my name"));
    assertTrue(dstList.contains("Friend's name is name"));
    assertTrue(dstList.contains("Dog's name was name while growing up"));
  }
  
  
  
  
  
  
}
