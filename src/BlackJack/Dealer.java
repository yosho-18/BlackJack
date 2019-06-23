package BlackJack;
public class Dealer {
	public static void main(String[] args) {
		double amo = 10000000;
		double bur = 0;
		double bla = 0;
		int[] fig = new int[10];
		for(int i = 0; i < amo; i++) {
			int p = 0;
			int[] Sum = new int [1];
			int[] array = new int [13];
			int[] sparray = new int [1];
			while(Sum[0] < 17) {
				int r = new java.util.Random().nextInt(52);
				for(int j = 1; j <= 13; j++) {
					count(4*j, r, p, Sum, array, sparray);
				}
				if(Sum[0] == 21) {
					bla++;
				}
				if(Sum[0] > 21) {
					if(sparray[0] >= 1) {
						Sum[0] = Sum[0] - 10;
						sparray[0]--;
					}else{
						bur++;
					}
				}
			}
			for(int k = 17; k <= 26; k++) {
			if(Sum[0] == k) {
				fig[k - 17]++;
				}
			}
		}
		System.out.println("試行回数 " + amo + "回");
		System.out.println();
		System.out.println("バースト率 " + 100 * bur/amo + "％");
		System.out.println("ブラックジャック率 " + 100 * bla/amo + "％");
		System.out.println();
		for(int pr = 17; pr <= 26; pr++) {
			System.out.println(pr + "の確率 " + 100 * fig[pr - 17]/amo + "％");
		}
	}
	public static void count(int x, int r, int p, int[] S, int[] a, int[] spa) {
		if(r >= x - 4 && r <= x - 1 - a[r/4]) {
			if(x == 4) {
				p = 11;
				spa[0]++;
			}
			if(8 <= x && x <= 43) {
				p = x / 4;
			}
			if(x >= 44) {
				p = 10;
			}
			S[0] = S[0] + p;
			if(a[r/4] < 3) {
				a[r/4]++;
			}
		}
	}
}
