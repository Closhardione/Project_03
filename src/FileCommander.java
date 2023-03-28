import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileCommander {
    public Path path;
    public FileCommander(Path path){
        this.path=Path.of(System.getProperty("user.home"));
    }
    public String pwd(){
        return path.toString();
    }
    public void cd(String path){
        this.path=this.path.resolve(path);
    }
    public List<String> ls() throws IOException {
        Stream<Path> stream = Files.list(this.path);
        return stream.sorted((p1,p2) -> p1.compareTo(p2))
                .sorted((p1,p2) -> Boolean.compare(Files.isDirectory(p2),Files.isDirectory(p1)))
                .map((p) -> {
                       if(Files.isDirectory(p)){
                           return "["+p.getFileName().toString()+"]";
                       }
                       else{
                           return p.getFileName().toString();
                       }
                }).collect(Collectors.toList());//u mnie toList()
    }
    public List<String> find(String pattern) throws IOException{
        Stream<Path> stream = Files.walk(this.path);
        return stream.filter((p)-> p.toString().contains(pattern))
                .map((p) -> p.getFileName().toString())
                .collect(Collectors.toList());}
}
