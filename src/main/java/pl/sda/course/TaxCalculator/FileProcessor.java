package pl.sda.course.TaxCalculator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

public class FileProcessor {
	
	public boolean add (List <Transaction> list) {
		boolean check = true;
		File file = new File ("records.txt");
		try (Writer writer = new FileWriter(file, true)){
			
		} catch (IOException e) {
			e.printStackTrace();
		} {
			
			
			
			
		}
				
		return check;
		
		
	}
	
}
