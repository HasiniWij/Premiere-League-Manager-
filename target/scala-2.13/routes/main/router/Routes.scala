// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Music/OOPCW-master/conf/routes
// @DATE:Sun Jan 03 14:52:56 IST 2021

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset
import _root_.play.libs.F

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  FrontendController_1: controllers.FrontendController,
  // @LINE:8
  PremierLeagueController_0: controllers.PremierLeagueController,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    FrontendController_1: controllers.FrontendController,
    // @LINE:8
    PremierLeagueController_0: controllers.PremierLeagueController
  ) = this(errorHandler, FrontendController_1, PremierLeagueController_0, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, FrontendController_1, PremierLeagueController_0, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.FrontendController.index()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/club""", """controllers.PremierLeagueController.viewTable()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/byWin""", """controllers.PremierLeagueController.clubByWin()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/byGoal""", """controllers.PremierLeagueController.clubByGoal()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/viewMatch""", """controllers.PremierLeagueController.viewMatch()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/generateMatch""", """controllers.PremierLeagueController.generateMatch()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """api/matches""" + "$" + """date<[^/]+>""", """controllers.PremierLeagueController.matchForDate(date:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """""" + "$" + """file<.+>""", """controllers.FrontendController.assetOrDefault(file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_FrontendController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_FrontendController_index0_invoker = createInvoker(
    FrontendController_1.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FrontendController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Routes
 This file defines all application routes (Higher priority routes first)
 ~~~~
 An example route (Prefix all API routes with apiPrefix defined in application.conf)
 Serve index page from public directory""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PremierLeagueController_viewTable1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/club")))
  )
  private[this] lazy val controllers_PremierLeagueController_viewTable1_invoker = createInvoker(
    PremierLeagueController_0.viewTable(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "viewTable",
      Nil,
      "GET",
      this.prefix + """api/club""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_PremierLeagueController_clubByWin2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/byWin")))
  )
  private[this] lazy val controllers_PremierLeagueController_clubByWin2_invoker = createInvoker(
    PremierLeagueController_0.clubByWin(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "clubByWin",
      Nil,
      "GET",
      this.prefix + """api/byWin""",
      """""",
      Seq()
    )
  )

  // @LINE:12
  private[this] lazy val controllers_PremierLeagueController_clubByGoal3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/byGoal")))
  )
  private[this] lazy val controllers_PremierLeagueController_clubByGoal3_invoker = createInvoker(
    PremierLeagueController_0.clubByGoal(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "clubByGoal",
      Nil,
      "GET",
      this.prefix + """api/byGoal""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_PremierLeagueController_viewMatch4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/viewMatch")))
  )
  private[this] lazy val controllers_PremierLeagueController_viewMatch4_invoker = createInvoker(
    PremierLeagueController_0.viewMatch(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "viewMatch",
      Nil,
      "GET",
      this.prefix + """api/viewMatch""",
      """""",
      Seq()
    )
  )

  // @LINE:16
  private[this] lazy val controllers_PremierLeagueController_generateMatch5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/generateMatch")))
  )
  private[this] lazy val controllers_PremierLeagueController_generateMatch5_invoker = createInvoker(
    PremierLeagueController_0.generateMatch(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "generateMatch",
      Nil,
      "GET",
      this.prefix + """api/generateMatch""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_PremierLeagueController_matchForDate6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("api/matches"), DynamicPart("date", """[^/]+""",true)))
  )
  private[this] lazy val controllers_PremierLeagueController_matchForDate6_invoker = createInvoker(
    PremierLeagueController_0.matchForDate(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PremierLeagueController",
      "matchForDate",
      Seq(classOf[String]),
      "GET",
      this.prefix + """api/matches""" + "$" + """date<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_FrontendController_assetOrDefault7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_FrontendController_assetOrDefault7_invoker = createInvoker(
    FrontendController_1.assetOrDefault(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.FrontendController",
      "assetOrDefault",
      Seq(classOf[String]),
      "GET",
      this.prefix + """""" + "$" + """file<.+>""",
      """ Serve static assets under public directory""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_FrontendController_index0_route(params@_) =>
      call { 
        controllers_FrontendController_index0_invoker.call(FrontendController_1.index())
      }
  
    // @LINE:8
    case controllers_PremierLeagueController_viewTable1_route(params@_) =>
      call { 
        controllers_PremierLeagueController_viewTable1_invoker.call(PremierLeagueController_0.viewTable())
      }
  
    // @LINE:10
    case controllers_PremierLeagueController_clubByWin2_route(params@_) =>
      call { 
        controllers_PremierLeagueController_clubByWin2_invoker.call(PremierLeagueController_0.clubByWin())
      }
  
    // @LINE:12
    case controllers_PremierLeagueController_clubByGoal3_route(params@_) =>
      call { 
        controllers_PremierLeagueController_clubByGoal3_invoker.call(PremierLeagueController_0.clubByGoal())
      }
  
    // @LINE:14
    case controllers_PremierLeagueController_viewMatch4_route(params@_) =>
      call { 
        controllers_PremierLeagueController_viewMatch4_invoker.call(PremierLeagueController_0.viewMatch())
      }
  
    // @LINE:16
    case controllers_PremierLeagueController_generateMatch5_route(params@_) =>
      call { 
        controllers_PremierLeagueController_generateMatch5_invoker.call(PremierLeagueController_0.generateMatch())
      }
  
    // @LINE:18
    case controllers_PremierLeagueController_matchForDate6_route(params@_) =>
      call(params.fromPath[String]("date", None)) { (date) =>
        controllers_PremierLeagueController_matchForDate6_invoker.call(PremierLeagueController_0.matchForDate(date))
      }
  
    // @LINE:21
    case controllers_FrontendController_assetOrDefault7_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_FrontendController_assetOrDefault7_invoker.call(FrontendController_1.assetOrDefault(file))
      }
  }
}
