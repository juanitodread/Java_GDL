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
import sbt._

/**
 * Project dependencies.
 * 
 * @author juansand
 *
 */
object Dependencies {
	// versions
	lazy val akkaVersion = "2.3.6"
	lazy val sprayVerion = "1.3.1"

	// libraries
	val akkaActor   = "com.typesafe.akka" %% "akka-actor" % akkaVersion
	val sprayHttp   = "io.spray" %% "spray-http" % sprayVerion
	val sprayClient = "io.spray" %% "spray-client" % sprayVerion
	val sprayJson   = "io.spray" %% "spray-json" % sprayVerion

	// projects
	val backendDeps = Seq(akkaActor, 
                          sprayHttp, 
                          sprayClient, 
                          sprayJson)
}
