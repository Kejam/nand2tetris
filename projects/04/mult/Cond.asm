// if r0 > 0 = r1=r0
// if r0 < 0 = r3=r0

@R0
D=M
@i
M=D


@BIGGER
D;JGT
@SMALLER
D;JLT

(BIGGER)
@i
D=M
@R1
M=D
@END
0;JGE
(SMALLER)
@i
D=M
@R3
M=D

(END)
@END
0;JGE