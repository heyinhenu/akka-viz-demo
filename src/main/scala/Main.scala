import akka.actor.{Actor, ActorSystem, Props}
import spray.SprayDemo

import scala.util.Random

object Main extends App {

  SprayDemo.run(ActorSystem("spray"))

  val system = ActorSystem("small-demos")
  val lazyActorProps = Props(new Actor {
    var counter = 0

    override def receive: Receive = {
      case msg =>
        Thread.sleep(Random.nextInt(2000))
        counter += 1
        sender() ! msg
    }
  })

  val lazyActor1 = system.actorOf(lazyActorProps, "lazy1")
  val lazyActor2 = system.actorOf(lazyActorProps, "lazy2")
  for (i <- 0 to 1000) {
    lazyActor1.tell("doit", lazyActor2)
  }
}
