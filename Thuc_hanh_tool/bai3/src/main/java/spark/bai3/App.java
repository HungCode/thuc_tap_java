package spark.bai3;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {

		get("/iplocation/:ip", (req, res) -> {
			String ip = req.params(":ip");
			res.redirect("http://ip-api.com/json/" + ip);
			return "";
		});


	}
}
