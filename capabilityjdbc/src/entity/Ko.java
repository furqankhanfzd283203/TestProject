package entity;

public class Ko {
	private int id;
	private String name;
	private String koType;
	private String description;
	private Capability capability;

	public Ko() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public Ko(int id, String name, String koType, String desciption, Capability capability) {
		super();
		this.id = id;
		this.name = name;
		this.koType = koType;
		this.description = desciption;
		this.capability = capability;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKoType() {
		return koType;
	}

	public void setKoType(String koType) {
		this.koType = koType;
	}

	public String getDesciption() {
		return description;
	}

	public void setDesciption(String desciption) {
		this.description = description;
	}

	public Capability getCapability() {
		return capability;
	}

	public void setCapability(Capability capability) {
		this.capability = capability;
	}

	@Override
	public String toString() {
		return "Ko [id=" + id + ", name=" + name + ", koType=" + koType + ", description=" + description
				+ ", capability=" + capability + "]";
	}

}
