import Dependencies._
import com.github.retronym.SbtOneJar._

oneJarSettings

lazy val root = (project in file(".")).
	settings(
		name := "Openweather REST Service",
		version := "1.0",
		organization := "org.juanitodread.scalastbtest"
	).
	settings (
		libraryDependencies ++= backendDeps
	)
