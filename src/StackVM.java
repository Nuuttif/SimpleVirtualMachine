public class StackVM {

	//Operations:
	//
	//0 = halt
	//1 = addition
	//2 = subtraction


	private int pc = 0;       	//Program counter
	private int sp = 0;	  	//Stack pointer
	private int typ;		//Type of an instruction (Operation or integer)
	private int dat = 0;		//The data an instruction carries (int or number of command)
	private int running = 1;	//VM running or not. Makes debugging easier.
	private String[] memory;	//Memory for the program the VM is running.
	private int[] stack;		//Stack's memory

	
	public void allocateMemory(int size) {
		this.memory = new String[size];
	}

	public void allocateStack(int size) {
		this.stack = new int[size];
	}

	public void loadProgram(String[] prog) {
		for (int i = 0; i < prog.length; i++) {
			memory[this.pc + i] = prog[i];
		}
	}

	private void decode() {
		this.typ = getType(memory[pc]);
		this.dat = getData(memory[pc]);
	}

	private int getType(String instruction) {
		String inst;
		inst = instruction.substring(0, 1);
		return Integer.parseInt(inst);
	}

	private int getData(String instruction) {
		String inst;
		inst = instruction.substring(1);
		return Integer.parseInt(inst);
	}
	
	private void fetch() {
		this.pc++;
	}

	private void execute() {
		if (typ == 0 || typ == 1) {	//If headers say it's a variable, add to stack
			this.sp++;
			stack[sp] = dat;
		} else {
			doPrimitive();		//Else choose an operation
		}
	}

	private void doPrimitive() {
		switch(this.dat) {
			case 0: // Halt
				System.out.println("Halt\n");
				this.running = 0;
				break;

			case 1: // Add
				System.out.println("Add " + this.stack[sp - 1] + " " + this.stack[sp] + "\n");
				this.stack[sp - 1] = this.stack[sp - 1] + this.stack[sp];
				this.sp--;
				break;

			case 2: // Subtract
				System.out.println("Subtract " + this.stack[sp - 1] + " " + this.stack[sp] + "\n");
				this.stack[sp - 1] = this.stack[sp - 1] - this.stack[sp];
				this.sp--;
				break;
		}
	}

	public void run() {
		this.pc--;
		while (this.running == 1) {
			fetch();
			decode();
			execute();
			System.out.println("Tos: " + stack[sp]);
		}
	}
}
