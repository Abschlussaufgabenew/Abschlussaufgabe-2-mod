package edu.kit.informatik;

import java.util.ArrayList;

public class OlympicSport {
	private String sportsType;
	private ArrayList<String> disciplines = new ArrayList<>();
	
	
	public OlympicSport(String sportsType) {
		this.sportsType = sportsType;
	}
	
	
	public String getSportsType() {
		return sportsType;
	}
	
	public ArrayList<String> getDisciplines(){
		return disciplines;
	}
	
	public void addDiscipline(String discipline) {
		disciplines.add(discipline);
	}
	
	
	

}
	
	
	
