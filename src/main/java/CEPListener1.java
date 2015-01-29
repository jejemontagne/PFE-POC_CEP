import akka.actor.ActorRef;
import com.espertech.esper.client.*;

/**
 * Created by Jerome on 22/01/2015.
 */
public class CEPListener1 implements UpdateListener{
    public ActorRef actorRef;
    public CEPListener1(ActorRef actorRef) {
        this.actorRef = actorRef;
    }

    public void update(final EventBean[] newData, EventBean[] oldData) {
        this.actorRef.tell(newData[0].getUnderlying(), ActorRef.noSender());
    }
}
