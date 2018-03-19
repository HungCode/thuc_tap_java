package guava.test_bai4;

import static spark.Spark.get;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import com.google.common.cache.LoadingCache;

public class PrimeDemo {
	public static void main(String[] args) {
		PrimeDemo prime = new PrimeDemo();
		//			System.out.println(prime.getPrimeUseGuava(5));
		get("/prime", (req, res) -> {
			int Max = Integer.parseInt(req.queryParams("q"));
//				System.out.println(Max);
			return prime.getPrimeUseGuava(Max);
		});
	}

	private ArrayList<Integer> getPrimeUseGuava(int i) throws ExecutionException {
		LoadingCache<Integer, ArrayList<Integer>> primecache = PrimeGuavaCacheUtil.getLoadingCache();
		System.out.println("size cache: "+primecache.size());
		return primecache.get(i);
	}
}
