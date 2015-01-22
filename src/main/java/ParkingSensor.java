/**
 * Created by Jerome on 22/01/2015.
 */
public class ParkingSensor {
    public String value;
    public String name;
    public String timeStamp;

    public ParkingSensor(String value, String name, String timeStamp) {
        this.value = value;
        this.name = name;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "ParkingSensor{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}