public class AInstruction implements Instruction{
    private final String binaryCode;

    public AInstruction(String binaryCode) {
        this.binaryCode = binaryCode;
    }
    @Override
    public String convertInstructionToBinaryCode() {
        return binaryCode;
    }
}
