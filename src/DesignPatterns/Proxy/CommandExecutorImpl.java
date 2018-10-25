package DesignPatterns.Proxy;

/**
 * Created by NISHANT on 4/24/18.
 */
public class CommandExecutorImpl implements CommandExecutor {

    @Override
    public void runCommand(String cmd) throws Exception {
        Runtime.getRuntime().exec(cmd);
    }
}
