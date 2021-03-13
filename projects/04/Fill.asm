// This file is part of www.nand2tetris.org
// and the book "The Elements of Computing Systems"
// by Nisan and Schocken, MIT Press.
// File name: projects/04/Fill.asm

// Runs an infinite loop that listens to the keyboard input.
// When a key is pressed (any key), the program blackens the screen,
// i.e. writes "black" in every pixel;
// the screen should remain fully black as long as the key is pressed. 
// When no key is pressed, the program clears the screen, i.e. writes
// "white" in every pixel;
// the screen should remain fully clear as long as no key is pressed.

// Put your code here.


(START)

@KBD
D=M
@WHITE_START
D;JEQ

@KBD
D=M
@BLACK_START
D;JNE


(WHITE_START)
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
M=0
@i
M=M-1
@WHITE_LOOP
0;JMP

(BLACK_START)
@KBD
D=A
@i
M=D-1
(BLACK_LOOP)
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
@BLACK_LOOP
0;JMP


