package ageperiod

import org.scalatra.test.specs2._

class AgePeriodMutableServletSpec extends MutableScalatraSpec {
  addServlet(classOf[AgePeriodServlet], "/*")

  "GET / on AgePeriodServlet" should {
    "return status 200" in {
       get("/") {
        status must_== 200
      }
    }
  }
  
  /*"A GET request on /period" should {
    "should return a formatted period for valid input" in {
      get("/period/20000101") {
        status must_== 200
        body must beMatching("\\d+ years?, \\d+ months?, \\d+ weeks? and \\d+ days?")

      }
    }
    
    "should return \"Invalid date\" for bad input" in {
      get("/period/20120230") {
        status must_== 200
        body must beMatching(".*Invalid date.*")
      }
    }*/
  }
  
}