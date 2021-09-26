import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class VMTranslator {

    public static void main(String[] args) throws IOException {
        final Path path = Paths.get(args[0]);
        final String path2String = args[0].replace(".vm", ".asm");
        final Path path2 = Paths.get(path2String);
        final List<String> lines = Files.readAllLines(path);
        final List<String> clearWhiteSpacesAndComments = clearWhiteSpacesAndComments(lines);
        final List<String> commands = parseCommand(clearWhiteSpacesAndComments);
        Files.write(path2, commands);
    }



    public static List<String> parseCommand(List<String> commands) {
        return commands.stream()
                .map(
                        k -> {
                            if (k.startsWith("push") || k.startsWith("pop")) return new MemoryCommand(k).translate();
                            return new ComputeCommand(k).translate();
                        }
                )
                .collect(Collectors.toList());
    }

    public static List<String> clearWhiteSpacesAndComments(List<String> lineOfCodes){
        return lineOfCodes
                .stream()
                .filter(s -> !s.startsWith("//") && !s.isEmpty())
                .map(s -> {
                    if (s.contains("//")) {
                        s = s.substring(0, s.indexOf("//"));
                    }
                    return s;
                })
                .collect(Collectors.toList());
    }
}