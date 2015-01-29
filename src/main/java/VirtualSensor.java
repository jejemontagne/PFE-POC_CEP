import akka.actor.UntypedActor;

/**
 * Created by Jerome on 29/01/2015.
 */
public class VirtualSensor extends UntypedActor{
    @Override
    public void onReceive(Object o) throws Exception {
        if (o instanceof RoomSensorEvent){
            RoomSensorEvent roomSensorEvent = (RoomSensorEvent)o;
            System.out.println("Event received: " + roomSensorEvent.toString());
        }
    }
}
