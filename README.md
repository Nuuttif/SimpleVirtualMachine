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

If the header decimal is something else than 0 or 1, it means the instruction is an operation (like addition) and the next decimal tells which operation we want the computer to run.
0 = halt
1 = addition

Lets decode "21" for example.
Header "2" means it's an operation rather than just an integer we are pushing to the stack. All that's left is "1".
There's currently only 2 operations (0 = halt, 1 = addition).
As we can see "1" is addition.
So "21" means: "Add the last two integers on top of the stack together and push it on top of the stack".
