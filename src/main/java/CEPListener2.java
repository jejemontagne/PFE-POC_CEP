import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by Jerome on 22/01/2015.
 */
public class CEPListener2 implements UpdateListener{
    public void update(EventBean[] newData, EventBean[] oldData) {
        System.out.println("Event received 2: " + newData[0].getUnderlying());
    }
}
