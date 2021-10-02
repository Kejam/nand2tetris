@256
D=A
@SP
M=D
@RETURN_LABEL557d23e1-3285-42c1-88ce-e89ca6e2e1bb
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.init
0;JMP
(RETURN_LABEL557d23e1-3285-42c1-88ce-e89ca6e2e1bb)

// push constant 4000
@4000
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

// push constant 5000
@5000
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

@RETURN_LABELbc22e8bd-3da4-4177-9cb9-f4a7be275418
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@0
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.main
0;JMP
(RETURN_LABELbc22e8bd-3da4-4177-9cb9-f4a7be275418)

//pop static 1
@SP
M=M-1
A=M
D=M
@6
M=D

// label LOOP
(LOOP)

@LOOP
0;JMP

(Sys.main)
@0
D=A
@SP
A=M
M=D
@SP
M=M+1
@1
D=A
@SP
A=M
M=D
@SP
M=M+1
@2
D=A
@SP
A=M
M=D
@SP
M=M+1
@3
D=A
@SP
A=M
M=D
@SP
M=M+1
@4
D=A
@SP
A=M
M=D
@SP
M=M+1

// push constant 4001
@4001
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

// push constant 5001
@5001
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

// push constant 200
@200
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop LCL 1
@1
D=A
@LCL
M=M+D
@SP
M=M-1
A=M
D=M
@LCL
A=M
M=D
@1
D=A
@LCL
M=M-D

// push constant 40
@40
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop LCL 2
@2
D=A
@LCL
M=M+D
@SP
M=M-1
A=M
D=M
@LCL
A=M
M=D
@2
D=A
@LCL
M=M-D

// push constant 6
@6
D=A
@SP
A=M
M=D
@SP
M=M+1

// pop LCL 3
@3
D=A
@LCL
M=M+D
@SP
M=M-1
A=M
D=M
@LCL
A=M
M=D
@3
D=A
@LCL
M=M-D

// push constant 123
@123
D=A
@SP
A=M
M=D
@SP
M=M+1

@RETURN_LABELc5726869-12c3-4695-82fd-2bf09a953c48
D=A
@SP
A=M
M=D
@SP
M=M+1
@LCL
D=M
@SP
A=M
M=D
@SP
M=M+1
@ARG
D=M
@SP
A=M
M=D
@SP
M=M+1
@THIS
D=M
@SP
A=M
M=D
@SP
M=M+1
@THAT
D=M
@SP
A=M
M=D
@SP
M=M+1
@SP
D=M
@5
D=D-A
@1
D=D-A
@ARG
M=D
@SP
D=M
@LCL
M=D
@Sys.add12
0;JMP
(RETURN_LABELc5726869-12c3-4695-82fd-2bf09a953c48)

//pop static 0
@SP
M=M-1
A=M
D=M
@5
M=D

// push LCL 0
@0
D=A
@LCL
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// push LCL 1
@1
D=A
@LCL
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// push LCL 2
@2
D=A
@LCL
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// push LCL 3
@3
D=A
@LCL
A=M+D
D=M
@SP
A=M
M=D
@SP
M=M+1

// push LCL 4
@4
D=A
@LCL
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

@LCL
D=M
@R11
M=D
@5
A=D-A
D=M
@R12
M=D
@ARG
D=M
@0
D=D+A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
@ARG
D=M
@SP
M=D+1
@R11
D=M-1
AM=D
D=M
@THAT
M=D
@R11
D=M-1
AM=D
D=M
@THIS
M=D
@R11
D=M-1
AM=D
D=M
@ARG
M=D
@R11
D=M-1
AM=D
D=M
@LCL
M=D
@R12
A=M
0;JMP

(Sys.add12)

// push constant 4002
@4002
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

// push constant 5002
@5002
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

// push constant 12
@12
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

@LCL
D=M
@R11
M=D
@5
A=D-A
D=M
@R12
M=D
@ARG
D=M
@0
D=D+A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
@ARG
D=M
@SP
M=D+1
@R11
D=M-1
AM=D
D=M
@THAT
M=D
@R11
D=M-1
AM=D
D=M
@THIS
M=D
@R11
D=M-1
AM=D
D=M
@ARG
M=D
@R11
D=M-1
AM=D
D=M
@LCL
M=D
@R12
A=M
0;JMP

