public class Exercise {
	
	private String type;
	private String name;
	
	public Exercise() {
		type = "";
		name = "";
	}
	public Exercise(String t, String n) {
		setType(t);
		name = n;
	}
	
	public void setType(String t) {
		type = t;
	}
	
	public void setName(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public String getType() {
		return type;
	}

}
