package see;

import java.util.Scanner;

import p1.Intarr;

public class P1 {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of values");
		int n = s.nextInt();
		System.out.println("Enter the values");
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i]=s.nextInt();
		}
		Intarr obj=new Intarr();
		System.out.println("Minimum value = "+obj.min(arr));
		System.out.println("Enter scalar factor");
		int val = s.nextInt();
		for(int i:arr){
			System.out.println(obj.scale(i,val)+"\t");
		}
	}
}