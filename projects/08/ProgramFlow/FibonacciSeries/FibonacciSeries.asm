// push ARG 1
@1
D=A
@ARG
A=M+D
D=M
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

// push constant 0
@0
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop THAT 0
@0
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
@0
D=A
@THAT
M=M-D

// push constant 1
@1
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop THAT 1
@1
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
@1
D=A
@THAT
M=M-D

// push ARG 0
@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// push constant 2
@2
D=A
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

// pop ARG 0
@0
D=A
@ARG
M=M+D
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
@0
D=A
@ARG
M=M-D

// label MAIN_LOOP_START
(MAIN_LOOP_START)

// push ARG 0
@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// if-goto COMPUTE_ELEMENT
@SP
M=M-1
A=M
D=M
@COMPUTE_ELEMENT
D;JNE

@END_PROGRAM
0;JMP

// label COMPUTE_ELEMENT
(COMPUTE_ELEMENT)

// push THAT 0
@0
D=A
@THAT
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// push THAT 1
@1
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

// pop THAT 2
@2
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
@2
D=A
@THAT
M=M-D

// push pointer THAT
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1

// push constant 1
@1
D=A
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

// pop pointer THAT
@SP
M=M-1
A=M
D=M
@THAT
M=D

// push ARG 0
@0
D=A
@ARG
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// push constant 1
@1
D=A
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

// pop ARG 0
@0
D=A
@ARG
M=M+D
@SP
M=M-1
A=M
D=M
@ARG
A=M
M=D
@0
D=A
@ARG
M=M-D

@MAIN_LOOP_START
0;JMP

// label END_PROGRAM
(END_PROGRAM)

