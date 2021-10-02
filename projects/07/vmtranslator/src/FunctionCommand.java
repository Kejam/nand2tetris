import java.util.UUID;

public class FunctionCommand implements Command{
    private final String command;
    private final String uid;

    public FunctionCommand(String command) {
        this.command = command;
        this.uid = UUID.randomUUID().toString();
    }

    @Override
    public String translate() {
        final String[] strings = command.split(" ");
        if (command.startsWith("return")) return writeReturn();
        final String name = strings[1];
        final int nargs = Integer.parseInt(strings[2]);
        if (command.startsWith("function") && name.equalsIgnoreCase("Sys.init")) return sysInit();
        if (command.startsWith("function")) return writeFunction(name, nargs);
        if (command.startsWith("call")) return writeCall(name, nargs);
        throw new IllegalArgumentException("Unknown compute command");
    }
    public String sysInit() {
        StringBuilder rs = new StringBuilder();
        //SP=256
        rs.append("@256\nD=A\n@SP\nM=D\n");

        //call Sys.init
        rs.append(writeCall("Sys.init", 0)).append("\n");

        return rs.toString();
    }

    public String writeCall(String functionName, Integer numArgs) {
        String retAddress = ".ret"+uid;
        StringBuilder rs = new StringBuilder();
        String basicPushCommand = "@SP\nAM=M+1\nA=A-1\nM=D\n";

        //save caller state

        //push return address
        rs.append("@");
        rs.append(functionName+retAddress);
        rs.append("\nD=A\n");
        rs.append(basicPushCommand);
        //push other values
        rs.append("@LCL\nD=M\n");
        rs.append(basicPushCommand);
        rs.append("@ARG\nD=M\n");
        rs.append(basicPushCommand);
        rs.append("@THIS\nD=M\n");
        rs.append(basicPushCommand);
        rs.append("@THAT\nD=M\n");
        rs.append(basicPushCommand);

        //reposition ags pointer
        rs.append("@5\nD=A\n@");
        rs.append(numArgs);
        rs.append("\nD=D+A\n@SP\nD=M-D\n@ARG\nM=D\n");

        //reposition local pointer
        rs.append("@SP\nD=M\n@LCL\nM=D\n");

        //goto function
        rs.append("@");
        rs.append(functionName);
        rs.append("\n0;JMP\n");

        //declare return address
        rs.append("(");
        rs.append(functionName+retAddress);
        rs.append(")\n");


        return rs.toString();
    }

    public String writeReturn() {
        StringBuilder rs = new StringBuilder();

        //FRAME = LCL
        rs.append("@LCL\nD=M\n@R15\nM=D\n");

        //RET = *(FRAME-5)
        rs.append("@5\nD=A\n@R15\nA=M-D\nD=M\nM=0\n@R14\nM=D\n");

        //ARG=pop() pops last pushed value onto arg 0
        rs.append("@SP\nA=M-1\nD=M\n@ARG\nA=M\nM=D\n");
        rs.append("D=A+1\n@SP\nM=D\n");

        //restore saved state and clear stack
        rs.append("@R15\nA=M-1\nD=M\nM=0\n@THAT\nM=D\n");
        rs.append("@2\nD=A\n@R15\nA=M-D\nD=M\nM=0\n@THIS\nM=D\n");
        rs.append("@3\nD=A\n@R15\nA=M-D\nD=M\nM=0\n@ARG\nM=D\n");
        rs.append("@4\nD=A\n@R15\nA=M-D\nD=M\nM=0\n@LCL\nM=D\n");

        //goto return address
        rs.append("@R14\nA=M\n0;JMP\n");

        return rs.toString();

    }

    public String writeFunction(String functionName, Integer numLocals) {
        StringBuilder rs = new StringBuilder();
        rs.append("(");
        rs.append(functionName);
        rs.append(")\n");
        for(int i = 0; i < numLocals; i++){
            rs.append("@");
            rs.append(0);
            rs.append("\nD=A\n");
        }
        return rs.toString();
    }
}
