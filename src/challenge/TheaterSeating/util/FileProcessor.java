package challenge.TheaterSeating.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class FileProcessor {
	String filename;
	int numberOfLines;
	
	public FileProcessor(String input){
		filename = input;
		numberOfLines = 0;
		
	}
	
	public String readFile(String inputFilename){
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
	
	public void writeFile(String out) throws Exception {
		FileWriter writer = null;
		try {
			File file = new File(filename);
			file.createNewFile();
			writer = new FileWriter(file.getAbsoluteFile(), true);
			writer.write("\n");
			writer.write(out);
			writer.close();

		} catch (IOException io) {
			io.printStackTrace();
			System.err.println("I/O Exception: " + io);
			System.exit(1);
		} catch (NullPointerException nullpointerException) {
			System.err.println("Input file may be empty: "
					+ nullpointerException);
			System.exit(1);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("Index Out of bound \n");
			e.printStackTrace();
		} finally {
			writer.close();
		}
	}
}
