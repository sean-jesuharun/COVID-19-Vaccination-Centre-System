package Task02;

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
            boothObjectsArray[i] = new Booth(i,"e");
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
            if (boothObjectsArray[i].getPatientName().equals("e"))
            {
                System.out.println("Booth " + boothObjectsArray[i].getBoothNum() + " is Empty");
            }
            else
            {
                System.out.println("Booth " + boothObjectsArray[i].getBoothNum() + " is Occupied by " + "\"" + boothObjectsArray[i].getPatientName() + "\"");
            }

        }
    }

    private static void viewAllEmptyBooths(){
        //Making a boolean called "flag" to check whether atleast one booth is being empty...
        boolean flag = true;
        for (int i = 0; i < boothObjectsArray.length; i++)
        {
            if (boothObjectsArray[i].getPatientName().equals("e"))
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

        while (true) {
            //Making a boolean called "flag" to check whether atleast one booth is being empty to add a patient...
            boolean flag = true;
            for (int i = 0; i < boothObjectsArray.length; i++) {
                if (boothObjectsArray[i].getPatientName().equals("e")) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Can't add patients because all the 6 Booths have been occupied.");
                break;
            }

            //Giving operator an idea about where he can add patients by showing him the currently empty booths...
            System.out.println();
            System.out.println("Currently empty booth are: ");
            viewAllEmptyBooths();
            System.out.println();

            System.out.print("In which booth you want to add the patient [Enter a Booth Number from 0 to 5] : ");
            int boothNumber = myScanner.nextInt();

            //BoothNum and index of Booth Objects in boothObjectArray are same.. so It can be done easily....
            if (boothObjectsArray[boothNumber].getPatientName().equals("e")) {
                System.out.print("What is the name of the patient : ");
                String name = myScanner.next();

                boothObjectsArray[boothNumber].addPatientToABooth(name);
                stocks--;

                if (stocks == 20) {
                    System.out.println();
                    System.out.println("WARNING !!! ...... There are only " + stocks + " vaccinations remaining....");
                }
                break;
            } else
            {
                System.out.println("This booth has already been Occupied by " + "\"" + boothObjectsArray[boothNumber].getPatientName() + "\"");
            }
        }

    }

    private static void removeDetails(){

        while (true) {
            //Making a boolean called "flag" to check whether atleast one booth is not being empty...
            boolean flag = true;
            for (int i = 0; i < boothObjectsArray.length; i++) {
                if (!boothObjectsArray[i].getPatientName().equals("e")) {
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
                if (!boothObjectsArray[i].getPatientName().equals("e")) {
                    System.out.println("Booth " + boothObjectsArray[i].getBoothNum() + " is Occupied by " + "\"" + boothObjectsArray[i].getPatientName() + "\"");
                }
            }

            //Giving operator an idea about from where he can remove patients by showing him the currently occupied booths...
            System.out.println();
            System.out.print("From which Booth you want to remove the patient [Enter a Booth Number from 0 to 5] : ");
            int boothNumber = myScanner.nextInt();

            //BoothNum and index of Booth Objects in boothObjectArray are same.. so It can be done easily....
            if (!boothObjectsArray[boothNumber].getPatientName().equals("e")) {
                String name = boothObjectsArray[boothNumber].getPatientName();
                boothObjectsArray[boothNumber].removePatientFromABooth(name);
                break;
            } else {
                System.out.println("This Booth is already being empty....");
            }
        }
    }

    private static void viewPatientsSortedInAlphabeticalOrder(){

        //Making a boolean called "flag" to check whether atleast one booth is not being empty...
        while (true) {
            boolean flag = true;
            for (int i = 0; i < boothObjectsArray.length; i++) {
                if (!boothObjectsArray[i].getPatientName().equals("e")) {
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
                sortedNames[i] = boothObjectsArray[i].getPatientName();
            }

            //To hold Temporary Values....
            String temporaryString;
            for (int i = 0; i < sortedNames.length; i++) {
                for (int j = i + 1; j < sortedNames.length; j++)
                {
                    if (!sortedNames[i].equals("e") && !sortedNames[j].equals("e"))
                    {
                        if (sortedNames[i].compareToIgnoreCase(sortedNames[j]) > 0) {
                            temporaryString = sortedNames[i];
                            sortedNames[i] = sortedNames[j];
                            sortedNames[j] = temporaryString;
                        }
                    }
                }
            }

            System.out.println("And The Names Sorted in Alphabetical Order Are As Follows...");

            for (int i = 0; i < sortedNames.length; i++)
            {
                if(!sortedNames[i].equals("e"))
                {
                    System.out.println(sortedNames[i]);
                }
            }
            break;
        }
    }

    private static void storeProgramDataIntoFile(){

        try {
            File patientFileTask2 = new File("PatientFileTask2.txt");
            patientFileTask2.createNewFile();

            FileWriter myWriter = new FileWriter("PatientFileTask2.txt");
            for (int i = 0; i < boothObjectsArray.length; i++)
            {
                myWriter.write(boothObjectsArray[i].getPatientName()+ "\n");
            }
            myWriter.close();

            System.out.println("Patient names have been Successfully Stored in \" PatientFileTask2 \" TextFile..");

        }
        catch (IOException e){
            System.out.println("An Error has occurred");
        }
    }

    private static void loadProgramDataFromFile(){

        try{
            File PatientFile2 = new File("PatientFileTask2.txt");
            Scanner myReader = new Scanner(PatientFile2);

            while (myReader.hasNextLine())
            {
                for (int i = 0; i < boothObjectsArray.length; i++)
                {
                    String data = myReader.nextLine();
                    boothObjectsArray[i].setPatientName(data);

                }
            }

            System.out.println("Patient name have been Successfully loaded from the \" PatientFileTask2 \" TextFile");
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

