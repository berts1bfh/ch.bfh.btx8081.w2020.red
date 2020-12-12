package view;

public interface CalculatorViewInterface {
	
	public void setDisplay(double value);
	
	interface CalculatorViewListener {
		void buttonClick(char operation);
	}
	
	public void addListener(CalculatorViewListener listener);

}
