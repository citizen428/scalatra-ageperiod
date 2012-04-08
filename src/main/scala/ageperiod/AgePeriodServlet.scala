package ageperiod

import org.scalatra._
import scalate.ScalateSupport
import org.joda.time._
import org.joda.time.format._

class AgePeriodServlet extends ScalatraServlet with ScalateSupport {

  before() {
    contentType="text/html"
  }

  get("/") {
    templateEngine.layout("/WEB-INF/views/index.scaml")
  }

  get("""^\/period/(\d{8})""".r) {
    val periodString = generatePeriodString(multiParams("captures").head)
    templateEngine.layout("/WEB-INF/views/period.scaml",
                          Map("period" -> periodString))
  }

  post("/period") {
    val periodString = generatePeriodString(params("date"))
    templateEngine.layout("/WEB-INF/views/period.scaml",
      Map("period" -> periodString))
  }

  private def generatePeriodString(date: String): String = {
    val inputFormatter = DateTimeFormat.forPattern("yyyyMMdd")

    val date1 = try {
      inputFormatter.parseDateTime(date).toLocalDate
    } catch {
      case e: IllegalArgumentException => return "Invalid date"
    }

    val date2 = new DateTime().toLocalDate
    val period = new Period(date1, date2)
    val periodFormatter = PeriodFormat.getDefault

    periodFormatter print period
  }

}
