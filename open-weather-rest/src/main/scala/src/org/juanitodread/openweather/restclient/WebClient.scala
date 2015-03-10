/**
 * Openweather REST Service
 *
 * Copyright 2015 juanitodread
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
package org.juanitodread.openweather.restclient

import scala.concurrent.Future

/**
 * Trait with single function to make a GET request
 * 
 * @author juansand
 *
 */
trait WebClient {

  /**
  * Simple trait that defines the get method to consume the service.
  */
  def get(url: String): Future[String]
  
}
