package guava.test_bai4;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

public class PrimeGuavaCacheUtil {
	private static LoadingCache<Integer, ArrayList<Integer>> primeCache;
	static {
		primeCache = CacheBuilder.newBuilder().maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES)
				.build(new CacheLoader<Integer, ArrayList<Integer>>() {
					@Override
					public ArrayList<Integer> load(Integer i) throws Exception {
						return getArr(i);
					}
				});
	}
	public static ArrayList<Integer> getArr(int n){
		
		return so_nguyen_to(n);
	}
	
	public static LoadingCache<Integer, ArrayList<Integer>> getLoadingCache() {
		return primeCache;
	}
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
		for (int i = 0; i <= n; i++) {
			if (snt[i] != 0)
				kq.add(i);
		}
		return kq;
	}
}
