import java.util.Scanner; 
class Team{
	public static void main(String ar[]){
		int n;
		int ans=0;
		Scanner obj=new Scanner(System.in);
		n=obj.nextInt();

		while(n-->0){
			int v,p,t;
			v=obj.nextInt();
			t=obj.nextInt();
			p=obj.nextInt();

			int sum=p+t+v;

			if(sum>=2){
				ans++;
			}
		}
		System.out.println(ans);

	}
}