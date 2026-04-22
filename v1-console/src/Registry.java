import java.util.ArrayList;

public class Registry {
	private ArrayList<Suspect> suspects;
	private ArrayList<Communication> communications;
	
	

	public void addSuspect(Suspect suspect) {
		if (!suspects.contains(suspect)) {
	        suspects.add(suspect);
	    }
		
	}

	public void addCommunication(Communication communication) {
		
		 communications.add(communication);

		   
		 String num1 = communication.getNumber1();
		 String num2 = communication.getNumber2();

		 Suspect suspect1 = getSuspectByNumber(num1);
		 Suspect suspect2 = getSuspectByNumber(num2);

		   if (suspect1 != null && suspect2 != null) {
		       suspect1.addPartner(suspect2);
		       suspect2.addPartner(suspect1);
		    }
	}

	public Suspect getSuspectWithMostPartners() {
		 Suspect topSuspect = null;
		    int maxPartners = 0;

		    for (Suspect suspect : suspects) {
		        if (suspect.pList.size() > maxPartners) {
		            maxPartners = suspect.pList	.size();
		            topSuspect = suspect;
		        }
		    }
		    return topSuspect;
		
		
		   
	}
	

	public PhoneCall getLongestPhoneCallBetween(String number1, String number2) {
		PhoneCall longestCall = null;
	    int maxDuration = 0;

	    for (Communication comm : communications) {
	        if (comm instanceof PhoneCall) {
	            PhoneCall call = (PhoneCall) comm;
	            if ((call.getNumber1().equals(number1) && call.getNumber2().equals(number2)) ||
	                (call.getNumber1().equals(number2) && call.getNumber2().equals(number1))) {
	                if (call.getDuration() > maxDuration) {
	                    maxDuration = call.getDuration();
	                    longestCall = call;
	                }
	            }
	        }
	    }
	    return longestCall;
		
	}

	public ArrayList<SMS> getMessagesBetween(String number1, String number2) {
		ArrayList<SMS> result = new ArrayList<>();
	    String[] suspiciousWords = {"Bomb", "Attack", "Explosives", "Gun"};

	    for (Communication comm : communications) {
	        if (comm instanceof SMS) {
	            SMS sms = (SMS) comm;
	            if ((sms.getNumber1().equals(number1) && sms.getNumber2().equals(number2)) ||
	                (sms.getNumber1().equals(number2) && sms.getNumber2().equals(number1))) {
	                for (String word : suspiciousWords) {
	                    if (sms.getText().contains(word)) {
	                        result.add(sms);
	                        break;
	                    }
	                }
	            }
	        }
	    }
	    return result;
	
	}
	
	private Suspect getSuspectByNumber(String number) {
	    for (Suspect suspect : suspects) {
	        if (suspect.pnList.contains(number)) {
	            return suspect;
	        }
	    }
	    return null;
	}
	

	
	

}
