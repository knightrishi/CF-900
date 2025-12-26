import java.util.Scanner;
class ThreeIndices{
	public static void main(String ar[]){
		Scanner ob=new Scanner(System.in);
		int t=ob.nextInt();
		while(t-->0){
			int len=ob.nextInt();
			int arr[]=new int[len];
			for(int i=0;i<len;i++){
				arr[i]=ob.nextInt();
			}
			boolean flag=false;
			for(int i=1;i<len-1;i++){
				if(arr[i]>arr[i-1] && arr[i]>arr[i+1]){
					
					System.out.println("YES");
					System.out.println((i) + " " + (i + 1) + " " + (i + 2));
                    found = true;
					break;
				}
			}
			if(flag==false)
				System.out.println("NO");
		}
	}
}