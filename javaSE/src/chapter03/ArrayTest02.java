package chapter03;

public class ArrayTest02 {
	public static void main(String[] args) {
		String[] names = { "°­¼Ò¿¬","±Ç¼ø±¹","±è°æ±Ô","±èµ¿ÈÆ","±è¹Î°æ"};
		int[] java= {95,90,98,96,95};
		int[] db= {95,100,90,93,90};
		int[] front= {90,9,100,97,100};
		int[] total = new int[names.length];
		double[] avg = new double[names.length];
		double num =3;
		System.out.println("===============================================");
		System.out.println("ÀÌ¸§\tÀÚ¹Ù\tµðºñ\tFront\tÃÑÁ¡\tÆò±Õ");
		System.out.println("===============================================");
		for (int i = 0, size = names.length; i < size; i++) {
			total[i] = java[i]+db[i]+front[i];
			avg[i] = total[i]/num;
			System.out.printf("%s\t%d\t%d\t%d\t%d\t%.1f\n"
							,names[i], java[i] ,db[i] ,front[i] ,total[i] ,avg[i]);
		}
		
	}
}






