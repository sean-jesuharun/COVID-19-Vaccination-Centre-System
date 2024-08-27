package Task03;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Arrays_Version_Extended {

    //Making the array Static so Each Static methods can access it.....
    static String[] serviceCenterBooths = new String[6];

    //Parallel Arrays to hold relationship between indexes of each arrays....
    static String[] firstNameArray = new String[6];
    static String[] surNameArray = new String[6];
    static String[] vaccinationRequestArray = new String[6];

    static int stocks = 150;
    static Scanner myScanner = new Scanner(System.in);

    public static void main(String[] args){
        // Initialising the ServiceCenterbooths as "e" This means that every booth is empty initially.....
        initialise();

        //Menu Options
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
        while (true) {

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
                addPatientToABooth();
            }
            else if (operation.equals("103") || operation.equals("RPB"))
            {
                removePatientFromABooth();
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

    private static void initialise(){
        // Initialising the ServiceCenterbooths as "e" This means that every booth is empty initially.....
        for (int i = 0; i < serviceCenterBooths.length; i++)
        {
            serviceCenterBooths[i] = "e";
        }
    }

    private static void viewAllVaccinationBooths(){

        for (int i = 0; i < serviceCenterBooths.length; i++)
        {
            if (!serviceCenterBooths[i].equals("e"))
            {
                System.out.println("Booth " + i + " is occupied by " + serviceCenterBooths[i]);

            }
            else{
                System.out.println("Booth " + i + " is empty.");
            }
        }

    }

    private static void viewAllEmptyBooths(){
        //Making a boolean called "flag" to check whether atleast one booth is being empty...
        boolean flag = true;
        for (int i = 0; i < serviceCenterBooths.length; i++)
        {
            if (serviceCenterBooths[i].equals("e"))
            {
                System.out.println("Booth " + i + " is Empty.");
                flag = false;
            }
        }
        if (flag)
        {
            System.out.println("Currently All Booths are Occupied.");
        }
    }

    private static void addPatientToABooth(){

        while (true) {

            //Making a boolean called "flag" to check whether atleast one booth is being empty to add a patient...
            boolean flag = true;
            for (int i = 0; i < serviceCenterBooths.length; i++)
            {
                if (serviceCenterBooths[i].equals("e"))
                {
                    flag = false;
                }
            }
            if (flag)
            {
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

            if (VaccinationRequest == 1){

                //Making a boolean called "flag1" to check whether atleast one booth that Allocated to Provide "AstraZeneca" vaccine is being empty...
                boolean flag1 = true;
                for (int i = 0; i < 2; i++)
                {
                    if (serviceCenterBooths[i].equals("e"))
                    {
                        flag1 = false;
                        firstNameArray[i] = FirstName;
                        surNameArray[i] = SurName;
                        vaccinationRequestArray[i] = "AstraZeneca";
                        serviceCenterBooths[i] = FirstName;
                        System.out.println("\"" + serviceCenterBooths[i] + "\"" + " has been successfully added to booth " + i);
                        stocks--;
                        break;
                    }
                }
                if (flag1) {
                    System.out.println("The Booths that allocated to provide \" AstraZeneca \" vaccine [Booth 0 and Booth 1] are currently busy...");
                }
            }
            else if (VaccinationRequest == 2){

                //Making a boolean called "flag2" to check whether atleast one booth that Allocated to Provide "Sinopharm" vaccine is being empty...
                boolean flag2 = true;
                for (int i = 2; i < 4; i++)
                {
                    if (serviceCenterBooths[i].equals("e"))
                    {
                        flag2 = false;
                        firstNameArray[i] = FirstName;
                        surNameArray[i] = SurName;
                        vaccinationRequestArray[i] = "Sinopharm";
                        serviceCenterBooths[i] = FirstName;
                        System.out.println("\"" + serviceCenterBooths[i] + "\"" + " has been successfully added to booth " + i);
                        stocks--;
                        break;
                    }
                }
                if (flag2) {
                    System.out.println("The Booths that allocated to provide \" Sinopharm \" vaccine [Booth 2 and Booth 3] are currently busy...");
                }
            }
            else if (VaccinationRequest == 3){

                //Making a boolean called "flag3" to check whether atleast one booth that Allocated to Provide "Pfizer" vaccine is being empty...
                boolean flag3 = true;
                for (int i = 4; i < 6; i++)
                {
                    if (serviceCenterBooths[i].equals("e"))
                    {
                        flag3 = false;
                        firstNameArray[i] = FirstName;
                        surNameArray[i] = SurName;
                        vaccinationRequestArray[i] = "Pfizer";
                        serviceCenterBooths[i] = FirstName;
                        System.out.println("\"" + serviceCenterBooths[i] + "\"" + " has been successfully added to booth " + i);
                        stocks--;
                        break;
                    }
                }
                if (flag3) {
                    System.out.println("The Booths that allocated to provide \" Pfizer \" vaccine [Booth 2 and Booth 3] are currently busy...");
                }
            }
            if (stocks == 20) {
                System.out.println();
                System.out.println("WARNING !!! ...... There are only " + stocks + " vaccinations remaining....");
            }
            break;
        }
    }

    private static void removePatientFromABooth(){

        while(true) {

            //Making a boolean called "flag" to check whether atleast one booth is not being empty...
            boolean flag = true;
            for (int i = 0; i < serviceCenterBooths.length; i++)
            {
                if (!serviceCenterBooths[i].equals("e"))
                {
                    flag = false;
                }
            }
            if (flag)
            {
                System.out.println("Can't remove patients because all the 6 Booths are currently being Empty.");
                break;
            }

            //Giving operator an idea about from where he can remove patients by showing him the currently occupied booths...
            System.out.println();
            System.out.println("Currently Occupied booths are: ");
            for (int i = 0; i < serviceCenterBooths.length; i++) {
                if (!serviceCenterBooths[i].equals("e")) {
                    System.out.println("Booth " + i + " is Occupied by " + "\"" + serviceCenterBooths[i] + "\"");
                }
            }

            System.out.println();
            System.out.print("From which Booth you want to remove the patient [Enter a Booth Number from 0 to 5] : ");
            int boothnum = myScanner.nextInt();

            if (!serviceCenterBooths[boothnum].equals("e")) {
                String patientName = serviceCenterBooths[boothnum];
                serviceCenterBooths[boothnum] = "e";
                System.out.println("\"" + patientName + "\"" + " has been successfully removed from booth " + boothnum);

                firstNameArray[boothnum] = null;
                surNameArray[boothnum] = null;
                vaccinationRequestArray[boothnum] = null;
                break;
            } else {
                System.out.println("The Booth is already being Empty...");
            }
        }
    }

    private static void viewPatientsSortedInAlphabeticalOrder(){

        //Making a boolean called "flag" to check whether atleast one booth is not being empty...
        while (true) {
            boolean flag = true;
            for (int i = 0; i < serviceCenterBooths.length; i++) {
                if (!serviceCenterBooths[i].equals("e")) {
                    flag = false;
                }
            }
            if (flag) {
                System.out.println("Can't sorted patients names because all the 6 Booths are Empty.");
                break;
            }

            //Copying elements from serviceCenterBooths Array to sortedNames array because changes won't affect serviceCenterBooth array...
            String[] sortedNames = new String[6];
            for (int i = 0; i < sortedNames.length; i++)
            {
                sortedNames[i] = serviceCenterBooths[i];
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
            File patientFileTask1Extended = new File("patientFileTask1Extended.txt");
            patientFileTask1Extended.createNewFile();

            FileWriter myWriter = new FileWriter("patientFileTask1Extended.txt");
            for (int i = 0; i < serviceCenterBooths.length; i++)
            {
                if (!serviceCenterBooths[i].equals("e")) {
                    myWriter.write(firstNameArray[i] + " ");
                    myWriter.write(surNameArray[i] + " ");
                    myWriter.write(vaccinationRequestArray[i] + "\n");
                }
                else{
                    myWriter.write("empty" + "\n");
                }
            }
            myWriter.close();

            System.out.println("Patient details have been Successfully Stored in \" patientFileTask1Extended \" TextFile..");

        }
        catch (IOException e){
            System.out.println("An Error has occurred");
        }

    }

    private static void loadProgramDataFromFile(){

        try{
            File PatientFile2 = new File("patientFileTask1Extended.txt");
            Scanner myReader = new Scanner(PatientFile2);

            while (myReader.hasNextLine())
            {
                for (int i = 0; i < serviceCenterBooths.length; i++)
                {
                    String data = myReader.nextLine();
                    if (data.equals("empty")){
                        firstNameArray[i] = null;
                        surNameArray[i] = null;
                        vaccinationRequestArray[i] = null;
                        serviceCenterBooths[i] = "e";
                        continue;
                    }

                    //Creating an array called "dataArray" with all the Patient details as its elements...
                    String[] dataArray = data.split(" ");
                    firstNameArray[i] = dataArray[0];
                    surNameArray[i] = dataArray [1];
                    vaccinationRequestArray[i] = dataArray[2];
                    serviceCenterBooths[i] = dataArray[0];
                }
            }

            System.out.println("Patient details have been Successfully loaded from the \" patientFileTask1Extended \" TextFile..");
        }
        catch(FileNotFoundException e){
            System.out.println("File not found..");
        }
    }

    private static void viewRemainingVaccinations(){
        System.out.println("The remaining vaccinations are : " + stocks);
    }

    private static void addVaccinationsToTheStock(){

        System.out.print("How many vaccinations that you gonna add to the Stocks: ");
        int vaccinationnumber = myScanner.nextInt();

        stocks = stocks + vaccinationnumber;
        System.out.println(vaccinationnumber + " vaccinations has been successfully added to stocks");
    }

}


