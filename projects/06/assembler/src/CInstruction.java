public class CInstruction implements Instruction{
    private final String binaryCode;

    public CInstruction(String binaryCode) {
        this.binaryCode = binaryCode;
    }

    @Override
    public String convertInstructionToBinaryCode() {
        return binaryCode;
    }
}
