public class StackVM {

	private int pc = 0;
	private int sp = 0;
	private int typ;
	private int dat = 0;
	private int running = 1;
	private String[] memory;
	private int[] stack;

	
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
		if (typ == 0 || typ == 1) {
			this.sp++;
			stack[sp] = dat;
		} else {
			doPrimitive();
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
