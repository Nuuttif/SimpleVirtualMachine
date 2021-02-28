public class Main {

	public static void main(String [] args) {

		StackVM vm = new StackVM();
		vm.allocateStack(100);
		
		String[] prog = {"02", "03", "21", "20"};

		vm.allocateMemory(prog.length);
		vm.loadProgram(prog);

		vm.run();
	}
}
