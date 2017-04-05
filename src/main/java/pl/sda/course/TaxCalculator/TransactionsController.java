package pl.sda.course.TaxCalculator;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/transactions")
public class TransactionsController {
	
	private FileProcessor fileProcessor;
	
	@RequestMapping(method = { RequestMethod.GET }, produces = "application/json")
	@ResponseBody
	public List<Transaction> getTransactions() {
		return fileProcessor.getAllTransactions();
	}

	@RequestMapping(method = { RequestMethod.POST }, consumes = "application/json")
	public String addTransaction(@RequestBody Transaction transaction){
		fileProcessor.add(transaction);
		
		return "Dodano: " + fileProcessor.add(transaction);
	}
	
}
