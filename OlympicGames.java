package edu.kit.informatik;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class OlympicGames {
	
	private Map<String , Admin> admins = new HashMap<>();
	private List<Admin> loggedInUsers = new LinkedList<>();
	private Map<Integer , SportsVenue> sportsVenues = new HashMap<>();
	private Map<String , ArrayList<String>> sports = new HashMap<>();
	private List<IocCode> iocCodes = new ArrayList<>();
	private Map<Integer,Athlete> athletes = new HashMap<>();
	
	
	
	
	public void addAdmin(String firstName , String  lastName , String userName , String passWord) throws InputException{
		if(userName.length() < 4 || userName.length() > 8) {
			throw new InputException("Please choose a valid username");
		}
		else if(passWord.length() < 8 || passWord.length() > 12) {
			throw new InputException("Please choose a valid password");
		}
		else {
		Admin admin = new Admin (firstName , lastName , userName , passWord);
		if(admins.containsKey(userName)) {
			throw new InputException("Username not available ");
		}else {
			admins.put(userName, admin);
		 }
		}
	}
	
	public void loginAdmin(String userName , String passWord) throws InputException{
		if(!admins.containsKey(userName)) {
			throw new InputException("User does not exist yet");
		}
		else if (!passWord.equals(admins.get(userName).getPassWord())) {
			throw new InputException("Incorrect password");
		}
		else {
			loggedInUsers.add(admins.get(userName));
		}
	}
	
	public void logoutAdmin() throws InputException{
		if(loggedInUsers.isEmpty()) {
			throw new InputException("No logged in users");
		}else {
			loggedInUsers.clear();
		}
	}
	
	public void addSportsVenue(int id , String countryName , String location , String name , int openingYear , int seatsNumber) 
	       throws InputException{
		SportsVenue sportsVenue = new SportsVenue(id , countryName , location , name , openingYear , seatsNumber);
		if(sportsVenues.containsKey(id)) {
			throw new InputException ("Sports venue already exists");
		}
		else {
			sportsVenues.put(id, sportsVenue);
		}
		
	}
	
	public void listSportsVenues (String countryName) throws InputException{
		ArrayList<SportsVenue> sportsVenuesToList = new ArrayList<>();
		int n = 1;
		for(Map.Entry<Integer , SportsVenue> entry : sportsVenues.entrySet()) {
			if(entry.getValue().getCountryname().equals(countryName)) {
				sportsVenuesToList.add(entry.getValue());
			}
		}
		
		Collections.sort(sportsVenuesToList , SportsVenue.compareSportsVenues());
		for(SportsVenue sportsVenue : sportsVenuesToList) {
			Terminal.printLine(n + " " + sportsVenue);
			n++;
		}
		
	}
	
	public void addOlympicSport(String sportsType , String sportsDiscipline) throws InputException {
		ArrayList<String> disciplines = new ArrayList<>();
		disciplines.add(sportsDiscipline);
		if(sports.containsKey(sportsType) && sports.get(sportsType).contains(sportsDiscipline)) {
			throw new InputException("Sportdiscipline already exists");
		}
		else if(sports.containsKey(sportsType)) {
			ArrayList<String> discipline = sports.get(sportsType);
			discipline.add(sportsDiscipline);
			sports.put(sportsType, discipline);
		}else
		
		sports.put(sportsType, disciplines);
		
	}
	
	public void listOlympicSports() throws InputException {
		for(Map.Entry<String, ArrayList<String>> entry : sports.entrySet()) {
				for(int i = 0 ; i<entry.getValue().size() ; i++) {
					Terminal.printLine(entry.getKey() + " " + entry.getValue().get(i));
				}
			}
		}
	
	public void addIocCode(String country , int id , String ioc , int year) {
		IocCode iocCode = new IocCode(country,id,ioc,year);
		iocCodes.add(iocCode);
	}
	
	public void listIocCodes() {
		Collections.sort(iocCodes , IocCode.compareIocCodes());
		for(IocCode iocCode : iocCodes) {
			Terminal.printLine(iocCode);
		}
	}
	
	public void addAthlete(int id , String firstName , String lastName , String country , String sport , String discipline)
	       throws InputException{
		Athlete athlete = new Athlete(id,firstName,lastName,country,sport,discipline);
		if(athletes.containsKey(athlete.getId())) {
			throw new InputException("Athlete already added");
		}else {
			athletes.put(athlete.getId(), athlete);
		}
		
	}
	}
	

