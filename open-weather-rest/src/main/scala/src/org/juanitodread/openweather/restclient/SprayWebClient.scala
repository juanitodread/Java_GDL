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

import akka.actor.ActorSystem

import scala.concurrent.Future

import spray.http._
import spray.client.pipelining._

/**
 * This is the client that consumes the OpenWeather REST service.
 * 
 * @author juansand
 *
 */
class SprayWebClient(implicit system: ActorSystem) extends WebClient {
  import system.dispatcher

  val pipeline: HttpRequest => Future[HttpResponse] = sendReceive 
  
  /**
  * Get the response from the URL and convert the response in String.
  */
  def get(url: String): Future[String] = {
    val futureResponse = pipeline(Get(url))
    futureResponse.map(_.entity.asString)
  }
}
