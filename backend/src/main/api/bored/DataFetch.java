package main.api.bored;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import main.models.Activity;

public class DataFetch {
	private static final String BORED_URL = "http://www.boredapi.com/api";
	private static final String BORED_REQUEST = "/activity";
	private static final String FULL_BORED_URL = BORED_URL + BORED_REQUEST;
	
	public static Activity fetchData() {
		Activity data = null;
		try {
			URL url = new URL(FULL_BORED_URL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String line;
			
			// TODO: replace code with data mapper.
			while((line = reader.readLine()) != null) {
				String outOfJson = line.replaceAll("[\"{}]", "");
//				System.out.println(line);
				String[] keyValue = outOfJson.split("[:,]");
				
				if(keyValue.length == 12) {
					data = new Activity(
							keyValue[1],
							Double.parseDouble(keyValue[3]),
							keyValue[5],
							Integer.parseInt(keyValue[7]),
							Double.parseDouble(keyValue[9]),
							"",
							Integer.parseInt(keyValue[11].trim())
							);
				} else {
				
				data = new Activity(
						keyValue[1],
						Double.parseDouble(keyValue[3]),
						keyValue[5],
						Integer.parseInt(keyValue[7]),
						Double.parseDouble(keyValue[9]),
						keyValue[11] + ":" + keyValue[12],
						Integer.parseInt(keyValue[14])
						);
				}
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
}
