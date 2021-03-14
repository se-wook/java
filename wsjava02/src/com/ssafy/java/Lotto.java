package com.ssafy.java;

public class Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int lotto[] = new int[46];
		int cnt = 0;
		while(true){
			int rand = (int)(Math.random()*45)+1;
			System.out.println(rand);
			if(lotto[rand] == 0){
				lotto[rand] = 1;
				cnt++;
			}
			if(cnt == 6){
				for (int i=0;i<46;i++) {
					if (lotto[i]!=0){
						System.out.print(i + " ");
					}
				}
				break;
			}
		}
	}

}
