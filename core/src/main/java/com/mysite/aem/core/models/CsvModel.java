package com.mysite.aem.core.models;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class CsvModel {
	@JsonPropertyOrder({ "empId", "firstName", "lastName", "gender", "city" })
	    private int empId;
	    private String firstName;
	    private String lastName;
	    private String gender;
	    private String city;

	    public CsvModel() {
	        super();
	    }

	    public CsvModel(int empId, String firstName, String lastName, String gender, String city) {
	        this.empId = empId;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.gender = gender;
	        this.city = city;
	    }

		public int getEmpId() {
			return empId;
		}

		public void setEmpId(int empId) {
			this.empId = empId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		public String getCity() {
			return city;
		}

		public void setCity(String city) {
			this.city = city;
		}
}