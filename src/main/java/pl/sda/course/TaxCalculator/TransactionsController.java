package pl.sda.course.TaxCalculator;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TransactionsController {
	
	@RequestMapping(path = "/transactions", method = { RequestMethod.GET })
	public List<String> getTransactions() {

		return Arrays.asList("hello");
	}


	
	
}
