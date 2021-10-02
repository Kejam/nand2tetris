import java.util.Random;
import java.util.UUID;

public class ComputeCommand implements Command{
    private final String uuid;
    private final String command;

    public ComputeCommand(String command) {
        this.uuid = UUID.randomUUID().toString();
        this.command = command;
    }

    @Override
    public String translate() {
        final String clearCommand = command.replace(" ", "");
        if ("add".equalsIgnoreCase(clearCommand)) return add();
        if ("eq".equalsIgnoreCase(clearCommand)) return eq();
        if ("or".equalsIgnoreCase(clearCommand)) return or();
        if ("and".equalsIgnoreCase(clearCommand)) return and();
        if ("not".equalsIgnoreCase(clearCommand)) return not();
        if ("neg".equalsIgnoreCase(clearCommand)) return neg();
        if ("sub".equalsIgnoreCase(clearCommand)) return sub();
        if ("lt".equalsIgnoreCase(clearCommand)) return lt();
        if ("gt".equalsIgnoreCase(clearCommand)) return gt();
        throw new IllegalArgumentException("Unknown compute command");
    }

    private String add() {
        final StringBuilder rs = new StringBuilder();
        rs.append("// add").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M-1").append("\n");
        rs.append("@SP").append("\n");
        rs.append("A=M").append("\n");
        rs.append("D=M").append("\n");
        rs.append("M=0").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M-1").append("\n");
        rs.append("@SP").append("\n");
        rs.append("A=M").append("\n");
        rs.append("D=D+M").append("\n");
        rs.append("M=D").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M+1").append("\n");
        return rs.toString();
    }

    private String or() {
        return "// or\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M\n" +
                "M=0\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=D|M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    private String and() {
        return "// and\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M\n" +
                "M=0\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=D&M\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    private String not() {
        return "// not\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "M=!M\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    private String neg() {
        return "// neg\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M\n" +
                "M=-D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    private String sub() {
        return "// sub\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M\n" +
                "M=0\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M-D\n" +
                "M=D\n" +
                "@SP\n" +
                "M=M+1\n";
    }

    private String eq() {
        final StringBuilder rs = new StringBuilder();
        rs.append("// eq\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M\n" +
                "M=0\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=D-M\n" +
                "@TRUE").append(uuid).append("\n" +
                "D;JEQ\n" +
                "(FALSE").append(uuid).append(")\n" +
                "@SP\n" +
                "A=M\n" +
                "M=0\n" +
                "@END").append(uuid).append("\n" +
                "0;JMP\n" +
                "(TRUE").append(uuid).append(")\n" +
                "@SP\n" +
                "A=M\n" +
                "M=-1\n" +
                "(END").append(uuid).append(")\n" +
                "@SP\n" +
                "M=M+1");
        return rs.toString();
    }

    private String lt() {
        final StringBuilder rs = new StringBuilder();
        rs.append("// lt\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M\n" +
                "M=0\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M-D\n" +
                "@TRUE").append(uuid).append("\n" +
                "D;JLT\n" +
                "(FALSE").append(uuid).append(")\n" +
                "@SP\n" +
                "A=M\n" +
                "M=0\n" +
                "@END").append(uuid).append("\n" +
                "0;JMP\n" +
                "(TRUE").append(uuid).append(")\n" +
                "@SP\n" +
                "A=M\n" +
                "M=-1\n" +
                "(END").append(uuid).append(")\n" +
                "@SP\n" +
                "M=M+1\n");
        return rs.toString();
    }

    private String gt() {
        final StringBuilder rs = new StringBuilder();
        rs.append("// gt\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=M\n" +
                "M=0\n" +
                "@SP\n" +
                "M=M-1\n" +
                "@SP\n" +
                "A=M\n" +
                "D=D-M\n" +
                "@TRUE").append(uuid).append("\n" +
                "D;JLT\n" +
                "(FALSE").append(uuid).append(")\n" +
                "@SP\n" +
                "A=M\n" +
                "M=0\n" +
                "@END").append(uuid).append("\n" +
                "0;JMP\n" +
                "(TRUE").append(uuid).append(")\n" +
                "@SP\n" +
                "A=M\n" +
                "M=-1\n" +
                "(END").append(uuid).append(")\n" +
                "@SP\n" +
                "M=M+1\n");
        return rs.toString();
    }
}
