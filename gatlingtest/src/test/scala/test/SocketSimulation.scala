package test

import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import test.scenarios.SocketScenarios

import scala.concurrent.duration._

class SocketSimulation extends Simulation with SocketScenarios  {

  val queryUserNum = 100
  val rampUpDuration = (30 seconds)
  val simulationDuration = (10 seconds)
  setUp(
//    listener.inject(rampUsers(queryUserNum) over (rampUpDuration )),
    listener.inject(atOnceUsers(1)),

  ).protocols(httpConf).maxDuration(simulationDuration)


}
