import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
       Path path = Path.of(System.getProperty(""));
//        path.toString();
//        String newPath = "";
//        path=path.resolve(newPath);
        try{
            Stream<Path> stream = Files.list(path);
            Comparator<Path> comparator = (p1, p2) -> Boolean.compare(Files.isDirectory(p1),Files.isDirectory(p2));
            stream.sorted(comparator);
            List<String> test = stream
                    .filter((p) -> !p.getFileName().toString().contains("a"))
                    .sorted(comparator)
                    .map((p) -> p.getFileName().toString())
                    .collect(Collectors.toList());
        }catch(IOException e){

            e.printStackTrace();
        }
    }
}