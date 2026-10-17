public class ClassWork_101026 {
	public static void main(String[] args) {
		double c  = exp(1);
		System.out.println(c);
	}

	public static double exp(double x) {

		double epsilon = 1e-6;
		double s = x;
		int n = 1;
		double e = 1 + x;
		while ((s > epsilon) || (s < -epsilon)) {
			s = s * x / (++n);
			e += s;
		}
		return e;
	}
}