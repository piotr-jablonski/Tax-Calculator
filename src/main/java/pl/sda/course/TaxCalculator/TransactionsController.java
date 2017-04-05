package pl.sda.course.TaxCalculator;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/transactions")
public class TransactionsController {
	
	private FileProcessor fileProcessor;
	
	public TransactionsController(@Autowired FileProcessor fileProcessor){
		this.fileProcessor = fileProcessor;
	}
	

	@RequestMapping(method = RequestMethod.GET , produces = "application/json")
	//@ResponseBody
	public List<Transaction> getTransactions() {
		List<Transaction> allTransactions = fileProcessor.getAllTransactions();
		return allTransactions;
		
	}

	@RequestMapping(method = { RequestMethod.POST }, consumes = "application/json")
	public String addTransaction(@RequestBody Transaction transaction){
		boolean check = fileProcessor.add(transaction);
		return "Dodano: " + check;
	} 
	
}
