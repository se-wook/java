package chapter03;

import java.util.Scanner;

public class Main_561 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int [] arr = new int[10];
		for(int i = 0; i<10; i++) {
			arr[i] = sc.nextInt();
		}
		int underMax = -1;
		int upMin = 10001;
		for (int i = 0; i<10; i++) {
			if(arr[i] >= 100) {
				if(upMin > arr[i])
					upMin = arr[i];
			}else {
				if(underMax < arr[i])
					underMax = arr[i];
			}
		}
		if(upMin == 10001)
			upMin = 100;
		if (underMax == -1)
			underMax = 100;
		System.out.println(underMax + " " + upMin);
	}

}
