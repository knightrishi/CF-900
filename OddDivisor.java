import java.util.Scanner;
class OddDivisor{
	public static void main(String ar[]){
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0){
			int num=ob.nextInt();
			boolean flag=false;
			for(int i=3;i<=num;i+=2){
				if(num%i==0){
					System.out.println("YES");
					flag=true;
					break;
				}
			}
			if(!flag)
				System.out.println("No");

	}
}
}