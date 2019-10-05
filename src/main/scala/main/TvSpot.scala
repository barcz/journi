package main

import java.time.LocalDateTime

import spray.json.DefaultJsonProtocol._

case class TvSpot(time: LocalDateTime, spotId: Int)

trait TVSpotJson {
  import main.DateFormat.DateJsonFormat
  implicit val tvSpotJson = jsonFormat2(TvSpot)
}
