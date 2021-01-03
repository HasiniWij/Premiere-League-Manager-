package ConsoleApplication;

public class UniversityFootballClub extends FootballClub {
    private String universityName;
    public UniversityFootballClub(String name, String universityName,String location){
        super(name,location);
        this.universityName=universityName;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }
}
