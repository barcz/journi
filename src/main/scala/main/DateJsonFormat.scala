package main

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

import spray.json.{JsString, JsValue, RootJsonFormat}

object DateFormat {

  implicit object DateJsonFormat extends RootJsonFormat[LocalDateTime] {

    private val parser: DateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME

    override def write(obj: LocalDateTime) = JsString(parser.format(obj))

    override def read(json: JsValue): LocalDateTime = json match {
      case JsString(s) => LocalDateTime.parse(s, parser)
      case _ => throw new Exception("Malformed datetime")
    }
  }

}
