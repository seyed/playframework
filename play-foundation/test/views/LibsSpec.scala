package views

import org.scalatestplus.play.PlaySpec
import org.scalatestplus.play.guice.GuiceOneAppPerTest
import play.api.test.{FakeRequest, Injecting}
import play.api.test.Helpers._

class LibsSpec  extends PlaySpec with GuiceOneAppPerTest with Injecting {


  "The index page" should {
    "have the required JS libraries" in {
      val indexPage = route(app, FakeRequest(GET, "/play-and-foundation")).get
      val jquery = """<script src="/assets/javascripts/jquery.js" type="text/javascript"></script>"""
      val foundation = """<script src="/assets/javascripts/foundation.js" type="text/javascript"></script>"""
      contentAsString(indexPage) must (include (jquery) and include (foundation))
    }

    "have foundation css" in {
      val indexPage = route(app, FakeRequest(GET, "/play-and-foundation")).get
      val requiredStylesheet ="""<link rel="stylesheet" media="screen" href="/assets/stylesheets/foundation.css">"""
      contentAsString(indexPage) must include (requiredStylesheet)
    }

  }

}

