package spark.bai3;

import static spark.Spark.get;

import java.util.ArrayList;

import spark.Spark;


/**
 * Hello world!
 *
 */
public class App {

	public static int[] sang_nguyen_to(int n) {

		int[] snt = new int[n + 1];

		int i, j;
		for (i = 1; i <= n; i++)
			snt[i] = 1;
		snt[1] = 0;
		i = 2;
		double l = Math.sqrt(n);
		while (i <= l) {
			while (snt[i] == 0)
				i++;
			for (j = 2; j <= n / i; j++)
				snt[i * j] = 0;
			i++;
		}
		return snt;
	}
	
	public static ArrayList<Integer> so_nguyen_to(int n) {
		int[] snt = sang_nguyen_to(n);
		ArrayList<Integer> kq = new ArrayList<>();
		for (int i=0;i<=n;i++) {
			if(snt[i]!=0)
				kq.add(i);
		}
		return kq;
	}
	public static void main(String[] args) {
		System.out.println(so_nguyen_to(100));

		get("/prime", (req, res) -> {
			int Max = Integer.parseInt(req.queryParams("q"));
			System.out.println(Max);
			return so_nguyen_to(Max);
		});
		Spark.post("/", (request, response) -> {
		    // Create something
			return "12345";
		});

	}
}
