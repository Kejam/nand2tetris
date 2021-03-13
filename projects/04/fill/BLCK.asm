// set screen to white and then to black

(START)

@KBD
D=A
@i
M=D-1

(BLACK_LOOP)
@i
D=M
@WHITE_LOOP
D;JLE
@i
D=M
@SCREEN
A=D
M=-1
@i
M=M-1
@BLACK_LOOP
0;JMP

@KBD
D=A
@i
M=D-1

(WHITE_LOOP)
@i
D=M
@START
D;JLE
@i
D=M
@SCREEN
A=D
M=-1
@i
M=M-1
@WHITE_LOOP
0;JMP

