import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Suspect {
	String name,codename,city;
	
	ArrayList<String> pnList = new ArrayList<>();
	HashSet<Suspect> partners;
	

	public Suspect(String name, String codename, String city) {
		super();
		this.name = name;
		this.codename = codename;
		this.city = city;
		this.partners = new HashSet<>();
		
	}

	

	public boolean isConnectedTo(Suspect suspect) {
		
		return partners.contains(suspect);
	}



	public ArrayList<Suspect> getCommonPartners(Suspect suspect) {
		
		ArrayList<Suspect> common = new ArrayList<>();
	    for (Suspect partner : partners) {
	        if (suspect.partners.contains(partner)) {
	            common.add(partner);
	        }
	    }
	    return common;
	}



	public String getCodeName() {
		
		return codename;
	}



	public String getName() {
		
		return name;
		
	}
	
	public void addNumber(String number) {
	    if (!pnList.contains(number)) {
	        pnList.add(number);
	    }
	}
	
	public void addPartner(Suspect suspect) {
	    if (!partners.contains(suspect)) {
	    	partners.add(suspect);
	    }
	}
	
	public void printPartners() {
	    for (Suspect partner : partners) {
	        System.out.println(partner.getName() + ", " + partner.getCodeName());
	    }
	}
	 public Set<Suspect> getSuggestedPartners() {
	        Set<Suspect> suggestions = new HashSet<>();

	        for (Suspect partner : partners) {
	            for (Suspect partnerOfPartner : partner.partners) {
	                if (!partnerOfPartner.equals(this) && !partners.contains(partnerOfPartner)) {
	                    suggestions.add(partnerOfPartner);
	                }
	            }
	        }
	        return suggestions;
	    }



	public ArrayList<String> getPhoneNumbers() {
        return pnList;
		}
	}


