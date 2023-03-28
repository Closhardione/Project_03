import java.io.*;

public class FileCommanderCLI {
    private BufferedReader reader;
    private BufferedWriter writer;
    private FileCommander fileCommander;
    public FileCommanderCLI(InputStream reader, OutputStream writer){
        this.reader = new BufferedReader(new InputStreamReader(reader));
        this.writer = new BufferedWriter(new OutputStreamWriter(writer));
        this.fileCommander=new FileCommander();

        try{
            String command = this.reader.readLine();
            runCommand(command);
            this.writer.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void runCommand(String command) {
        String[] arguments = command.split(" ");
        try {
            switch (command) {
                case "pwd" -> writer.write(fileCommander.pwd());
                case "cd" -> fileCommander.cd(arguments[1]);
                default -> writer.write("Nieznane polecenie");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
