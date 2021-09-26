// push constant 111
@111
D=A
@SP
A=M
M=D
@SP
M=M+1

// push constant 333
@333
D=A
@SP
A=M
M=D
@SP
M=M+1

// push constant 888
@888
D=A
@SP
A=M
M=D
@SP
M=M+1

//pop static 8
@SP
M=M-1
A=M
D=M
@22
M=D

//pop static 3
@SP
M=M-1
A=M
D=M
@17
M=D

//pop static 1
@SP
M=M-1
A=M
D=M
@15
M=D

// push static 3
@17
D=M
@SP
A=M
M=D
@SP
M=M+1

// push static 1
@15
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

// push static 8
@22
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

