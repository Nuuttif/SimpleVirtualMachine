# SimpleVirtualMachine
a Virtual machine I'm coding to better understand computers and learn about CPUs, registers and stacks.

Currently the only operations are:
1. Pushing values to stack
2. Addition
3. Halting and printing top of stack

Programs for the VM are coded by giving instructions in the form of integers, in Main.java:s array called "prog".
First decimal of an integer is the header, 0 and 1 meaning integer. Giving an integer just pushes it to the stack.
Lets decode the instruction "035" for example.
"0" is the header. Since it's 0 or 1, we are pushing an integer to the stack. "35" is left, which is the integer we are pushing.
So "035" means: "Push 35 to the top of stack".

If the header decimal is something other than 0 or 1, it means the instruction is an operation (like addition) and the next decimal tells which operation we want the computer to run.
0 = halt
1 = addition

Lets decode "21" for example.
Header "2" means it's an operation rather than just an integer we are pushing to the stack. All that's left is "1".
There's currently only 2 operations (0 = halt, 1 = addition).
As we can see "1" is addition.
So "21" means: "Add the last two integers on top of the stack together and push it on top of the stack".

In the Main.java:s prog array I have written a demo program for testing, let's break it down.
"02", "03", "21", "20".

"02" - 0 means it's an integer, so it means: "Push 2 to the stack".
"03" - "Push 3 to the stack".
"21" - 2 means it's an operation, 1 means it's addition: "Add the two integers on top of the stack (2 and 3)".
"20" - 2 means it's an operation, 0 means it's "halt": "Print the top of the stack and stop the VM".

Output should look like this:

Tos: 2
Tos: 3
Add 2 3

Tos: 5
Halt
