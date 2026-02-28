package ru.itis.inf501.lab2_5;

public class Bubble{
	public static void main (String args[]){
		int[] matrix = {171,-100,-33,45,1,7};
		int[] sortmatrix = sort(matrix);
		for ( int x : matrix ){
			System.out.print(x + " ");
		}
	}
	
	static int[] sort(int[] a){
		int k = a.length - 1;
		while (k > 0){
			for (int i = 0; i < a.length - 1; i++){
				if (compare(a[i],a[i+1]) > 0 ){
					swap(i,i+1,a);
				}
			}
			k--;

		}
		return a;
	}

	static int compare(int a, int b){
		return a - b;
	} 

	static void swap (int i, int j, int[] a){
		int x = a[i];
		a[i] = a[j];
		a[j] = x;
	}
}

