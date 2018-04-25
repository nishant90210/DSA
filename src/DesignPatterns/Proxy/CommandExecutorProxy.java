package DesignPatterns.Proxy;

/**
 * Created by NISHANT on 4/24/18.
 */
public class CommandExecutorProxy implements CommandExecutor {

    private boolean isAdmin;
    private CommandExecutor commandExecutor;

    public CommandExecutorProxy(String user, String pwd) {

        if ("Nishant".equalsIgnoreCase(user) && "nick".equalsIgnoreCase(pwd)){
            isAdmin = true;
        }
        commandExecutor = new CommandExecutorImpl();
    }

    @Override
    public void runCommand(String cmd) throws Exception {

        if (isAdmin){
            commandExecutor.runCommand(cmd);
        }else {
            if (cmd.trim().startsWith("rm")){
                throw new Exception("rm is only allowed for admin user");
            }else {
                commandExecutor.runCommand(cmd);
            }
        }
    }
}
