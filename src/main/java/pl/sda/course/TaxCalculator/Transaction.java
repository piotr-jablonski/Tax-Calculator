package pl.sda.course.TaxCalculator;

import java.time.LocalDate;

import io.swagger.annotations.ApiModelProperty;

public class Transaction {

	 @ApiModelProperty(example= "2017-01-01")
	private LocalDate date;
	private String description;
	private long cost;
	private long income;
	private long vat;

	public LocalDate getDate() {
		return date;
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

}
