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
        // TODO : ne plus mettre de string mais balader des Objects (mettre un jar ou ...)
        this.actorRef.tell("Je suis 1 ______" + ((RoomSensorEvent)newData[0].getUnderlying()).toString(), ActorRef.noSender());
    }
}
