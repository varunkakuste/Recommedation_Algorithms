package com.sjsu.edu.recommendations;

import java.util.ArrayList;


public class JobBean {
	
	

	private long jobID;
	private String companyName;
	private String jobTitle;
	private String city;
	private String State;
	private ArrayList<String> requiredSkills;
	private ArrayList<String> recommmendedSkills;
	private int matchPercentage;
	
	
	public long getJobID() {
		return jobID;
	}
	public void setJobID(long jobID) {
		this.jobID = jobID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public ArrayList<String> getRequiredSkills() {
		return requiredSkills;
	}
	public void setRequiredSkills(ArrayList<String> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}
	public ArrayList<String> getRecommmendedSkills() {
		return recommmendedSkills;
	}
	public void setRecommmendedSkills(ArrayList<String> recommmendedSkills) {
		this.recommmendedSkills = recommmendedSkills;
	}
	public int getMatchPercentage() {
		return matchPercentage;
	}
	public void setMatchPercentage(int matchPercentage) {
		this.matchPercentage = matchPercentage;
	}
	
	

}
