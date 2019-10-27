package academy.tae.globant;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class Rol {

	protected String rolName;
	protected int rolSalary;
	protected Iterator<String> iteratorList;
	protected ArrayList<String> listResponsabilitiesJuniorEngeneer;
	private ArrayList<String> listResponsabilitiesSeniorEngeneer;
	private ArrayList<String> listResponsabilitiesTechnicalLead;

	public Rol() {
	}

	public Rol(String rolName, int rolSalary) {
		this.rolName = rolName;
		this.rolSalary = rolSalary;
	}

	public abstract void rolName();

	public abstract Integer rolSalary();

	/**
	 * Lists of responsabilities by rol. (Junior/Senior Engeneer and TL)
	 * 
	 * @return
	 */
	public ArrayList<String> listResponsabilityJuniorEngeneer() {
		listResponsabilitiesJuniorEngeneer = new ArrayList<>();
		listResponsabilitiesJuniorEngeneer.add("Responsabilidad Junior uno");
		listResponsabilitiesJuniorEngeneer.add("Responsabilidad Junior dos");
		printingList (listResponsabilitiesJuniorEngeneer);
		return listResponsabilitiesJuniorEngeneer;
	}

	public ArrayList<String> listResponsabilitySeniorEngeneer() {
		listResponsabilitiesSeniorEngeneer = new ArrayList<>();
		listResponsabilitiesSeniorEngeneer.add("Responsabilidad Senior uno");
		listResponsabilitiesSeniorEngeneer.add("Responsabilidad Senior dos");
		printingList (listResponsabilitiesSeniorEngeneer);
		return listResponsabilitiesSeniorEngeneer;
	}

	public ArrayList<String> listResponsabilityTechnicalLead() {
		listResponsabilitiesTechnicalLead = new ArrayList<>();
		listResponsabilitiesTechnicalLead.add("Responsabilidad T.L uno");
		listResponsabilitiesTechnicalLead.add("Responsabilidad T.L dos");
		printingList (listResponsabilitiesTechnicalLead);
		return listResponsabilitiesTechnicalLead;
	}
	
	public void printingList(ArrayList<String> printList) {
		iteratorList = printList.iterator();
		int i = 1;
		while(iteratorList.hasNext()) {
			System.out.println(i + "- "+ iteratorList.next());
			i++;
		}
	}

	/**
	 * Getters rolName and RolSalary
	 * 
	 * @return
	 */
	public String getRolName() {
		return rolName;
	}
	
	public void setRolName(String rolName) {
		this.rolName = rolName;
	}

	public int getRolSalary() {
		return rolSalary;
	}
	
	public void setRolSalary(int rolSalary) {
		this.rolSalary = rolSalary;
	}
}
