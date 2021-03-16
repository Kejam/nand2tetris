import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Variables {
    public static Map<String, Integer> labelSymbols = new HashMap<>();
    public static Map<String, Integer> predefinedSymbols = new HashMap<>();
    public static Map<String, Integer> variables = new HashMap<>();
    public static Map<String, String> jumps = new HashMap<>();
    public static Map<String, String> destinations = new HashMap<>();
    public static Map<String, String> computation = new HashMap<>();
    public static int valueOfFreeIndex;

    static {
        predefinedSymbols.put("SP", 0);
        predefinedSymbols.put("LCL", 1);
        predefinedSymbols.put("ARG", 2);
        predefinedSymbols.put("THIS", 3);
        predefinedSymbols.put("THAT", 4);
        predefinedSymbols.put("R0", 0);
        predefinedSymbols.put("R1", 1);
        predefinedSymbols.put("R2", 2);
        predefinedSymbols.put("R3", 3);
        predefinedSymbols.put("R4", 4);
        predefinedSymbols.put("R5", 5);
        predefinedSymbols.put("R6", 6);
        predefinedSymbols.put("R7", 7);
        predefinedSymbols.put("R8", 8);
        predefinedSymbols.put("R9", 9);
        predefinedSymbols.put("R10", 10);
        predefinedSymbols.put("R11", 11);
        predefinedSymbols.put("R12", 12);
        predefinedSymbols.put("R13", 13);
        predefinedSymbols.put("R14", 14);
        predefinedSymbols.put("R15", 15);
        predefinedSymbols.put("SCREEN", 16384);
        predefinedSymbols.put("KBD", 24576);
        valueOfFreeIndex = 16;
        jumps.put("null", "000");
        jumps.put("JGT", "001");
        jumps.put("JEQ", "010");
        jumps.put("JGE", "011");
        jumps.put("JLT", "100");
        jumps.put("JNE", "101");
        jumps.put("JLE", "110");
        jumps.put("JMP", "111");
        destinations.put("null", "000");
        destinations.put("M", "001");
        destinations.put("D", "010");
        destinations.put("MD", "011");
        destinations.put("A", "100");
        destinations.put("AM", "101");
        destinations.put("AD", "110");
        destinations.put("AMD", "111");
        computation.put("0",    "0101010");
        computation.put("1",    "0111111");
        computation.put("-1",   "0111010");
        computation.put("D",    "0001100");
        computation.put("A",    "0110000");
        computation.put("!D",   "0001101");
        computation.put("!A",   "0110011");
        computation.put("-D",   "0001111");
        computation.put("-A",   "0110111");
        computation.put("D+1",  "0011111");
        computation.put("A+1",  "0110111");
        computation.put("D-1",  "0001110");
        computation.put("A-1",  "0110010");
        computation.put("D+A",  "0000010");
        computation.put("D-A",  "0010011");
        computation.put("A-D",  "0000111");
        computation.put("D&A",  "0000000");
        computation.put("D|A",  "0010101");
        computation.put("M",    "1110000");
        computation.put("!M",   "1110001");
        computation.put("-M",   "1110011");
        computation.put("M+1",  "1110111");
        computation.put("M-1",  "1110010");
        computation.put("D+M",  "1000010");
        computation.put("D-M",  "1010011");
        computation.put("M-D",  "1000111");
        computation.put("D&M",  "1000000");
        computation.put("D|M",  "1010101");
    }

    public static void addVariables(String key) {
        variables.put(key, valueOfFreeIndex++);
    }

    public static void addLabelSymbol(String key, Integer value) {
        labelSymbols.put(key, value);
    }

    public static Integer findVariable(String key) throws IllegalAccessException {
        if (predefinedSymbols.containsKey(key)) {
            return predefinedSymbols.get(key);
        }
        if (variables.containsKey(key)) {
            return variables.get(key);
        }
        if (labelSymbols.containsKey(key)) {
            return labelSymbols.get(key);
        }
        throw new IllegalAccessException("Nor found key " + key);
    }
}
