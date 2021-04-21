package com.herokutest.testapp297.dtos;

public class IncomeData {

	private int annualIncome;
	private int eightyCDeduction;
	private int eightyCCDDeduction;
	private int hraDeduction;
	private int otherFlexibleDeductions;

	/**
	 * @return the annualIncome
	 */
	public int getAnnualIncome() {
		return annualIncome;
	}

	/**
	 * @param annualIncome the annualIncome to set
	 */
	public void setAnnualIncome(int annualIncome) {
		this.annualIncome = annualIncome;
	}

	/**
	 * @return the eightyCDeduction
	 */
	public int getEightyCDeduction() {
		return eightyCDeduction;
	}

	/**
	 * @param eightyCDeduction the eightyCDeduction to set
	 */
	public void setEightyCDeduction(int eightyCDeduction) {
		this.eightyCDeduction = eightyCDeduction;
	}


	/**
	 * @return the hraDeduction
	 */
	public int getHraDeduction() {
		return hraDeduction;
	}

	/**
	 * @param hraDeduction the hraDeduction to set
	 */
	public void setHraDeduction(int hraDeduction) {
		this.hraDeduction = hraDeduction;
	}

	/**
	 * @return the otherFlexibleDeductions
	 */
	public int getOtherFlexibleDeductions() {
		return otherFlexibleDeductions;
	}

	/**
	 * @param otherFlexibleDeductions the otherFlexibleDeductions to set
	 */
	public void setOtherFlexibleDeductions(int otherFlexibleDeductions) {
		this.otherFlexibleDeductions = otherFlexibleDeductions;
	}

	/**
	 * @return the eightyCCDDeduction
	 */
	public int getEightyCCDDeduction() {
		return eightyCCDDeduction;
	}

	/**
	 * @param eightyCCDDeduction the eightyCCDDeduction to set
	 */
	public void setEightyCCDDeduction(int eightyCCDDeduction) {
		this.eightyCCDDeduction = eightyCCDDeduction;
	}
}
