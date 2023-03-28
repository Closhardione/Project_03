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
            String test = this.reader.readLine();
            this.writer.write(test);
            this.writer.flush();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
