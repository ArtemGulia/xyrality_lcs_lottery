package lcs.lottery.entity;

import java.util.List;

public class Participant implements Comparable<Participant> {

	private String lastName;
	private String firstName;
	private String country;
	private List<String> tickets;
	private int credits;

	public Participant() {
	}

	public Participant(String lastName, String firstName, String country, List<String> tickets) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.country = country;
		this.tickets = tickets;
	}

	/**
	 * Method for increasing won credits of Participant
	 *
	 * @param credit amount of credits to add
	 */
	public void addCredit(int credit) {
		this.credits += credit;
	}

	/***
	 * Getters & Setters
	 **/

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<String> getTickets() {
		return tickets;
	}

	public void setTickets(List<String> tickets) {
		this.tickets = tickets;
	}

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}
	@Override
	public String toString() {
		return lastName + "," + firstName + "," + country + "," + credits;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Participant that = (Participant) o;

		if (!lastName.equals(that.lastName)) return false;
		if (!firstName.equals(that.firstName)) return false;
		return country.equals(that.country);

	}

	@Override
	public int hashCode() {
		int result = lastName.hashCode();
		result = 31 * result + firstName.hashCode();
		result = 31 * result + country.hashCode();
		return result;
	}


	@Override
	public int compareTo(Participant o) {
		if (!this.lastName.equals(o.getLastName())) {
			return this.lastName.compareTo(o.getLastName());
		}
		if(!this.firstName.equals(o.getFirstName())) {
			return this.firstName.compareTo(o.getFirstName());
		}
		return this.country.compareTo(o.getCountry());
	}
}
