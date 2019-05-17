package model;

public class Inscrito {
	
	//Constants
	
	//Attributes
	private String id;
	private String name;
	private String lastName;
	private String email;
	private String gender;
	private String country;
	private String photo;
	private String birthday;
	
	//Relations
	private Inscrito r;
	private Inscrito l;
	
	//Constructors
	public Inscrito(String id, String name, String lastName, String email, String gender, String country, String photo, String birthday) {
		
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
		
		r = null;
		l = null;
		
	}
	
	//Getters and Setters
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public String getGender() {
		return gender;
	}

	public String getCountry() {
		return country;
	}

	public String getPhoto() {
		return photo;
	}

	public String getBirthday() {
		return birthday;
	}

	public Inscrito getR() {
		return r;
	}

	public Inscrito getL() {
		return l;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public void setR(Inscrito r) {
		this.r = r;
	}

	public void setL(Inscrito l) {
		this.l = l;
	}
	
	//Methods
	public void insert(Inscrito x) {
		
		if(x!=null) {
			if(this.id.compareTo(x.getId()) > 0) {
				if(l == null) {
					l = x;
				}else {
					l.insert(x);
				}
			}else if(this.id.compareTo(x.getId()) < 0) {
				if(r == null) {
					r = x;
				}else {
					r.insert(x);
				}
			}
		}
		
	}
	
	public Inscrito buscar(String d) {
		
		if(this.id.equals(d)) {
			return this;
		}else {
			if(this.id.compareTo(d) > 0 && this.getL() != null) {
				return this.getL().buscar(d);
			}else if(this.id.compareTo(d) < 0 && this.getR() != null) {
				return this.getR().buscar(d);
			}else {
				return null;
			}
		}
		
	}
	
	public String toString() {
		return id + " = ["+ name +" "+ lastName +", "+ email +", "+ gender + ", "+ country + ", "+ birthday +"]";
	}
	
}
