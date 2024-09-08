package Task03;

public class Patient {

    private String firstName;
    private String surName;
    private int age;
    private String city;
    private String NICorPassport;
    private int vaccinationRequest;

    //Overloaded Constructor....
    public Patient (String firstName, String surName, int age, String city, String NICorPassport, int vaccinationRequest){
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
        this.city = city;
        this.NICorPassport = NICorPassport;
        this.vaccinationRequest = vaccinationRequest;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNICorPassport() {
        return NICorPassport;
    }

    public void setNICorPassport(String NICorPassport) {
        this.NICorPassport = NICorPassport;
    }

    public int getVaccinationRequest() {
        return vaccinationRequest;
    }

    public void setVaccinationRequest(int vaccinationRequest) {
        this.vaccinationRequest = vaccinationRequest;
    }
}

