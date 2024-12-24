import java.io.*;
import java.util.*;

public class File {
    private static final String filePassenger = "passenger.csv";


    protected void checkExistFile(String fileName) {
        java.io.File file = new java.io.File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist. Creating a new file.");
            try {
                if (file.createNewFile()) {
                    System.out.println("File created.");
                } else {
                    System.out.println("Failed to create file.");
                }
            } catch (IOException e) {
                System.out.println("Error creating file: " + e.getMessage());
            }
        }
    }

    public void saveAircrewToFile(List<Passenger> passengers) {
        checkExistFile(filePassenger);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePassenger))) {
            for (Passenger passenger : passengers.val()) {
                writer.write(passenger.toCsvString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    protected void loadPassengerfromFile(List<Passenger>passengers) {
        checkExistFile(filePassenger);
        try (BufferedReader reader = new BufferedReader(new FileReader(filePassenger))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    int age = Integer.parseInt(parts[2].trim());
                    String gender = parts[3].trim();
                    String phone = parts[4].trim();
                    Passenger passenger = new Passenger(id, name, age, gender, phone);
                    passengers.add(passenger);
                }
            }
        }
        catch (IOException e){
            System.out.println("Error reading file: " + e.getMessage());
        }
        catch (NumberFormatException e){
            System.out.println("Error parsing age: " + e.getMessage());
        }
    }
}
