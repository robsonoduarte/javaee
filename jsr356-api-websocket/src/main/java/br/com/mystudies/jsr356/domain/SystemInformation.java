package br.com.mystudies.jsr356.domain;

public class SystemInformation {



	private String name;
	private int numberAccess;


	
	
	public SystemInformation(String name, int numberAccess){
		this.name = name;
		this.numberAccess = numberAccess;

	}
	
	public void addAccess(int access) {
		numberAccess += access;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberAccess;
		return result;
	}


	

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SystemInformation other = (SystemInformation) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberAccess != other.numberAccess)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "SystemInformation [name=" + name + ", numberAcess=" + numberAccess + "]";
	}




	
	
}
