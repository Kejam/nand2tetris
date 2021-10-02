public class ProgramFlow implements Command{
    private final String command;

    public ProgramFlow(String command) {
        this.command = command;
    }

    @Override
    public String translate() {
        final String[] strings = command.split(" ");
        if (command.startsWith("label")) return label(strings[1]);
        if (command.startsWith("if-goto")) return ifgoto(strings[1]);
        if (command.startsWith("goto")) return asmgoto(strings[1]);
        throw new IllegalArgumentException("Unknown compute command");
    }

    private String label(String label) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// label ").append(label).append("\n");
        rs.append("(").append(label).append(")").append("\n");
        return rs.toString();
    }

    private String asmgoto(String label) {
        final StringBuilder rs = new StringBuilder();
        rs.append("@").append(label).append("\n");
        rs.append("0;JMP").append("\n");
        return rs.toString();
    }

    private String ifgoto(String label) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// if-goto ").append(label).append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M-1").append("\n");
        rs.append("A=M").append("\n");
        rs.append("D=M").append("\n");
        rs.append("@").append(label).append("\n");
        rs.append("D;JNE").append("\n");
        return rs.toString();
    }
}
