package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.Retirement;

public class RetirementController implements Initializable {

		
	private RetirementApp mainApp = null;
	@FXML
	private TextField workYears;
	@FXML
	private TextField workingReturn;
	@FXML
	private TextField yearsRetired;
	@FXML
	private TextField retiredReturn;
	@FXML
	private TextField Income;
	@FXML
	private TextField MonthSSI;
	@FXML
	private TextField totalSavings;
	@FXML
	private TextField savingsNeeded;
	
	

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {		
	}
	
	
	@FXML
	public void btnClear(ActionEvent event) {
		System.out.println("Clear pressed");
		
		workYears.clear();
		workingReturn.clear();
		yearsRetired.clear();
		retiredReturn.clear();
		Income.clear();
		MonthSSI.clear();
		totalSavings.clear();
		savingsNeeded.clear();
	}
	
	@FXML
	public void btnCalculate(ActionEvent event) {
		
		if(isInputValid()) {
			int yearsWorking = (Integer.parseInt(workYears.getText()));
			
			double returnWorking = (Double.parseDouble(workingReturn.getText()));
			
			int retiredYears = (Integer.parseInt(yearsRetired.getText()));
			
			double returnRetired = (Double.parseDouble(retiredReturn.getText()));
			
			double income = (Double.parseDouble(Income.getText()));
			
			double SSImonth = (Double.parseDouble(MonthSSI.getText()));
			
			Retirement r = new Retirement(yearsWorking,returnWorking,retiredYears,
					returnRetired,income,SSImonth);
			
		
				totalSavings.setText(Double.toString(r.totalSavings()));
				savingsNeeded.setText(Double.toString(r.savingsNeeded()));
			}
	}
		

	private boolean isInputValid() {
        String errorMessage = "";
        
        //for years worked
        if (workYears.getText() == null || workYears.getText().length() == 0) {
            errorMessage += "Invalid # of years.\n"; 
        } else {
        
        		try {
        			Integer.parseInt(workYears.getText());
        		} catch (NumberFormatException e) {
        			errorMessage += "Invalid integer(years worked)\n"; 
        }
        }
        
        //for retired years
        		try {
        			Integer.parseInt(yearsRetired.getText());
        		} catch (NumberFormatException e) {
        			errorMessage += "Invalid integer(years retired)\n"; 
        }
        		if (yearsRetired.getText() == null) {
        			errorMessage += "Must enter an integer";
        		}
        
        //for annual working return
        
	        try {
	            if(Double.parseDouble(workingReturn.getText())<0 || 
	            		Double.parseDouble(workingReturn.getText())>.2) {
	            	errorMessage += "Integer but be between 0-.2(working return)\n";
	            }
	            
	        } catch (NumberFormatException e) {
	            errorMessage += "Invalid integer(working return)\n"; 
        }
	        if (workingReturn.getText() == null) {
    			errorMessage += "Must enter an integer";
        }
        
        //for annual retired return
	        try {
	        	if(Double.parseDouble(retiredReturn.getText())<0 || 
	        			Double.parseDouble(retiredReturn.getText())>.03) {
	            	errorMessage += "Inetger must be between 0-.3(retired return)\n";
	            }
	        } catch (NumberFormatException e) {
	            errorMessage += "Invalid integer(retired return)\n"; 
        }
	        if (retiredReturn.getText() == null) {
    			errorMessage += "Must enter an integer";
        }
        
        //for required income
	        try {
	            Double.parseDouble(Income.getText());
	        } catch (NumberFormatException e) {
	            errorMessage += "Invalid integer(income)\n"; 
        }
	        if (Income.getText() == null) {
    			errorMessage += "Must enter an integer";
        }
        
        //for monthly Social Security
	        try {
	            Double.parseDouble(MonthSSI.getText());
	        }
	         catch (NumberFormatException e) {
	            errorMessage += "Invalid integer(monthSSI)\n"; 
        }
	        if (MonthSSI.getText() == null) {
    			errorMessage += "Must enter an integer";
        }
        
        //test
        if (errorMessage.length() == 0) {
            return true;
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("There are invalid inputs");
            alert.setHeaderText("Fix invalid inputs");
            alert.setContentText(errorMessage);
            
            alert.showAndWait();
            
            return false;
        }
	}
}
