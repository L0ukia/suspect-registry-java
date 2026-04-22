import java.util.ArrayList;

public class Suspect {
	String name,codename,city;
	ArrayList<Suspect> pList = new ArrayList<>();
	ArrayList<String> pnList = new ArrayList<>();
	

	public Suspect(String name, String codename, String city) {
		super();
		this.name = name;
		this.codename = codename;
		this.city = city;
		this.pList = pList;
		this.pnList = pnList;
	}

	

	public boolean isConnectedTo(Suspect suspect) {
		
		return pList.contains(suspect);
	}



	public ArrayList<Suspect> getCommonPartners(Suspect suspect) {
		
		ArrayList<Suspect> common = new ArrayList<>();
	    for (Suspect partner : pList) {
	        if (suspect.pList.contains(partner)) {
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
	    if (!pList.contains(suspect)) {
	        pList.add(suspect);
	    }
	}
	
	public void printPartners() {
	    for (Suspect partner : pList) {
	        System.out.println(partner.getName() + ", " + partner.getCodeName());
	    }
	}


}
