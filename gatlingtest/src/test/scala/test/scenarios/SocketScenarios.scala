package test.scenarios

/**
  * Created by yingkai.qyk on 2018/5/22.
  */
import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._


trait SocketScenarios{

  val httpConf = http.baseURL("http://127.0.0.1")
    .wsBaseURL("ws://127.0.0.1:5678")

  val listener = scenario("listener")
    .exec(
      ws("Connect WebSocket")
        .wsName("time")
        .open("/")
    )
    .forever(
      exec(
        ws("Keep Listening").wsName("time")
          .check(
            wsAwait.within(500 milliseconds)
              .until(1)
//              .regex("")
          )
      )
    )





}



