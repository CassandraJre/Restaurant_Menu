public class Employee extends Person{
    private int yearHired;
    private String position;
    private double wage;
    private int weeklyHours;

    //Employee constructor
    public Employee(String firstName, String lastName, String phoneNumber, int yearHired,
                    String position, double wage, int weeklyHours) {
       super(firstName, lastName, phoneNumber);
        this.yearHired = yearHired; 
        this.position = position;
        this.wage = wage;
        this.weeklyHours = weeklyHours;
    }

    //Getters for all the variables
    public int getYearHired() { 
        return yearHired;
     }
    public String getPosition() { 
        return position;
     }
    public double getWage() { 
        return wage; 
    }
    public int getWeeklyHours() { 
        return weeklyHours; 
    }
}
