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
import akka.io.IO
import akka.pattern.ask
import scala.util.{Success, Failure}
import scala.concurrent.Future
import scala.concurrent.duration._
import spray.json.JsonParser
import spray.can.Http

import org.juanitodread.openweather.restclient.WeatherJsonProtocol._

/**
 * Main app that invokes URL REST service and transform the response in 
 * an Scala object and print the response.
 * 
 * @author juansand
 *
 */
object ConsumeApp {
  /* Get the Actor context */
  implicit val system = ActorSystem()
  
  val restServiceUrl = "http://api.openweathermap.org/data/2.5/weather?id=4005539"

  def main(args: Array[String]): Unit = {
    import system.dispatcher
    
    println("Starting consumer...")
    val webClient = new SprayWebClient()(system)
    
    val futureResponse = webClient.get(restServiceUrl)
    
    futureResponse onComplete { 
      case Success(response) => {
        
        val jsonAst = JsonParser(response)
        val weatherApiResult = jsonAst.convertTo[WeatherApiResult]
        println(s"Raw response (JSON string):\n\n${response}\n")
        println(s"""City: ${weatherApiResult.name}
Coord: (${weatherApiResult.coord.lon},${weatherApiResult.coord.lat})
General:
    Temp: ${weatherApiResult.main.temp}
    Pressure: ${weatherApiResult.main.pressure}
    Humidity: ${weatherApiResult.main.humidity}

""")
        shutdown
      }
      case Failure(error) => {
        println(s"An error has occured: ${error.getMessage}")
        shutdown
      }
    }
  }
  
  def shutdown(): Unit = {
    IO(Http).ask(Http.CloseAll)(1.second)
    system.shutdown
  }
}
