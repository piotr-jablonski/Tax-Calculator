package pl.sda.course.TaxCalculator;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Writer;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileProcessor {
	
	public boolean add (Transaction transaction) {
		boolean check = true;
		File file = new File ("records.txt");
		try (Writer writer = new FileWriter(file, true)) {
			
			writer.write(
			transaction.getDate() + ";" + 
			transaction.getDescription() + ";" + 
			transaction.getCost() + ";" + 
			transaction.getIncome() + ";" + 
			transaction.getVat() + System.lineSeparator());
			
			writer.flush();
		} catch (IOException ex) {
			System.out.println(ex);
			ex.printStackTrace();
			check = false;
		}
		return check;
	}
	
	public List<Transaction> getAllTransactions(){
		FileInputStream fstream = null;
		String strLine;
		List<Transaction> allTransactions = new ArrayList<Transaction>();
		BufferedReader br = null;
		try {
			fstream = new FileInputStream("records.txt");
			br = new BufferedReader(new InputStreamReader(fstream));
			while ((strLine = br.readLine()) != null){
				
				Transaction transaction = new Transaction();
				
				String[] parts = strLine.split(";");
				String stringDate = parts[0];
				
					String[] dateParts = stringDate.split("-");
					int year = Integer.valueOf(dateParts[0]);
					int month = Integer.valueOf(dateParts[1]);
					int day = Integer.valueOf(dateParts[2]);
				
				String description = parts[1];
				parts[2].replace(",", "");
				parts[2].replace(".", "");
				int cost = Integer.valueOf(parts[2]);
				parts[3].replace(",", "");
				parts[3].replace(".", "");
				int income = Integer.valueOf(parts[3]);
				parts[4].replace(",", "");
				parts[4].replace(".", "");
				int vat = Integer.valueOf(parts[4]);
				
				LocalDate date = null;
				date.of(year, month, day);
				transaction.setDate(date);
				transaction.setDescription(description);
				transaction.setCost(cost);
				transaction.setIncome(income);
				transaction.setVat(vat);
				
				allTransactions.add(transaction);
			}
		} catch (IOException ex) {
			System.out.println(ex);
			ex.printStackTrace();
		} finally {
			try {
				if (fstream != null){
					fstream.close();
				}
			} catch (IOException ex) {
				System.out.println(ex);
				ex.printStackTrace();
			}
		}
		return allTransactions;
	}
	
}
