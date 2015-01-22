/**
 * Created by Jerome on 22/01/2015.
 */
public class RoomSensor {
    public String value;
    public String name;
    public String timeStamp;

    public RoomSensor(String value, String name, String timeStamp) {
        this.value = value;
        this.name = name;
        this.timeStamp = timeStamp;
    }

    @Override
    public String toString() {
        return "RoomSensor{" +
                "value='" + value + '\'' +
                ", name='" + name + '\'' +
                ", timeStamp='" + timeStamp + '\'' +
                '}';
    }
}