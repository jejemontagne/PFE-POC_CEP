import com.espertech.esper.client.*;

/**
 * Created by Jerome on 22/01/2015.
 */
public class CEPListener1 implements UpdateListener{
    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("Event received: " + newData[0].getUnderlying());

    }
}
