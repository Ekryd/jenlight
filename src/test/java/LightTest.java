import af.Outlet;
import org.junit.Test;

/**
 * Created by ekrbj on 2014-06-17.
 */
public class LightTest {
    @Test
    public void turnOnSocket() {
        Outlet kontakt1 = new Outlet("Kontakt1");
        kontakt1.turnOn();
    }

    @Test
    public void turnOffSocket() {
        Outlet kontakt1 = new Outlet("Kontakt1");
        kontakt1.turnOff();
    }
}
