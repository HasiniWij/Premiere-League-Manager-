// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/User/Music/OOPCW-master/conf/routes
// @DATE:Sun Jan 03 14:52:56 IST 2021


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
