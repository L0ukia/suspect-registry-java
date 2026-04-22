
public abstract class Communication {
	
	private String number1;
	private String number2;
	private int day;
	private int month;
	private int year;
	
	public Communication(String number1, String number2, int day, int month, int year) {
		super();
		this.number1 = number1;
		this.number2 = number2;
		this.day = day;
		this.month = month;
		this.year=year;
	}

	public String getNumber1() {
	    return number1;
	}

	public String getNumber2() {
	    return number2;
	}
	
	public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
	
	
	public void addCommunication(Communication communication) {
		
		
	}
	public abstract void printInfo();

	
}
