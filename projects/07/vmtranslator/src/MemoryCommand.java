public class MemoryCommand implements Command{
    private final String command;

    public MemoryCommand(String command) {
        this.command = command;
    }

    @Override
    public String translate() {
        final String[] strings = command.split(" ");
        final int value = Integer.parseInt(strings[2]);
        if (command.startsWith("push constant")) return pushConstant(value);
        if (command.startsWith("push static")) return pushStatic(value);
        if (command.startsWith("pop static")) return popStatic(value);
        if (command.startsWith("pop local")) return popMemory("LCL", value);
        if (command.startsWith("pop argument")) return popMemory("ARG", value);
        if (command.startsWith("pop that")) return popMemory("THAT", value);
        if (command.startsWith("pop this")) return popMemory("THIS", value);
        if (command.startsWith("push local")) return pushMemory("LCL", value);
        if (command.startsWith("push argument")) return pushMemory("ARG", value);
        if (command.startsWith("push that")) return pushMemory("THAT", value);
        if (command.startsWith("push this")) return pushMemory("THIS", value);
        if (command.startsWith("push temp")) return pushTemp(value);
        if (command.startsWith("pop temp")) return popTemp(value);
        if (command.startsWith("push pointer 0")) return pushPointer("THIS");
        if (command.startsWith("push pointer 1")) return pushPointer("THAT");
        if (command.startsWith("pop pointer 0")) return popPointer("THIS");
        if (command.startsWith("pop pointer 1")) return popPointer("THAT");
        throw new IllegalStateException("Unknown compute command");
    }

    public String popPointer(String name) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// pop pointer ").append(name).append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M-1").append("\n");
        rs.append("A=M").append("\n");
        rs.append("D=M").append("\n");
        rs.append("@").append(name).append("\n");
        rs.append("M=D").append("\n");
        return rs.toString();
    }

    public String pushPointer(String name) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// push pointer ").append(name).append("\n");
        rs.append("@").append(name).append("\n");
        rs.append("D=M").append("\n");
        rs.append("@SP").append("\n");
        rs.append("A=M").append("\n");
        rs.append("M=D").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M+1").append("\n");
        return rs.toString();
    }

    public String pushConstant(int value) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// push constant ").append(value).append("\n");
        rs.append("@").append(value).append("\n");
        rs.append("D=A").append("\n");
        rs.append("@SP").append("\n");
        rs.append("A=M").append("\n");
        rs.append("M=D").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M+1").append("\n");
        return rs.toString();
    }

    public String pushStatic(int value) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// push static ").append(value).append("\n");
        rs.append("@").append(14+value).append("\n");
        rs.append("D=M").append("\n");
        rs.append("@SP").append("\n");
        rs.append("A=M").append("\n");
        rs.append("M=D").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M+1").append("\n");
        return rs.toString();
    }

    public String popStatic(int value) {
        final StringBuilder rs = new StringBuilder();
        rs.append("//pop static ").append(value).append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M-1").append("\n");
        rs.append("A=M").append("\n");
        rs.append("D=M").append("\n");
        rs.append("@").append(14+value).append("\n");
        rs.append("M=D").append("\n");
        return rs.toString();
    }

    public String pushTemp(int value) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// push static ").append(value).append("\n");
        rs.append("@").append(5+value).append("\n");
        rs.append("D=M").append("\n");
        rs.append("@SP").append("\n");
        rs.append("A=M").append("\n");
        rs.append("M=D").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M+1").append("\n");
        return rs.toString();
    }

    public String popTemp(int value) {
        final StringBuilder rs = new StringBuilder();
        rs.append("//pop static ").append(value).append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M-1").append("\n");
        rs.append("A=M").append("\n");
        rs.append("D=M").append("\n");
        rs.append("@").append(5+value).append("\n");
        rs.append("M=D").append("\n");
        return rs.toString();
    }

    public String pushMemory(String name, int value) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// ").append("push ").append(name).append(" ").append(value).append("\n");
        rs.append("@").append(value).append("\n");
        rs.append("D=A").append("\n");
        rs.append("@").append(name).append("\n");
        rs.append("A=M+D").append("\n");
        rs.append("D=M").append("\n");
        rs.append("@SP").append("\n");
        rs.append("A=M").append("\n");
        rs.append("M=D").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M+1").append("\n");
        return rs.toString();
    }

    public String popMemory(String name, int value) {
        final StringBuilder rs = new StringBuilder();
        rs.append("// ").append("pop ").append(name).append(" ").append(value).append("\n");
        rs.append("@").append(value).append("\n");
        rs.append("D=A").append("\n");
        rs.append("@").append(name).append("\n");
        rs.append("M=M+D").append("\n");
        rs.append("@SP").append("\n");
        rs.append("M=M-1").append("\n");
        rs.append("A=M").append("\n");
        rs.append("D=M").append("\n");
        rs.append("@").append(name).append("\n");
        rs.append("A=M").append("\n");
        rs.append("M=D").append("\n");
        rs.append("@").append(value).append("\n");
        rs.append("D=A").append("\n");
        rs.append("@").append(name).append("\n");
        rs.append("M=M-D").append("\n");
        return rs.toString();
    }
}
