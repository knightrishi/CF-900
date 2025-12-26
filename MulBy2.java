import java.util.Scanner;
class MulBy2{
	public static void main(String ar[]){
		int t;
		Scanner ob=new Scanner(System.in);
		t=ob.nextInt();
		while(t-->0){
			int nu;
			int ans=0;
			nu=ob.nextInt();
			int cnt1=0;
			int cnt2=0;
			while(nu%2==0){
				nu/=2;
				cnt1++;
			}
			while(nu%3==0){
				nu/=3;
				cnt2++;
			}
			if(nu != 1 ||cnt1>cnt2) System.out.println(-1);
			else{
				int moves=(cnt2-cnt1)+cnt2;
				System.out.println(moves);
			}
		}
	}
}