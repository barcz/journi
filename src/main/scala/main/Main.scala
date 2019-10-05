package main

import spray.json._

import scala.io.Source

object Main extends App with DataJson {

  val allData = Source.fromResource("new_users.json").getLines().mkString.parseJson.convertTo[Data]

  allData
    .tvSpots
    .map { tvSpot =>

      val usersAfter: Seq[NewUser] = allData.newUsers.filter(nu =>
        (nu.time.isAfter(tvSpot.time) && nu.time.isBefore(tvSpot.time.plusMinutes(10)))
          || nu.time.isEqual(tvSpot.time))

      val usersBefore: Seq[NewUser] = allData.newUsers.filter(nu =>
        nu.time.isBefore(tvSpot.time) && nu.time.isAfter(tvSpot.time.minusMinutes(10)))

      val newUsers: Int = usersAfter.length - usersBefore.length

      (tvSpot.spotId, newUsers)

    }.foreach(res => println(s"Spot ${res._1}: ${res._2} new users"))


}
