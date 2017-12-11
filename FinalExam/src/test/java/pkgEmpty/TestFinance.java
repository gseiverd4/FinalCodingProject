package pkgEmpty;

import static org.junit.Assert.*;

import org.junit.Test;
import org.apache.poi.ss.formula.functions.*;
public class TestFinance {

	
	@Test 
	public void TestAmounts()
	{
		double MonthsToWork = 40 * 12;
		double workingReturn = 0.07 / 12;
		double MonthsRetired = 20 * 12;
		double retiredReturn = 0.02 / 12;
		double Income = 10000;
		double MonthSSI = 2642;
		double pv = FinanceLib.pv(retiredReturn, MonthsRetired, Income - MonthSSI, 0, false);
		
		double pmt = FinanceLib.pmt(workingReturn, MonthsToWork, 0, pv, false);
		
		System.out.println(pv);
		System.out.println(pmt);
	}
	
	
	@Test
	public void TestPV()
	{
		double r = 0.025 / 12;
		double n = 20 * 12;
		double y = 10000-2642;
		double f = 0;
		boolean t = false;
		double pv = FinanceLib.pv(r, n, y, f, t);
		
		//System.out.println(pv);
		
	}
	
	
	@Test
	public void TestPMT() {
		double r = 0.042 / 12;
		double n = 60;
		double p = 30000;
		double f = 0;
		boolean t = false;
		
		double d = FinanceLib.pmt(r, n, p, f, t);
		
		//System.out.println(d);
		
		
		
	}

}
