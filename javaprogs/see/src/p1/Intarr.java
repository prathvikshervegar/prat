package p1;

public class Intarr {
	public int min(int[] arr){
		int temp = arr[0];
		for(int i=1;i<arr.length;i++) {
			if(arr[i]<temp)
				temp = arr[i];
		}
		return temp;
	}
	public int scale(int a,int n){
		return a*n;
	}
}
