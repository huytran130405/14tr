import java.util.*;


public class PassmgerManagement {

    private File fileHandler;
    private Scanner scanner;
    private List<Passenger> passengers;
    private final String filePath = "src/passenger.csv";

    public PassmgerManagement(File fileHandler, Scanner scanner){
        this.fileHandler = fileHandler;
        this.scanner = scanner;
        this.passengers = new ArrayList<>();
        fileHandler.loadPassengerfromFile(passengers);
    }

    public void addPassenegr(){
        String Id = readInput("Enter the Team ID: ").trim();
        if (passengers.indexOf(Id) == -1) {
            System.out.println("No team found with the given ID.");
            return;
        }
        if(Id.matches("[0-9]") || Id.isEmpty()) {
            System.out.println("please enter id: ");
            return;
        }
        String Name = readInput("Enter Passenger ID: ").trim();
        if (Name.isEmpty()) {
            System.out.println("Name of passenger not be empty");
            return;
        }
        int Age = Integer.parseInt(readInput("Enter age: "));
        if(Age <= 0){
            System.out.println("Age can not be smaller 0: ");
            return;
        }
        String Gender =readInput("Enter gender: ").trim();
        if (Gender.isEmpty()) {
            System.out.println("Gender of passenger not be empty");
            return;
        }
        String PhoneNumber = readInput("Enter phonenumber: ").trim();
        if (PhoneNumber.isEmpty()) {
            System.out.println("phonenumber of passenger not be empty");
            return;
        }



    }

    private String readInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}
