
public class SMS extends Communication {
	

	private String text;
	

	public SMS(String number1, String number2, int day, int month, int year, String text) {
		super(number1, number2, day, month, year);
		this.text = text;
	}

	@Override
	public void printInfo() {
	    System.out.println("This SMS has the following info");
	    System.out.println("Between " + getNumber1() + " --- " + getNumber2());
	    System.out.println("on " + getYear() + "/" + getMonth() + "/" + getDay());
	    System.out.println("Text: " + text);
	}

	// Getters
	public String getText() {
	    return text;
	}

}
