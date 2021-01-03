package ConsoleApplication;

public class SchoolFootballClubs extends FootballClub {
    private String schoolName;
    public SchoolFootballClubs(String name, String schoolName,String location){
        super(name,location);
        this.schoolName=schoolName;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}
