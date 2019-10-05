package main

import java.time.LocalDateTime

import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

case class TvSpot(time: LocalDateTime, spotId: Int)

trait TVSpotJson {

  import main.DateFormat.DateJsonFormat

  implicit val tvSpotJson: RootJsonFormat[TvSpot] = jsonFormat2(TvSpot)
}
