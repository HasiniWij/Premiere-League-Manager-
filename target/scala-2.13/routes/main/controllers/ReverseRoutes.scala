// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Music/OOPCW-master/conf/routes
// @DATE:Sun Jan 03 14:52:56 IST 2021

import play.api.mvc.Call


import _root_.controllers.Assets.Asset
import _root_.play.libs.F

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseFrontendController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def assetOrDefault(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:8
  class ReversePremierLeagueController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:12
    def clubByGoal(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/byGoal")
    }
  
    // @LINE:10
    def clubByWin(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/byWin")
    }
  
    // @LINE:16
    def generateMatch(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/generateMatch")
    }
  
    // @LINE:18
    def matchForDate(date:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/matches" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("date", date)))
    }
  
    // @LINE:14
    def viewMatch(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/viewMatch")
    }
  
    // @LINE:8
    def viewTable(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "api/club")
    }
  
  }


}
