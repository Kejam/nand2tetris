// push constant 3030
@3030
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop pointer THIS
@SP
M=M-1
A=M
D=M
@THIS
M=D

// push constant 3040
@3040
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop pointer THAT
@SP
M=M-1
A=M
D=M
@THAT
M=D

// push constant 32
@32
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop THIS 2
@2
D=A
@THIS
M=M+D
@SP
M=M-1
A=M
D=M
@THIS
A=M
M=D
@2
D=A
@THIS
M=M-D

// push constant 46
@46
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop THAT 6
@6
D=A
@THAT
M=M+D
@SP
M=M-1
A=M
D=M
@THAT
A=M
M=D
@6
D=A
@THAT
M=M-D

// push pointer THIS
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1

// push pointer THAT
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1

// add
@SP
M=M-1
@SP
A=M
D=M
M=0
@SP
M=M-1
@SP
A=M
D=D+M
M=D
@SP
M=M+1

// push THIS 2
@2
D=A
@THIS
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// sub
@SP
M=M-1
@SP
A=M
D=M
M=0
@SP
M=M-1
@SP
A=M
D=M-D
M=D
@SP
M=M+1

// push THAT 6
@6
D=A
@THAT
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// add
@SP
M=M-1
@SP
A=M
D=M
M=0
@SP
M=M-1
@SP
A=M
D=D+M
M=D
@SP
M=M+1

