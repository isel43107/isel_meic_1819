/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package isel.es1819.jp.sgpfconsole;

//import org.apache.commons.lang3.StringUtils; 
import java.io.IOException;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jline.reader.History;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.impl.completer.StringsCompleter;
import org.jline.reader.impl.history.DefaultHistory;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;

/**
 *
 * @author pauloborges
 */
public class SgpfBaseRunner {

    static final Logger LOGGER = Logger.getLogger(SgpfBaseRunner.class.getName());

    //console output set to System.out 
    protected PrintStream out = System.out;
    private History history;
    // for the interactive shell 
    private String helloMessage = "Bem vindo";
    private String prompt = "sgpf>";

    public void run(String[] args) {
        try {
            if (args == null || args.length == 0) {
                runInteractive();
            } else {
                for (String cmd : args) {
                    // split into command name and arguments 
                    String[] split = cmd.split("\\s+", 2);
                    System.out.println("executando o comando '" + cmd + "'");
                    runCommand(split[0], split.length >= 2 ? split[1] : "");
                }
            }
        } catch (IOException e) {
            LOGGER.warning("Uncaught exception: " + e);
            error(e);
        }
    }

    public void runInteractive() throws IOException {
        System.out.println(helloMessage);
        System.out.println();
        System.out.println("Usa \"ajuda\" para listar todas as opcoes.");
        System.out.println();

        Terminal terminal = TerminalBuilder.builder()
                .system(true)
                .build();

        history = new DefaultHistory();
        
       
        List<String> commands  = new ArrayList<>();
        detectAvailableCommands().stream().forEach((option) -> {
               commands.add(option.getCommand());
        });
        Collections.sort(commands);

        LineReader reader = LineReaderBuilder.builder()
                .terminal(terminal)
                .history(history)
                .completer(new StringsCompleter(commands))
                .build();

        String line;
        while ((line = reader.readLine(prompt + " ")) != null) {
            try {
                
                String[] commandAndArgs = line.split(" ");
                
                String command = "";
                String[] arguments = null;
                if(commandAndArgs != null && commandAndArgs.length > 0){
                    command = commandAndArgs[0];
   
                    //System.out.println("Command and args length: "+commandAndArgs.length);
               
                    String argumentLine = line.substring(command.length(), line.length());
                    if(argumentLine != null){
                        arguments = argumentLine.split(";");
                        if(arguments == null){
                            arguments = new String[]{""};
                        }
                        
                        //System.out.println("Arguments length: "+argumentLine.length() + ", split: "+arguments.length);
                    }
                    
                    if(commandAndArgs.length > 0){
                        command = commandAndArgs[0];
                    }
                }

                if("".equalsIgnoreCase(command)){
                    System.out.println("Usa \"ajuda\" para listar todas as opcoes.");
                }
                if ("ajuda".equalsIgnoreCase(command)) {
                    System.out.println("Opcoes disponiveis:");
                    showAvailableCommands();
                } else {
                    runCommand(command, arguments);
                }
            } catch (IndexOutOfBoundsException e) {
            } catch (Exception e) {
                error(e);
            }
        } // end while 
    }

    protected void runCommand(String command, String[] args) {
        String methodName = "do" + command.substring(0, 1).toUpperCase() + command.substring(1);

        try {
            Method commandMethod = getClass().getMethod(methodName, String.class);
            commandMethod.invoke(this, (String[])args);
        } catch (NoSuchMethodException | InvocationTargetException e) {
            error("opção não existe ou parametros invaliddos");
        } catch (SecurityException | IllegalAccessException | IllegalArgumentException ex) {
            LOGGER.log(Level.SEVERE, null, ex);
        }

    }

    protected void error(Throwable e) {
        error(e.getMessage());
    }

    protected void error(String error) {
        System.out.println();
        System.out.println("ERROR: " + error);
    }

    protected List<AppOption> detectAvailableCommands() {
        LinkedList<AppOption> result = new LinkedList<>();

        result.add(new AppOption("a", "Aceitação de candidatura"));
        return result;
    }
    
    protected void showAvailableCommands() {
        detectAvailableCommands().stream().forEach((option) -> {
               System.out.println(option);
        });
    }

    public String getHelloMessage() {
        return helloMessage;
    }

    public void setHelloMessage(String helloMessage) {
        this.helloMessage = helloMessage;
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    public PrintStream getOut() {
        return out;
    }

    public void setOut(PrintStream out) {
        this.out = out;
    }
    
    public class AppOption {
        private String command;
        private String summary;

        public AppOption(String command, String summary) {
            this.command = command;
            this.summary = summary;
        }

        public String getCommand() {
            return command;
        }

        public void setCommand(String command) {
            this.command = command;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        @Override
        public String toString() {
            return this.command+" - "+this.summary;
        }
    }
}
