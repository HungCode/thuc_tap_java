
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonReader {
	private static final Logger logger = LoggerFactory.getLogger(JsonReader.class);

	private static String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	public static JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}

	}

	public static void main(String[] args) throws IOException, JSONException {
		Thread t = new Thread(new Runnable() {

			public void run() {
				try {
					int inforCuoi = -1;
					int dem = 0;
					while (true) {
						JSONObject json = readJsonFromUrl("http://news.admicro.vn:10002/api/realtime?domain=kenh14.vn");
						JSONArray a = json.getJSONArray("source");

						int x = a.length();
						System.out.println(x+"---------");
						dem += 2;
						if ((double) (x / inforCuoi) > 1.03 || inforCuoi == -1) {
							inforCuoi = x;
							logger.info(inforCuoi + "");
							dem = 0;
						} 
						else {
							System.out.println(inforCuoi);
							if (dem == 12) {
								logger.debug(inforCuoi + "");
								dem = 0;
							}
						}

						Thread.sleep(2000);
					}

				} catch (Exception e) {
					logger.debug("Có ngoại lệ!");
				}
			}

		});
		t.start();

	}
}
