import com.espertech.esper.client.*;
import java.util.Random;


/**
 * Created by Jerome on 22/01/2015.
 */
public class Main {
    public static void main(String[] args) {
        //The Configuration is meant only as an initialization-time object.
        Configuration cepConfig = new Configuration();
        cepConfig.addEventType("StockParkingSensor", ParkingSensor.class.getName());
        cepConfig.addEventType("StockRoomSensor", RoomSensor.class.getName());
        EPServiceProvider cep = EPServiceProviderManager.getProvider("myCEPEngine", cepConfig);
        EPRuntime cepRT = cep.getEPRuntime();

        EPAdministrator cepAdm = cep.getEPAdministrator();
        EPStatement cepStatement1 = cepAdm.createEPL("select * from " +
                "StockRoomSensor as r, StockParkingSensor as p");
//        EPStatement cepStatementbis = cepAdm.createEPL("select * from " +
//                "StockRoomSensor");
//
//        EPStatement cepStatement2 = cepAdm.createEPL("select * from " +
//                "StockParkingSensor");

        cepStatement1.addListener(new CEPListener1());
//        cepStatementbis.addListener(new CEPListener1());

        //cepStatement2.addListener(new CEPListener2());

        // We generate a few ticks...
        for (int i = 0; i < 5; i++) {
            GenerateRandomTick(cepRT);
        }
    }

    private static Random generator = new Random();

    public static void GenerateRandomTick(EPRuntime cepRT) {

        double price = (double) generator.nextInt(10);
        long timeStamp = System.currentTimeMillis();
        String symbol = "AAPL";
        ParkingSensor tick = new ParkingSensor("\tPark\t", "12", String.valueOf(timeStamp));
        //System.out.println("\nSending tick:" + tick);
        cepRT.sendEvent(tick);


        RoomSensor tick2 = new RoomSensor("\tRoom\t", "12", "2"+String.valueOf(timeStamp));
        //System.out.println("\nSending tick 2:" + tick2);
        cepRT.sendEvent(tick2);

    }
}
