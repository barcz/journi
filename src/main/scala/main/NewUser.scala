package main

import java.time.LocalDateTime

import spray.json.DefaultJsonProtocol._
import spray.json.RootJsonFormat

case class NewUser(time: LocalDateTime, userId: Int)


trait NewUserJson {

  import main.DateFormat.DateJsonFormat

  implicit val newUserJson: RootJsonFormat[NewUser] = jsonFormat2(NewUser)
}
