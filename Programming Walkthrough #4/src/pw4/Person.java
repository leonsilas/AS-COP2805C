package pw4;

public class Person {

	//variables
		private long ssn; //primary key
		private String firstName;
		private String lastName;
		private int age;
		private long creditCard;
	
	//constructor
		public Person(long ssn, String firstName, String lastName, int age, long creditCard) {
			super();
			this.ssn = ssn;
			this.firstName = firstName;
			this.lastName = lastName;
			this.age = age;
			this.creditCard = creditCard;
		}

	//getters and setters
		public long getSsn() {
			return ssn;
		}
	
		public void setSsn(long ssn) {
			this.ssn = ssn;
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
	
		public int getAge() {
			return age;
		}
	
		public void setAge(int age) {
			this.age = age;
		}
	
		public long getCreditCard() {
			return creditCard;
		}
	
		public void setCreditCard(long creditCard) {
			this.creditCard = creditCard;
		}

	//toString
		@Override
		public String toString() {
			return "ssn: " + ssn + "\nfirstName: " + firstName + "\nlastName: " + lastName + "\nage: " + age + "\ncreditCard: " + creditCard;
		}	
	
}//end of Person
