package thuc_tap.test_bai2;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * Hello world!
 *
 */
public class App {
	private static String URL = "http://dantri.com.vn";

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect(URL).get();

		String time = ZonedDateTime.now().getHour() + "." + ZonedDateTime.now().getMinute() + "."
				+ ZonedDateTime.now().getSecond();
		System.out.println(time);
		System.out.println(ZonedDateTime.now());

		File f = new File("E:\\Study\\thuc_tap_java\\Thuc_hanh_tool\\test-bai2\\resources\\output\\" + time + ".txt");
		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(f, true));
			writer.write(doc.toString());
			writer.newLine();
			writer.close();
		} catch (IOException e) {
		}
	}
}
