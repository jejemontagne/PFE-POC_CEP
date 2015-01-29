import akka.actor.*;
import akka.dispatch.Dispatchers;
import akka.dispatch.Mailboxes;
import akka.event.EventStream;
import akka.event.LoggingAdapter;
import com.typesafe.config.ConfigFactory;
import scala.Function0;
import scala.collection.*;
import scala.concurrent.ExecutionContextExecutor;
import scala.concurrent.duration.Duration;

/**
 * Created by Jerome on 29/01/2015.
 */
public class Main {
    public static void main(String[] args) {
        // creation of the actor system (Actor factory)
        ActorSystem actorSystem = ActorSystem.create("ActorSystemFactory", ConfigFactory.load());

//        ActorRef actorRef = actorSystem.actorOf(Props.create(Actor.class), "Actor");
//        actorRef.tell("coucou", ActorRef.noSender());

    }
}
