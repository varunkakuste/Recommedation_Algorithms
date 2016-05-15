package com.sjsu.edu.recommendations;

public class CSVWriter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// get the host for performing the mongo dump
		String userHome = System.getProperty("user.home");
		System.out.println(userHome);
		String mongohome = "\\Program Files\\MongoDB\\Server\\3.2";
		// String host = GlimmerServer.config.getString("mongo.dumphost");
		// String port = GlimmerServer.config.getString("mongo.dumpport");
		String db = "local";
		String collection = "ratings1";
		// / String query = "'{date : new Date(1320451200000)}'"; //needs to be
		// a proper query for mongo
		// String outputlocation = "/tmp/output.txt"; //needs to be asigned a
		// random number name

		String command = String.format("mongoexport.exe " + "--db %s "
				+ "--collection %s " + "--fields user_id,item_id,preference"
				+ " " + "--type = csv" + " "
				+ "--out C:\\Users\\Bharat\\Downloads\\ratings.csv", db,
				collection);

		// .\mongoexport.exe --db mydb --collection
		// slideproof_user_event_date_count --csv --out
		// events.csv --fields '_id,first_day'

		System.out.println(command);
		try {
			Runtime rt = Runtime.getRuntime();

			Process pr1 = rt
					.exec("cd C:\\Program Files\\MongoDB\\server\\3.2\\bin\\");
			int eVal = pr1.waitFor();

			Process pr = rt.exec(command);
			System.out.println(pr.getErrorStream().toString());
			// StreamGobbler errorGobbler = new
			// StreamGobbler(pr.getErrorStream(),"ERROR");
			// StreamGobbler outputGobbler = new
			// StreamGobbler(pr.getInputStream(),"OUTPUT");
			// errorGobbler.start();
			// outputGobbler.start();
			int exitVal = pr.waitFor();
			System.out.println();
			// logger.info(String.format("Process executed with exit code %d",exitVal));

		} catch (Exception e) {
			System.out.println("Error running task. Exception %s"
					+ e.toString());
		}

	}

}
