import akka.actor.ActorRef;
import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by Jerome on 22/01/2015.
 */
public class CEPListener2 implements UpdateListener{
    public ActorRef actorRef;
    public CEPListener2(ActorRef actorRef) {
        this.actorRef = actorRef;
    }

    public void update(final EventBean[] newData, EventBean[] oldData) {
        // TODO : ne plus mettre de string mais balader des Objects (mettre un jar ou ...)
        this.actorRef.tell(" ____  Je suis 2" + ((ParkingSensorEvent) newData[0].getUnderlying()).toString(), ActorRef.noSender());
    }
}
