import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class myMeal {
    String breakfast;
    String snack1;
    String lunch;
    String snack2;
    String dinner;
    String snack3;
    String notes;

    public myMeal(){
        breakfast = null;
        snack1 = null;
        lunch = null;
        snack2 = null;
        dinner = null;
        snack3 = null;
        notes = null;
    }

    public String getBreakfast(){
        return breakfast;
    }

    public String getSnack1(){
        return snack1;
    }

    public String getLunch(){
        return lunch;
    }

    public String getSnack2(){
        return snack2;
    }

    public String getDinner(){
        return dinner;
    }

    public String getSnack3(){
        return snack3;
    }

    public String getNotes(){
        return notes;
    }

    public void setBreakfast(String a){
        breakfast = a;
    }

    public void setSnack1(String a){
        snack1 = a;
    }

    public void setLunch(String a){
        lunch = a;
    }

    public void setSnack2(String a){
        snack2 = a;
    }

    public void setDinner(String a){
        dinner = a;
    }

    public void setSnack3(String a){
        snack3 = a;
    }

    public void setNotes(String a){
        notes = a;
    }

    public static myMeal getCurrentMealPlan() {
        myMeal mealplan = new myMeal();
		try {
			FileReader fr = new FileReader("mealPlan.txt");
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();
			String[] cell = line.split(",");
			mealplan.setBreakfast(cell[0]);
			mealplan.setSnack1(cell[1]);
			mealplan.setLunch(cell[2]);
			mealplan.setSnack2(cell[3]);
            mealplan.setDinner(cell[4]);
            mealplan.setSnack3(cell[5]);
            mealplan.setNotes(cell[6]);
			reader.close();			
		}
		catch(FileNotFoundException f) {
			System.out.println("File not found");
		}
		catch(IOException e) {
			System.out.println("IO exception");
		}
		return mealplan;
	
	}


}