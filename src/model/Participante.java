package model;

public class Participante {
	
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
	private Participante back;
	private Participante next;
	
	//Constructors
	public Participante(String id, String name, String lastName, String email, String gender, String country, String photo, String birthday) {
		
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.country = country;
		this.photo = photo;
		this.birthday = birthday;
		
		back = null;
		next = null;
		
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

	public Participante getBack() {
		return back;
	}

	public Participante getNext() {
		return next;
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

	public void setBack(Participante back) {
		this.back = back;
	}

	public void setNext(Participante next) {
		this.next = next;
	}
	
	//Methods
	public void insert(Participante z) {
		
		Participante x = this;
		
		if(x.getNext() == null) {
			x.setNext(z);
			z.setBack(x);
		}else {
			x.getNext().insert(z);
		}
		
	}
	
	public Participante buscar(String b) {
		
		if(this.id.equals(b)) {
			return this;
		}else {
			if(this.getNext() != null) {
				return this.getNext().buscar(b);
			}else {
				return null;
			}
		}
		
	}
	
	public String toString() {
		return id;
	}
	
}
