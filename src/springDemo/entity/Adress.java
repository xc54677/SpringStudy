package springDemo.entity;

public class Adress {
	
	private String homeAdress;
	private String schoolAdress;
	
	public Adress() {
	}
	
	public Adress(String homeAdress, String schoolAdress) {
		this.homeAdress = homeAdress;
		this.schoolAdress = schoolAdress;
	}

	public String getHomeAdress() {
		return homeAdress;
	}
	public void setHomeAdress(String homeAdress) {
		this.homeAdress = homeAdress;
	}
	public String getSchoolAdress() {
		return schoolAdress;
	}
	public void setSchoolAdress(String schoolAdress) {
		this.schoolAdress = schoolAdress;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Address{" + "homeAdress: " + homeAdress + ", schoolAdress: " + 
				schoolAdress + "}";
	}

	
	

}
