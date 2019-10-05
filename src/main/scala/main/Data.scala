package main

import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

case class Data(newUsers: List[NewUser], tvSpots: List[TvSpot])

trait DataJson extends TVSpotJson with NewUserJson {

  implicit val dataJson: RootJsonFormat[Data] = jsonFormat2(Data)

}
