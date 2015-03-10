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

import spray.json.DefaultJsonProtocol

/**
 * Case classes to represent JSON structure in Scala objects.
 * 
 * @author juansand
 *
 */
case class Coord(lon: Double, lat: Double)
case class Sys(message: Double, country: String, sunrise: Long, sunset: Long)
case class Weather(id: Int, main: String, description: String, icon: String)
case class Main(temp: Double, pressure: Int, humidity: Int, temp_min: Double, temp_max: Double)
case class Wind(speed: Double, deg: Int)
case class Cloud(all: Int)
case class WeatherApiResult(coord: Coord, 
                            sys: Sys, 
                            weather: List[Weather], 
                            base: String, 
                            main: Main, 
                            wind: Wind, 
                            clouds: Cloud, 
                            dt: Long, 
                            id: Long, 
                            name: String, 

                            cod: Int)
/**
 * This is a Weather JSON protocol to marshall/unmarshall the 
 * web service response.
 * 
 * @author juansand
 *
 */
object WeatherJsonProtocol extends DefaultJsonProtocol {
  implicit val coordFormat = jsonFormat2(Coord)
  implicit val sysFormat = jsonFormat4(Sys)
  implicit val weatherFormat = jsonFormat4(Weather)
  implicit val mainFormat = jsonFormat5(Main)
  implicit val windFormat = jsonFormat2(Wind)
  implicit val cloudFormat = jsonFormat1(Cloud)
  implicit val weatherApiResultFormat = jsonFormat11(WeatherApiResult.apply)
}
