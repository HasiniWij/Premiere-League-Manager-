// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Music/OOPCW-master/conf/routes
// @DATE:Sun Jan 03 14:52:56 IST 2021

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseFrontendController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def assetOrDefault: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FrontendController.assetOrDefault",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.FrontendController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:8
  class ReversePremierLeagueController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def clubByGoal: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.clubByGoal",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/byGoal"})
        }
      """
    )
  
    // @LINE:10
    def clubByWin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.clubByWin",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/byWin"})
        }
      """
    )
  
    // @LINE:16
    def generateMatch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.generateMatch",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/generateMatch"})
        }
      """
    )
  
    // @LINE:18
    def matchForDate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.matchForDate",
      """
        function(date0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/matches" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("date", date0))})
        }
      """
    )
  
    // @LINE:14
    def viewMatch: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.viewMatch",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/viewMatch"})
        }
      """
    )
  
    // @LINE:8
    def viewTable: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PremierLeagueController.viewTable",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "api/club"})
        }
      """
    )
  
  }


}
