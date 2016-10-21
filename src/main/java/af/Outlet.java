package af;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;

import java.io.IOException;

/**
 * Created by ekrbj on 2014-06-17.
 */
public class Outlet {
    private CommandLine cmdLineOn;
    private CommandLine cmdLineOff;

    public Outlet(String name) {
        cmdLineOn = new CommandLine("C:\\Program Files (x86)\\Telldus\\tdtool.exe").addArgument("--on").addArgument(name);
        cmdLineOff = new CommandLine("C:\\Program Files (x86)\\Telldus\\tdtool.exe").addArgument("--off").addArgument(name);
    }

    public void turnOn() {
        DefaultExecutor executor = new DefaultExecutor();
        try {
            executor.execute(cmdLineOn);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void turnOff() {
        DefaultExecutor executor = new DefaultExecutor();
        try {
            executor.execute(cmdLineOff);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
