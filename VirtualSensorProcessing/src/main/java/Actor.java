import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import scala.util.parsing.combinator.testing.Str;

import java.util.Objects;

/**
 * Created by Jerome on 29/01/2015.
 */
public class Actor extends UntypedActor {
    private LoggingAdapter loggingAdapter;

    public Actor() {
        this.loggingAdapter = Logging.getLogger(this.context().system(),this);
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if(message instanceof String){
            this.loggingAdapter.debug(message.toString());

        }
        loggingAdapter.error(message.toString());
    }
}
