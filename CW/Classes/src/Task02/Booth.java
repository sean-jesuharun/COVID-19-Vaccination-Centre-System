package Task02;

public class Booth {

    private int boothNum;
    private String patientName;

    //Overloaded Constructor....
    public Booth(int boothNum, String patientName){
        this.boothNum = boothNum;
        this.patientName = patientName;
    }

    public int getBoothNum() {
        return boothNum;
    }

    public void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }


    public void addPatientToABooth(String patientName){
        this.patientName = patientName;
        System.out.println("\"" + patientName + "\"" + " has been successfully added to booth " + this.boothNum);
    }

    public void removePatientFromABooth(String patientName){
        this.patientName = "e";
        System.out.println("\"" + patientName + "\"" + " has been successfully removed from booth " + this.boothNum);
    }
}

