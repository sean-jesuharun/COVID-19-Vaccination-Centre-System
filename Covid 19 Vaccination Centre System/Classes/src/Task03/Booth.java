package Task03;

public class Booth {

    private int boothNum;
    private Patient patientObject;

    //Overloaded Constructor....
    public Booth(int boothNum){
        this.boothNum = boothNum;
    }

    public int getBoothNum() {
        return boothNum;
    }

    public void setBoothNum(int boothNum) {
        this.boothNum = boothNum;
    }

    public Patient getPatientObject() {
        return patientObject;
    }

    public void setPatientObject(Patient patientObject) {
        this.patientObject = patientObject;
    }


    public void addPatientToABooth(Patient patient){
        this.patientObject = patient;
        System.out.println("\"" + this.patientObject.getFirstName() + "\"" + " has been successfully added to booth " + this.boothNum);
    }

    public void removePatientFromABooth(String patientName){
        this.patientObject = null;
        System.out.println("\"" + patientName + "\"" + " has been successfully removed from booth " + this.boothNum);
    }
}

