package pl.sda.course.TaxCalculator;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

public class Transaction implements Comparable<Transaction> {

	 @ApiModelProperty(example= "2017-01-01")
	private LocalDate date;
	private String description;
	private long cost;
	private long income;
	private long vat;

	public LocalDate getDate() {
		return date;
	}
	
	public int getYear() {
		return date.getYear();
	}
	
	public int getMonth() {
		return date.getMonthValue();
	}
	
	public int getDay() {
		return date.getDayOfMonth();
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getCost() {
		return cost;
	}

	public void setCost(long cost) {
		this.cost = cost;
	}

	public long getIncome() {
		return income;
	}

	public void setIncome(long income) {
		this.income = income;
	}

	public long getVat() {
		return vat;
	}

	public void setVat(long vat) {
		this.vat = vat;
	}
	
	public int compareTo(Transaction trans) {
		if(this.getYear() < trans.getYear()){
			return -1;
		} else if(this.getYear() > trans.getYear()){
			return 1;
		} else if(this.getMonth() < trans.getMonth()){
			return -1;
		} else if(this.getMonth() > trans.getMonth()){
			return 1;
		} else if(this.getDay() < trans.getDay()){
			return -1;
		} else if(this.getDay() > trans.getDay()){
			return 1;
		} else {
			return 0;
		}
	}
}
