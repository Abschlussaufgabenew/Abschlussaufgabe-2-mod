package edu.kit.informatik;

public class Athlete {
	
	private int id ;
	private String firstName;
	private String lastName;
	private String countryName;
	private String sportsType;
	private String sportsDiscipline;
	private int medalNumber;
	
	public Athlete(int id , String firstName, String lastName , String countryName , String sportsType , String sportsDiscipline) {
		this.id = id ;
		this.firstName = firstName;
		this.lastName = lastName;
		this.countryName = countryName;
		this.sportsType = sportsType;
		this.sportsDiscipline = sportsDiscipline;
	}

	public int getId() {
		return id;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getCountryName() {
		return countryName;
	}

	public String getSportsType() {
		return sportsType;
	}

	public String getSportsDiscipline() {
		return sportsDiscipline;
	}

	public int getMedalNumber() {
		return medalNumber;
	}

	public void setMedalNumber(int medalNumber) {
		this.medalNumber = medalNumber;
	}
	
	
	
	
	

}