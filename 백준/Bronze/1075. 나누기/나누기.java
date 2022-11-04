import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		if(a>=100) {
			while(true) {
				if(a%100==0) {
					break;
				}
				a=a-1;
			}
			while(true) {
				if(a%b==0) {
					break;
				}
				a=a+1;
			}
		}
		if(a%100<10) {
			System.out.print("0");
			System.out.println(a%100);
		}else {
		System.out.println(a%100);
		}
		sc.close();
	}
}