package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.ZonedDateTime;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class App {
	private static String URL = "http://dantri.com.vn";

	public static void main(String[] args) throws IOException {
		
		Document doc = Jsoup.connect(URL).get();

		String time = ZonedDateTime.now().getHour() + "." + ZonedDateTime.now().getMinute() + "."
				+ ZonedDateTime.now().getSecond();
		System.out.println(ZonedDateTime.now());

		File f = new File("/home/hung/thuc_tap_java/Thuc_hanh_tool/bai2/resources/" + time + ".txt");
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
