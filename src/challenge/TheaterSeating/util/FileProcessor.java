package challenge.TheaterSeating.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class FileProcessor {
	String filename;
	int numberOfLines;

	public FileProcessor(String input) {
		filename = input;
		numberOfLines = 0;

	}

	public String readFile(String inputFilename) {
		String content = null;
		try {
			File file = new File(inputFilename);
			FileReader fileReader = new FileReader(file);
			@SuppressWarnings("resource")
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = bufferedReader.readLine();

			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = bufferedReader.readLine();
				numberOfLines++;
			}
			content = sb.toString();
		} catch (FileNotFoundException ex) {
			System.err.println("Input file not Found.");
			ex.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return content;
	}

	public void writeToFile(LinkedHashMap<String, ArrayList<String>> hm) {
		BufferedWriter wr = null;
		try {
			wr = new BufferedWriter(new FileWriter("output.txt"));
			Iterator<Entry<String, ArrayList<String>>> itr = hm.entrySet()
					.iterator();
			while (itr.hasNext()) {
				Entry<String, ArrayList<String>> pairs = itr.next();
				String str = pairs.getKey() + " " + pairs.getValue();
				System.out.print(str + "\n");
				wr.write(str + "\n");
			}
			wr.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println(hm);
	}
}
