package pratice;

public class max_num {

	public static void main(String[] args) {

//		int[] num = { 1, 2, 3, 4, 5, 6 };
//		int temp = 0;
//		for (int i = 0; i < num.length; i++) {
//			if (num[i] > num[i] + 1) {
//				temp = num[i];
//				num[i] = num[i] + 1;
//				num[i + 1] = temp;
//			}
//		}
//		System.out.println(num.length - 3);
	
		int num[] = {1,5,3,8,9,3,5};
		int temp = 0;
		int size = num.length;
		for (int i = 0; i < size; i++) {
			for (int j = i+1; j < size; j++) {
			if (num[i]>=num[j]) {
				temp = num[i];
				num[i]= num[j];
				num[j]= temp;
			}
			}
		}
System.out.println(num[size-3]);		
		
	}
}
