package Task03;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VaccinationCenter {

    static Booth[] boothObjectsArray = new Booth[6];
    static int stocks = 150;
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){

        //Initialized 6 booth objects in the boothObjectArray with boothNum and "e"....
        for (int i = 0; i < boothObjectsArray.length; i++)
        {
            boothObjectsArray[i] = new Booth(i);
        }

        //Menu Options....
        System.out.println
                (
                        "100 0r VVB : View all Vaccination Booths \n" +
                                "101 or VEB : View all Empty Booths \n" +
                                "102 or APB : Add Patient to a Booth \n" +
                                "103 or RPB : Remove Patient from a Booth \n" +
                                "104 or VPS : View Patients Sorted in alphabetical order \n" +
                                "105 or SPD : Store Program Data into file \n" +
                                "106 or LPD : Load Program Data from file \n" +
                                "107 or VRV : View Remaining Vaccinations \n" +
                                "108 or AVS : Add Vaccinations to the Stock \n" +
                                "999 or EXT : Exit the Program"
                );

        while (true){

            System.out.println();
            System.out.print("Select the task from the menu : ");
            String operation = myScanner.next();

            //operations begins here
            if (operation.equals("100") || operation.equals("VVB"))
            {
                viewAllVaccinationBooths();
            }
            else if (operation.equals("101") || operation.equals("VEB"))
            {
                viewAllEmptyBooths();
            }
            else if (operation.equals("102") || operation.equals("APB"))
            {
                addDetails();
            }
            else if (operation.equals("103") || operation.equals("RPB"))
            {
                removeDetails();
            }
            else if (operation.equals("104") || operation.equals("VPS"))
            {
                viewPatientsSortedInAlphabeticalOrder();
            }
            else if (operation.equals("105") || operation.equals("SPD"))
            {
                storeProgramDataIntoFile();
            }
            else if (operation.equals("106") || operation.equals("LPD"))
            {
                loadProgramDataFromFile();
            }
            else if (operation.equals("107") || operation.equals("VRV"))
            {
                viewRemainingVaccinations();
            }
            else if (operation.equals("108") || operation.equals("AVS"))
            {
                addVaccinationsToTheStock();
            }
            else if (operation.equals("999") || operation.equals("EXT"))
            {
                System.out.println("The program is Exiting.....");
                break;
            }
            else{
                System.out.println("Enter the correct value for the TASK...");
            }
        }
    }

    private static void viewAllVaccinationBooths(){

        for (int i = 0; i < boothObjectsArray.length; i++)
        {
            if (boothObjectsArray[i].getPatientObject() == null)
            {
                System.out.println("Booth " + boothObjectsArray[i].getBoothNum() + " is Empty");
            }
            else
            {
                System.out.println("Booth " + boothObjectsArray[i].getBoothNum() + " is Occupied by " + "\"" + boothObjectsArray[i].getPatientObject().getFirstName() + "\"");
            }

        }
    }

    private static void viewAllEmptyBooths(){
        //Making a boolean called "flag" to check whether atleast one booth is being empty...
        boolean flag = true;
        for (int i = 0; i < boothObjectsArray.length; i++)
        {
            if (boothObjectsArray[i].getPatientObject() == null)
            {
                System.out.println("Booth " + boothObjectsArray[i].getBoothNum() + " is Empty");
                flag = false;
            }
        }
        if (flag)
        {
            System.out.println("Currently All Booths are Occupied.");
        }
    }

    private static void addDetails(){

        //Making a boolean called "flag" to check whether atleast one booth is being empty to add a patient...
        while (true) {
            boolean flag = true;
            for (int i = 0; i < boothObjectsArray.length; i++) {
                if (boothObjectsArray[i].getPatientObject() == null) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Can't add patients because all the 6 Booths have been occupied.");
                break;
            }

            System.out.println();
            System.out.println("Booth Allocation Details...");
            System.out.println
                    (
                            "Booth 0 and Booth 1 FOR : \" AstraZeneca \" \n" +
                                    "Booth 2 and Booth 3 FOR : \" Sinopharm \" \n" +
                                    "Booth 4 and Booth 5 FOR : \" Pfizer \" "
                    );

            System.out.println();
            System.out.print("Patient Details....");
            System.out.println();

            System.out.print("First Name          : ");
            String FirstName = myScanner.next();

            System.out.print("Sur Name            : ");
            String SurName = myScanner.next();

            System.out.print("Age                 : ");
            int Age = myScanner.nextInt();

            System.out.print("City                : ");
            String City = myScanner.next();

            System.out.print("NIC/Passport Number : ");
            String NICorPassport = myScanner.next();

            System.out.println();
            System.out.println("Vaccine List is follows..");
            System.out.println();

            System.out.println
                    (
                            "For AstraZeneca Press 1 \n" +
                                    "For Sinopharm Press 2 \n" +
                                    "For Pfizer Press 3"
                    );
            System.out.println();
            System.out.print("Which Vaccine you prefer to get : ");
            int VaccinationRequest = myScanner.nextInt();

            while (true) {
                if (VaccinationRequest == 1) {

                    //Making a boolean called "flag1" to check whether atleast one booth that Allocated to Provide "AstraZeneca" vaccine is being empty...
                    boolean flag1 = true;
                    for (int i = 0; i < boothObjectsArray.length; i++) {
                        if ((boothObjectsArray[i].getBoothNum() == 0) || (boothObjectsArray[i].getBoothNum() == 1)) {
                            if (boothObjectsArray[i].getPatientObject() == null) {

                                flag1 = false;

                                boothObjectsArray[i].addPatientToABooth(new Patient(FirstName, SurName, Age, City, NICorPassport, VaccinationRequest));
                                stocks--;
                                break;
                            }

                        }
                    }

                    if (flag1) {
                        System.out.println("The Booths that allocated to provide \" AstraZeneca \" vaccine [Booth 0 and Booth 1] are currently busy...");
                        System.out.println();
                        System.out.print("Do you prefer to go for other vaccination? if yes press \" y \" else press \" n \" : ");
                        String checker = myScanner.next();

                        if (checker.equals("y")) {
                            System.out.println();
                            System.out.println
                                    (
                                            "For Sinopharm Press 2 \n" +
                                                    "For Pfizer Press 3"
                                    );
                            System.out.println();
                            System.out.print("Which Vaccine you prefer to get : ");
                            VaccinationRequest = myScanner.nextInt();
                            continue;
                        } else if (checker.equals("n")) {
                            System.out.println("Sorry...You have to wait until the booths are getting empty and Register yourself again");
                        }
                    }
                    break;

                }
                else if (VaccinationRequest == 2) {

                    //Making a boolean called "flag2" to check whether atleast one booth that Allocated to Provide "Sinopharm" vaccine is being empty...
                    boolean flag2 = true;
                    for (int i = 0; i < boothObjectsArray.length; i++) {
                        if ((boothObjectsArray[i].getBoothNum() == 2) || (boothObjectsArray[i].getBoothNum() == 3)) {
                            if (boothObjectsArray[i].getPatientObject() == null) {
                                flag2 = false;

                                boothObjectsArray[i].addPatientToABooth(new Patient(FirstName, SurName, Age, City, NICorPassport, VaccinationRequest));
                                stocks--;
                                break;
                            }

                        }
                    }
                    if (flag2) {
                        System.out.println("The Booths that allocated to provide \" Sinopharm \" vaccine [Booth 2 and Booth 3] are currently busy...");
                        System.out.println();
                        System.out.print("Do you prefer to go for other vaccination? if yes press \" y \" else press \" n \" : ");
                        String checker = myScanner.next();

                        if (checker.equals("y"))
                        {
                            System.out.println();
                            System.out.println
                                    (
                                            "For AstraZeneca Press 1 \n" +
                                                    "For Pfizer Press 3"
                                    );
                            System.out.println();
                            System.out.print("Which Vaccine you prefer to get : ");
                            VaccinationRequest = myScanner.nextInt();
                            continue;
                        }
                        else if (checker.equals("n"))
                        {
                            System.out.println("Sorry...You have to wait until the booths are getting empty and Register yourself again");
                        }
                    }
                    break;
                }
                else if (VaccinationRequest == 3) {

                    //Making a boolean called "flag3" to check whether atleast one booth that Allocated to Provide "Pfizer" vaccine is being empty...
                    boolean flag3 = true;
                    for (int i = 0; i < boothObjectsArray.length; i++) {
                        if ((boothObjectsArray[i].getBoothNum() == 4) || (boothObjectsArray[i].getBoothNum() == 5)) {
                            if (boothObjectsArray[i].getPatientObject() == null) {
                                flag3 = false;

                                boothObjectsArray[i].addPatientToABooth(new Patient(FirstName, SurName, Age, City, NICorPassport, VaccinationRequest));
                                stocks--;
                                break;
                            }

                        }
                    }
                    if (flag3) {
                        System.out.println("The Booths that allocated to provide \" Pfizer \" vaccine [Booth 4 and Booth 5] are currently busy...");
                        System.out.println();
                        System.out.print("Do you prefer to go for other vaccination? if yes press \" y \" else press \" n \" : ");
                        String checker = myScanner.next();

                        if (checker.equals("y"))
                        {
                            System.out.println();
                            System.out.println
                                    (
                                            "For AstraZeneca Press 1 \n" +
                                                    "For Sinopharm Press 2"
                                    );
                            System.out.println();
                            System.out.print("Which Vaccine you prefer to get : ");
                            VaccinationRequest = myScanner.nextInt();
                            continue;
                        }
                        else if (checker.equals("n"))
                        {
                            System.out.println("Sorry...You have to wait until the booths are getting empty and Register yourself again");
                        }
                    }
                    break;
                }
            }
            if (stocks == 20) {
                System.out.println();
                System.out.println("WARNING !!! ...... There are only " + stocks + " vaccinations remaining....");
            }
            break;
        }
    }

    private static void removeDetails(){

        while (true) {
            //Making a boolean called "flag" to check whether atleast one booth is not being empty...
            boolean flag = true;
            for (int i = 0; i < boothObjectsArray.length; i++) {
                if (!(boothObjectsArray[i].getPatientObject() == null)) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Can't remove patients because all the 6 Booths are currently being Empty.");
                break;
            }

            System.out.println();
            System.out.println("Currently Occupied booths are: ");
            for (int i = 0; i < boothObjectsArray.length; i++) {
                if (!(boothObjectsArray[i].getPatientObject() == null)) {
                    System.out.println("Booth " + boothObjectsArray[i].getBoothNum() + " is Occupied by " + "\"" + boothObjectsArray[i].getPatientObject().getFirstName() + "\"");
                }
            }

            //Giving operator an idea about from where he can remove patients by showing him the currently occupied booths...
            System.out.println();
            System.out.print("From which Booth you want to remove the patient [Enter a Booth Number from 0 to 5] : ");
            int boothNumber = myScanner.nextInt();

            //BoothNum and index of Booth Objects in boothObjectArray are same.. so It can be done easily....
            if (!(boothObjectsArray[boothNumber].getPatientObject() == null)) {
                String name = boothObjectsArray[boothNumber].getPatientObject().getFirstName();
                boothObjectsArray[boothNumber].removePatientFromABooth(name);
                break;
            } else {
                System.out.println("This Booth is already being empty....");
            }
        }
    }

    private static void viewPatientsSortedInAlphabeticalOrder(){

        while (true) {
            //Making a boolean called "flag" to check whether atleast one booth is not being empty...
            boolean flag = true;
            for (int i = 0; i < boothObjectsArray.length; i++) {
                if (!(boothObjectsArray[i].getPatientObject() == null)) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Can't sorted patients names because all the 6 Booths are Empty.");
                break;
            }

            //Making an array called "sortedNames" which contains boothObjectsArray patients names...
            String[] sortedNames = new String[6];
            for (int i = 0; i < sortedNames.length; i++)
            {
                if (!(boothObjectsArray[i].getPatientObject() == null)) {
                    sortedNames[i] = boothObjectsArray[i].getPatientObject().getFirstName();
                }
                else{
                    sortedNames[i] = "e";
                }
            }

            //To hold Temporary Values....
            String temporaryString;
            for (int i = 0; i < sortedNames.length; i++) {
                for (int j = i + 1; j < sortedNames.length; j++)
                {
                    if (sortedNames[i].compareToIgnoreCase(sortedNames[j]) > 0) {
                        temporaryString = sortedNames[i];
                        sortedNames[i] = sortedNames[j];
                        sortedNames[j] = temporaryString;
                    }
                }
            }

            System.out.println("And The Names Sorted in Alphabetical Order Are As Follows...");

            for (int i = 0; i < sortedNames.length; i++)
            {
                if (!sortedNames[i].equals("e")) {
                    System.out.println(sortedNames[i]);
                }
            }
            break;
        }
    }

    private static void storeProgramDataIntoFile(){

        try {
            File patientFileTask2Extended = new File("patientFileTask2Extended.txt");
            patientFileTask2Extended.createNewFile();

            FileWriter myWriter = new FileWriter("patientFileTask2Extended.txt");
            for (int i = 0; i < boothObjectsArray.length; i++)
            {
                if (!(boothObjectsArray[i].getPatientObject() == null)) {
                    myWriter.write(boothObjectsArray[i].getPatientObject().getFirstName() + " ");
                    myWriter.write(boothObjectsArray[i].getPatientObject().getSurName() + " ");
                    myWriter.write(boothObjectsArray[i].getPatientObject().getAge() + " ");
                    myWriter.write(boothObjectsArray[i].getPatientObject().getCity() + " ");
                    myWriter.write(boothObjectsArray[i].getPatientObject().getNICorPassport() + " ");
                    myWriter.write(boothObjectsArray[i].getPatientObject().getVaccinationRequest() + "\n");
                }
                else{
                    myWriter.write("empty" + "\n");
                }
            }
            myWriter.close();

            System.out.println("Patient Details have been Successfully Stored in \" patientFileTask2Extended \" TextFile...");

        }
        catch (IOException e){
            System.out.println("An Error has occurred");
        }
    }

    private static void loadProgramDataFromFile(){

        try{
            File PatientFile2 = new File("patientFileTask2Extended.txt");
            Scanner myReader = new Scanner(PatientFile2);

            while (myReader.hasNextLine())
            {
                for (int i = 0; i < boothObjectsArray.length; i++)
                {
                    String data = myReader.nextLine();
                    if (data.equals("empty")){
                        boothObjectsArray[i].setPatientObject(null);
                        continue;
                    }

                    //Creating an array with all the Patient attribute...
                    String[] dataArray = data.split(" ");

                    //setting up the attributes in the same place....
                    boothObjectsArray[i].setPatientObject(new Patient(dataArray[0],dataArray[1],Integer.parseInt(dataArray[2]),dataArray[3],dataArray[4],Integer.parseInt(dataArray[5])));

                }
            }

            System.out.println("Patient Details have been Successfully loaded from the \" patientFileTask2Extended \" TextFile...");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found..");
        }

    }

    private static void viewRemainingVaccinations() {
        System.out.println("The remaining vaccinations are : " + stocks);
    }

    private static void addVaccinationsToTheStock(){

        System.out.print("How many vaccinations that you gonna add to the Stocks: ");
        int vaccinationnumber = myScanner.nextInt();

        stocks = stocks + vaccinationnumber;
        System.out.println(vaccinationnumber + " vaccinations has been successfully added to stocks");
    }
}

