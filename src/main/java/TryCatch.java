

public class TryCatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] a = { 1, 4, 10, 2, 5 };
		int[] b = { 1, 2, 3, 4, 5 };

		for (int i = 0; i < a.length; i++) {
			try {
				System.out.println(b[a[i]]);
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Array");
			} catch (Exception e) {
				System.out.println("Exception");
			}
		}
	}

}
