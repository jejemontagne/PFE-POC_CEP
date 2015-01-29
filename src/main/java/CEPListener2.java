import com.espertech.esper.client.EventBean;
import com.espertech.esper.client.UpdateListener;

/**
 * Created by Jerome on 22/01/2015.
 */
public class CEPListener2 implements UpdateListener{
    public void update(final EventBean[] newData, EventBean[] oldData) {
        new Thread(){
            @Override
            public void run() {

                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Event received 2: " + newData[0].getUnderlying());
            }
        }.start();
    }
}
