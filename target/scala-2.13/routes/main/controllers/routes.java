// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Music/OOPCW-master/conf/routes
// @DATE:Sun Jan 03 14:52:56 IST 2021

package controllers;

import router.RoutesPrefix;

public class routes {
  
  public static final controllers.ReverseFrontendController FrontendController = new controllers.ReverseFrontendController(RoutesPrefix.byNamePrefix());
  public static final controllers.ReversePremierLeagueController PremierLeagueController = new controllers.ReversePremierLeagueController(RoutesPrefix.byNamePrefix());

  public static class javascript {
    
    public static final controllers.javascript.ReverseFrontendController FrontendController = new controllers.javascript.ReverseFrontendController(RoutesPrefix.byNamePrefix());
    public static final controllers.javascript.ReversePremierLeagueController PremierLeagueController = new controllers.javascript.ReversePremierLeagueController(RoutesPrefix.byNamePrefix());
  }

}
