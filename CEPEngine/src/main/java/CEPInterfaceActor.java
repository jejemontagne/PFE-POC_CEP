import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

/**
 * Created by Jerome on 29/01/2015.
 */
public class CEPInterfaceActor extends UntypedActor {
    private LoggingAdapter loggingAdapter;

    public CEPInterfaceActor() {
        this.loggingAdapter = Logging.getLogger(this.context().system(), this);
    }


    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Object){
            this.loggingAdapter.error(message.toString() + "coucou");
        }
    }
}