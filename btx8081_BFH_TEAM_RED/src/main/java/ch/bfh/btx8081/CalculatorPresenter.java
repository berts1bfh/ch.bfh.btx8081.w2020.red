package ch.bfh.btx8081;

class CalculatorPresenter implements CalculatorView.CalculatorViewListener {
	private CalculatorModel model;
	private CalculatorView view;
	private double current = 0.0;

	private char lastOperationRequested = 'C';

	public CalculatorPresenter(CalculatorModel model, CalculatorView view) {
	
		this.model = model; this.view = view;
	view.setDisplay(current);
	view.addListener(this);
	}

	public void buttonClick(char operation) {
		if ('0' <= operation && operation <= '9') {
			current = current * 10 + Double.parseDouble("" + operation);
			view.setDisplay(current);
			return;
		}
		switch (lastOperationRequested) {
		case '+':
			model.add(current);
			break;
		case '-':
			model.add(-current);
			break;
		case '/':
			//model.divide(current);
			break;
		case '*':
			model.multiply(current);
			break;
		case 'C':
			model.setValue(current);
			break;
		} // '=' is implicit
		lastOperationRequested = operation;
		current = 0.0;
		if (operation == 'C')
			model.clear();
		view.setDisplay(model.getValue());
	}

}
