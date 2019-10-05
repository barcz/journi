package main

import spray.json.DefaultJsonProtocol._

case class Data(newUsers: List[NewUser], tvSpots: List[TvSpot])

trait DataJson extends TVSpotJson with NewUserJson {

  implicit val dataJson = jsonFormat2(Data)

}
