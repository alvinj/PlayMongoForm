package controllers

import play.api._
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import models.Mongo

object MongoController extends Controller {

  val mongoForm = Form(
    mapping(
      "username" -> nonEmptyText(5, 20),
      "middleInitial" -> optional(text),
      "email" -> email,
      "number" -> number,
      "longNumber" -> longNumber,
      "optionalNumber" -> optional(number),
      "date" -> date("yyyy-MM-dd"),    // java.util.Date
      "password" -> nonEmptyText(8),
      "readEula" -> checked("Please accept the terms of the EULA"),
      "yesNoSelect" -> text,           // treat select/option as 'text'
      "yesNoRadio" -> text,            // treat radio buttons as 'text'
      "stocks" -> list(text),
      "notes" -> optional(text),
      "ignored" -> ignored("foo")      // static value
    )(Mongo.apply)(Mongo.unapply)
  )

  def add = Action {
    Ok(views.html.mongoform(mongoForm))
  }

  /**
   * Handle the 'add' form submission.
   */
  def save = Action { implicit request =>
    mongoForm.bindFromRequest.fold(
      errors => BadRequest(views.html.mongoform(errors)),
      stock => {
        // would normally do a 'save' here
        Redirect(routes.MongoController.add)
      }
    )
  }

}





