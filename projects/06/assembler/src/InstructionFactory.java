public class InstructionFactory {
    public static Instruction createInstruction(String instruction) {
        if (instruction.startsWith("@")) {
            final StringBuilder result = new StringBuilder();
            result.append(0);
            final String stringAddress = instruction.substring(1);
            //System.out.println(stringAddress);
            final String binaryString = Integer.toBinaryString(Integer.parseInt(stringAddress));
            int zeroesRemaining = 16 - binaryString.length() - 1;
            result.append("0".repeat(Math.max(0, zeroesRemaining)));
            result.append(binaryString);
            return new AInstruction(result.toString());
        } else {
            final StringBuilder result = new StringBuilder();
            String start = "111";
            String comp;
            String dest;
            String jump;
            // Compute jump
            if (instruction.contains(";")) {
                final String jumpCommand = instruction.substring(instruction.indexOf(";") + 1);
                jump = Variables.jumps.get(jumpCommand);
            } else {
                jump = "000";
            }
            // Compute dst
            if (!instruction.contains("=")) {
                dest = "000";
            } else {
                final String stringDestination = instruction.substring(0, instruction.indexOf("="));
                dest = Variables.destinations.get(stringDestination);
            }
            //Compute comp
            if (!instruction.contains("=")) {
                final String stringComp = instruction.substring(0, instruction.indexOf(";"));
                comp = Variables.computation.get(stringComp);
            } else {
                final String stringComp = instruction.substring(instruction.indexOf("=") + 1);
                comp = Variables.computation.get(stringComp);
            }
            // Append result
            result.append(start);
            result.append(comp);
            result.append(dest);
            result.append(jump);
            return new CInstruction(result.toString());
        }
    }
}
