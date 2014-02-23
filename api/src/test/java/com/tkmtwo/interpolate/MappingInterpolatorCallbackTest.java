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

import com.tkmtwo.utility.java.net.URIs;
import java.net.URI;
//import java.util.HashMap;
//import java.util.Map;
//import org.junit.Before;
import org.junit.Test;




/**
 *
 */
public class MappingInterpolatorCallbackTest {
  
  
  @Test
  public void testDocumentationString() {
    MappingInterpolatorCallback<String> ic =
      new MappingInterpolatorCallback<>("stg.",
                                        "num.stooges", "Three",
                                        "fav.stooge", "Shemp");

    assertEquals("My favorite of the ${num.stooges} Stooges is ${fav.stooge}",
                 Interpolator.interpolate("My favorite of the ${num.stooges} Stooges is ${fav.stooge}", ic));
    assertEquals("My favorite of the Three Stooges is Shemp",
                 Interpolator.interpolate("My favorite of the ${stg.num.stooges} Stooges is ${stg.fav.stooge}", ic));
    
  }


  @Test
  public void testDocumentationUri() {
    MappingInterpolatorCallback<URI> ic =
      new MappingInterpolatorCallback<>("uri.",
                                        "google", URIs.valueOf("http://www.google.com/"),
                                        "bing", URIs.valueOf("http://www.bing.com/"));
    
    assertEquals("Two popular search engines are ${google} and ${bing}",
                 Interpolator.interpolate("Two popular search engines are ${google} and ${bing}", ic));
    assertEquals("Two popular search engines are http://www.google.com/ and http://www.bing.com/",
                 Interpolator.interpolate("Two popular search engines are ${uri.google} and ${uri.bing}", ic));
    
  }
  
  
  
  
  
}
