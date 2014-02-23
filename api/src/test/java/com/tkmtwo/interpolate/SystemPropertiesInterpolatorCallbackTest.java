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
public class SystemPropertiesInterpolatorCallbackTest {
  
  
  @Test
  public void testDocumentationMatch() {

    //Default prefix of "system." -- matching
    assertEquals(String.format("my OS is the %s operating system", System.getProperty("os.name")),
                 Interpolator.interpolate("my OS is the ${system.os.name} operating system",
                                          new SystemPropertiesInterpolatorCallback()));

    //Custom prefix of "jsp."
    assertEquals(String.format("my OS is the %s operating system", System.getProperty("os.name")),
                 Interpolator.interpolate("my OS is the ${jsp.os.name} operating system",
                                          new SystemPropertiesInterpolatorCallback("jsp.")));
  }
                                          
  @Test
  public void testDocumentationNonmatch() {

    //Default prefix of "system." -- non-matching
    assertEquals("my OS is the ${system.nosuch} operating system",
                 Interpolator.interpolate("my OS is the ${system.nosuch} operating system",
                                          new SystemPropertiesInterpolatorCallback()));
    //Custom prefix of "jsp." -- non-matching
    assertEquals("my OS is the ${jsp.nosuch} operating system",
                 Interpolator.interpolate("my OS is the ${jsp.nosuch} operating system",
                                          new SystemPropertiesInterpolatorCallback()));
  }
  
}
