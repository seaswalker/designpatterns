package proxy.dynamic;

public class PersonBeanImpl implements PersonBean {
	
	private String name;
	private String interests;
	private String personalInfo;
	private int rato;
	
	public PersonBeanImpl(String name, String interests, String personalInfo,
			int rato) {
		this.name = name;
		this.interests = interests;
		this.personalInfo = personalInfo;
		this.rato = rato;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInterests() {
		return interests;
	}

	public void setInterests(String interests) {
		this.interests = interests;
	}

	public String getPersonalInfo() {
		return personalInfo;
	}

	public void setPersonalInfo(String personalInfo) {
		this.personalInfo = personalInfo;
	}

	public int getRato() {
		return rato;
	}

	public void setRato(int rato) {
		this.rato = rato;
	}

}
