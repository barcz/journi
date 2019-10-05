package main

import java.time.LocalDateTime

import spray.json.DefaultJsonProtocol._

case class NewUser(time: LocalDateTime, userId: Int)


trait NewUserJson {

  import main.DateFormat.DateJsonFormat

  implicit val newUserJson = jsonFormat2(NewUser)
}
