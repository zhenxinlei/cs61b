import java.util.Stack;

public class HelloWorld {

	public int f(int n) {
		Func func = new Func();
		Stack<Func> s = new Stack<Func>();
		func.n = n;
		func.stage = 0;
		func.reval = 0;
		int result;
		s.push(func);

		while (!s.isEmpty()) {
			func = s.pop();
			Func newfunc = new Func();
			switch (func.stage) {
			case 0: //update stage, call next recursive function 
				if (func.n > 0) {
					func.stage = 1;
					s.push(func);
					newfunc.n = func.n - 1;
					newfunc.stage = 0;
					newfunc.reval = 0;
					s.push(newfunc);
					continue;
				}
				func.reval = 1;
				func.stage = 1;
				s.push(func); 
				continue;
			case 1:  //call function and return result with previous function return 
				if (func.n == n) // if back to n, means all previous functions have been called. 
					break;
				newfunc = s.pop();
				newfunc.reval = func.reval * newfunc.n;
				s.push(newfunc);
				continue;
			}
		}
		return func.reval;
	}

	public static void main(String[] args) {
		System.out.println("Hello World");
		HelloWorld hw = new HelloWorld();
		System.out.println("ANS :" + hw.f(0));//1
		System.out.println("ANS :" + hw.f(1));//1
		System.out.println("ANS :" + hw.f(-2)); //1
		System.out.println("ANS :" + hw.f(3));//6
	}
}

 class Func {
	int n;
	int stage;
	int reval;
}
