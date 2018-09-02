package challenge.TheaterSeating.driver;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import challenge.TheaterSeating.service.MovieTheater;
import challenge.TheaterSeating.util.FileProcessor;

public class Driver {
	public static void main(String[] args){
		if(args.length >0){
			//System.out.println("Input arguments: "+args[0]);
			FileProcessor fileProcessor = new FileProcessor(args[0]);
			//String fileContent = fileProcessor.readFile(args[0]);
			MovieTheater movieTheater = new MovieTheater(); 
			
			try{
			File file = new File(args[0]);
			
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String newEntry = bufferedReader.readLine();
			
			while(newEntry != null){
				movieTheater.bookSeat(newEntry);
				newEntry = bufferedReader.readLine();
				//System.out.println(newEntry);
				
			}
			fileProcessor.writeToFile(movieTheater.getResults());
			movieTheater.printMap();
			} catch (FileNotFoundException ex) {
				System.err.println("Input file not Found.");
				ex.printStackTrace();
				System.exit(1);
			} catch (IOException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println(fileContent);
		}
		
		
	}
}
