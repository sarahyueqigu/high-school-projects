public class Fibonacci {
	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		System.out.println(fib2(n));
		System.out.println(fib(n));
		
	}
	public static int fib(int n) {
		if (n < 2) return n;
		return fib(n -1) + fib(n-2);
	}
	public static long fib2(int n) {
		long[] C = new long[n+1];
		C[0] = 0;
		C[1] = 1;
		for (int k = 2; k <= n; k++) {
			C[k] = C[k-1] + C[k-2];
		}
		return C[n];
	}
}