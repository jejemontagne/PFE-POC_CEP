import akka.actor.ActorRef;
import com.espertech.esper.client.*;

public class CEPListener implements UpdateListener{
    public ActorRef actorRef;
    public CEPListener(ActorRef actorRef) {
        this.actorRef = actorRef;
    }

    public void update(final EventBean[] newData, EventBean[] oldData) {
        // TODO : ne plus mettre de string mais balader des Objects (mettre un jar ou ...)
        MessageForRemoteActors messageForRemoteActors = new MessageForRemoteActors(((CEPEvent)newData[0].getUnderlying()).toString());
        this.actorRef.tell(messageForRemoteActors, ActorRef.noSender());
    }
}
