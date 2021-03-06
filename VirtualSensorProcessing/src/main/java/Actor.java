import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.routing.FromConfig;
import scala.util.parsing.combinator.testing.Str;

import java.util.Objects;

public class Actor extends UntypedActor {
    private LoggingAdapter loggingAdapter;

    public Actor() {
        this.loggingAdapter = Logging.getLogger(this.context().system(), this);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof String) {
            this.loggingAdapter.error(message.toString());

            ActorRef actorRef = this.getContext().actorFor("akka.tcp://Simulation@localhost:2553/user/CEPInterfaceActor");
            actorRef.tell("J'emmerde Romain et son talent",this.sender());
        }
        if (message instanceof MessageForRemoteActors) {
            this.loggingAdapter.error(message.toString());

            ActorRef actorRef = this.getContext().actorFor("akka.tcp://Simulation@localhost:2553/user/CEPInterfaceActor");
            actorRef.tell("Jerome & Romain chez Twitter",this.sender());
        }
        loggingAdapter.error(message.toString());
    }
}
