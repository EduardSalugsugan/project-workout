import javafx.collections.ObservableList;

public abstract class Exercise {
	
	protected String name;
	protected String equiptmentNeeded;
	protected int timeToComplete;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTimeToComplete() {
		return timeToComplete;
	}

	public void setTimeToComplete(int timeToComplete) {
		this.timeToComplete = timeToComplete;
	}

	public String getEquiptmentNeeded() {
		return equiptmentNeeded;
	}

	public void setEquiptmentNeeded(String equiptment) {
		equiptmentNeeded = equiptment;
	}
	
	public boolean equals(Exercise exercise) {
		if(exercise.getName().equals(name))
			return true;
		
		return false;
			
	}
	
	public abstract String getType();
	

}
