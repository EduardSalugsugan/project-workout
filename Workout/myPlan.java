
public class myPlan {
    String breakfast;
    String snack1;
    String lunch;
    String snack2;
    String dinner;
    String snack3;
    String notes;

    public myPlan(){
        breakfast = "";
        snack1 = "";
        lunch = "";
        snack2 = "";
        dinner = "";
        snack3 = "";
        notes = "";
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

}