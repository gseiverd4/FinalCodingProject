package pkgCore;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.ss.formula.functions.FinanceLib;

public class Retirement {

	private int workYears;
	private double workingReturn;
	private int yearsRetired;
	private double retiredReturn;
	private double Income;
	private double MonthSSI;
	
	public Retirement(int workYears, double workingReturn, int yearsRetired, double retiredReturn, double Income, double MonthSSI) {

		this.setworkYears(workYears);
		this.setretiredReturn(retiredReturn);
		this.setyearsRetired(yearsRetired);
		this.setworkingReturn(workingReturn);
		this.setIncome(Income);
		this.setMonthSSI(MonthSSI);
	}
	public int getworkYears() {
		return workYears;
	}

	public void setworkYears(int workYears) {
		this.workYears = workYears;
	}

	public double getworkingReturn() {
		return workingReturn;
	}

	public void setworkingReturn(double workingReturn) {
		this.workingReturn = workingReturn;
	}

	public int getyearsRetired() {
		return yearsRetired;
	}

	public void setyearsRetired(int yearsRetired) {
		this.yearsRetired = yearsRetired;
	}

	public double getretiredReturnd() {
		return retiredReturn;
	}

	public void setretiredReturn(double retiredReturn) {
		this.retiredReturn = retiredReturn;
	}

	public double getIncome() {
		return Income;
	}

	public void setIncome(double Income) {
		this.Income = Income;
	}

	public double getMonthSSI() {
		return MonthSSI;
	}

	public void setMonthSSI(double MonthSSI) {
		this.MonthSSI = MonthSSI;
	}
	
	public double savingsNeeded()
	{
		DecimalFormat d = new DecimalFormat("0.0");
		return Double.parseDouble(d.format(FinanceLib.pmt
				(workingReturn/100/12, workYears*12, this.totalSavings(), 0, false)));
	}
	
	public double totalSavings()
	{
		DecimalFormat d = new DecimalFormat("0.0");
		return Double.parseDouble(d.format(FinanceLib.pv
				(retiredReturn /100/12, yearsRetired *12, (Income - MonthSSI), 0, false)));
	}
}
