package DesignPatterns.Proxy;

/**
 * Created by NISHANT on 4/24/18.
 */
public class ProxyPatternTest {

    public static void main(String[] args) {

        CommandExecutor commandExecutor = new CommandExecutorProxy("nishant", "nick1");
        try {
            commandExecutor.runCommand("ls-ltr");
            commandExecutor.runCommand(" rm -rf abc.pdf");
        } catch (Exception e) {
            System.out.println("Exception Message :: " + e.getMessage());
        }
    }
}
