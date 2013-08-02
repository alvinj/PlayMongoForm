package models

import java.util.Date

case class Mongo (
  username: String,
  middleInitial: Option[String],
  email: String,
  number: Int,
  longNumber: Long,
  optionalNumber: Option[Int],
  date: Date,
  password: String,
  readEula: Boolean,
  yesNoSelect: String,
  yesNoRadio: String,
  stocks: List[String],
  notes: Option[String],
  ignored: String
) 

