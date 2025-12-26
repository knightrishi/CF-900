import java.util.Scanner;
class DinnerTime{
	public static void main(String ar[]){
		int t;
		Scanner ob=new Scanner(System.in);
		t=ob.nextInt();
		while(t-->0){
			int n , m ,p ,q;
			n=ob.nextInt();
			m=ob.nextInt();
			p=ob.nextInt();
			q=ob.nextInt();
			if(n%p==0 && (n/p)*q!=m)
				System.out.println("NO");
			else
					System.out.println("YES");
		}

	}

}