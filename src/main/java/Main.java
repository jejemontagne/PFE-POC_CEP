import akka.actor.ActorSystem;
import akka.actor.Props;
import com.espertech.esper.client.*;
import com.typesafe.config.ConfigFactory;

import java.util.Random;


/**
 * Created by Jerome on 22/01/2015.
 */
public class Main {
    public static void main(String[] args) {
        //The Configuration is meant only as an initialization-time object.
        Configuration cepConfig = new Configuration();
        /** registerEventType **/
        cepConfig.addEventType("StockParkingSensor", ParkingSensorEvent.class.getName());
        cepConfig.addEventType("StockRoomSensor", RoomSensorEvent.class.getName());
        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);

        EPRuntime cepRT = cep.getEPRuntime();
        EPAdministrator cepAdm = cep.getEPAdministrator();

        /** Deploy Statement **/
        EPStatement cepStatement1 = cepAdm.createEPL("" +
                "select a, b \n" +
                "  from StockRoomSensor.win:time(30 minutes) a , StockParkingSensor.win:time(30 minutes) b" +
                " where a.name = b.name");
        // TODO : event a la volée !!
        // TODO : join dans les requetes !!
        EPStatement cepStatementbis = cepAdm.createEPL("select * from StockRoomSensor");
//        EPStatement cepStatement2 = cepAdm.createEPL("select * from StockParkingSensor");

        /** Creation of the system **/
        ActorSystem system = ActorSystem.create("Simulation", ConfigFactory.load());

        cepStatement1.addListener(new CEPListener1(system.actorOf(Props.create(VirtualSensor.class),"cepStatement1")));
        cepStatementbis.addListener(new CEPListener1(system.actorOf(Props.create(VirtualSensor.class),"cepStatementbis")));
//        cepStatement2.addListener(new CEPListener2());

        // We generate a few ticks...
        for (int i = 0; i < 5; i++) {
            GenerateRandomTick(cepRT,i);
        }
    }

    private static Random generator = new Random();

    public static void GenerateRandomTick(EPRuntime cepRT,int i) {

        double price = (double) generator.nextInt(10);
        long timeStamp = System.currentTimeMillis();
        String symbol = "AAPL";
        ParkingSensorEvent tick = new ParkingSensorEvent("\tPark"+i+"\t", String.valueOf(12+i), String.valueOf(timeStamp));
        //System.out.println("\nSending tick:" + tick);
        cepRT.sendEvent(tick);


        RoomSensorEvent tick2 = new RoomSensorEvent("\tRoom\"+i+\"\t", "12", "2"+String.valueOf(timeStamp));
        //System.out.println("\nSending tick 2:" + tick2);
        cepRT.sendEvent(tick2);

    }
}
