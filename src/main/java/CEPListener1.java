import com.espertech.esper.client.*;

/**
 * Created by Jerome on 22/01/2015.
 */
public class CEPListener1 implements UpdateListener{
    public void update(final EventBean[] newData, EventBean[] oldData) {
        new Thread() {
            @Override
            public void run() {

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Event received: " + newData[0].getUnderlying());
            }
        }.start();
    }
}
