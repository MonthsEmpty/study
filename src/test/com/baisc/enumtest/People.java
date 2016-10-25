package test.com.baisc.enumtest;

public enum People {

	YOUNG("student",15),OLD("teacher",35);
	
	private String profession;
	
	People(String profession,int age){
		this.profession = profession;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}
	
}
