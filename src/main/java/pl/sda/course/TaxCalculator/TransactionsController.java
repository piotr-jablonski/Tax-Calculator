package pl.sda.course.TaxCalculator;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {
	
	private FileProcessor fileProcessor;
	
	@RequestMapping(path = "/transactions", method = { RequestMethod.GET })
	public List<String> getTransactions() {

		return Arrays.asList("hello");
	}

	@RequestMapping(path = "transactions/add", method = { RequestMethod.POST })
	public String addTransaction(@RequestBody Transaction transaction){
		fileProcessor.add(transaction);
		
		return "Dodano";
	}
	
}
