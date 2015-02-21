import java.io.Serializable;

/**
 * Created by Jerome on 21/02/2015.
 */
public class MessageForRemoteActors implements Serializable{
    private String string;
    private static final long serialVersionUID = 7526472295622776147L;

    public MessageForRemoteActors(String s) {
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
}
