import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class HackAssembler {

    /**
     * This program far convert symbolic assembly to binary code.
     * This code is not perfect and faster
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        System.out.println("Hello! It's assembler for Hack language!");
        final Path path = Paths.get("/Users/kejam/Desktop/Projects/nand2tetris/projects/06/pong/Pong.asm");
        final List<String> lineOfCodes = Files.readAllLines(path);
        final List<String> clearWhiteSpacesAndComments = clearWhiteSpacesAndComments(lineOfCodes);
        final List<String> labelSymbols = findVariables(clearWhiteSpacesAndComments);
        final List<String> replaceVariables = replaceVariables(labelSymbols);
        System.out.println(Variables.labelSymbols);
        System.out.println(Variables.predefinedSymbols);
        System.out.println(Variables.variables);
        final List<Instruction> instructions = convertInstruction(replaceVariables);
        String name = path.getFileName().toString();
        String clearName = name.substring(0, name.lastIndexOf("."));
        String pathToFile = path.getParent().toString() + "/" + clearName + ".hack";
        final Path pathNewFile = Paths.get(pathToFile);
        Files.deleteIfExists(pathNewFile);
        final StringBuilder result = new StringBuilder();
        instructions.forEach(k -> {
            result.append(k.convertInstructionToBinaryCode()).append("\n");
        });
        Files.write(pathNewFile, result.toString().getBytes());
    }


    public static List<String> clearWhiteSpacesAndComments(List<String> lineOfCodes){
        return lineOfCodes
                .stream()
                .filter(s -> !s.startsWith("//") && !s.isEmpty())
                .map(s -> {
                    if (s.contains("//")) {
                        s = s.substring(0, s.indexOf("//"));
                    }
                    return s.replaceAll("\\s+","");
                })
                .collect(Collectors.toList());
    }

    public static List<String> findVariables(List<String> lineOfCodes) {
        final ArrayList<String> result = new ArrayList<>();
        int valueOfLoop = 0;
        for (int i = 0; i < lineOfCodes.size(); i++) {
            final String string = lineOfCodes.get(i);
            if (string.startsWith("(") && string.endsWith(")")) {
                Variables.addLabelSymbol(string.substring(1, string.length() - 1), i - valueOfLoop++);
            } else {
                result.add(string);
            }
        }
        result.forEach(string -> {
            if (string.startsWith("@")) {
                String variable = string.substring(1);
                if (!isNumeric(variable) && !Variables.predefinedSymbols.containsKey(variable)
                        && !Variables.labelSymbols.containsKey(variable)
                        && !Variables.variables.containsKey(variable)) {
                    Variables.addVariables(variable);
                }
            }
        });
        return result;
    }

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static List<String> replaceVariables(List<String> lineOfCodes) {
        return lineOfCodes
                .stream()
                .map(s -> {
                    final String variable = s.substring(1);
                    if (s.startsWith("@") &&
                            (Variables.predefinedSymbols.containsKey(variable)
                            || Variables.labelSymbols.containsKey(variable)
                            || Variables.variables.containsKey(variable))) {
                        try {
                            final String replacement = String.valueOf(Variables.findVariable(variable));
                            s = s.replace(variable, replacement);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                    return s;
                })
                .collect(Collectors.toList());
    }

    public static List<Instruction> convertInstruction(List<String> lineOfCodes) {
        return lineOfCodes
                .stream()
                .map(InstructionFactory::createInstruction)
                .collect(Collectors.toList());
    }


}