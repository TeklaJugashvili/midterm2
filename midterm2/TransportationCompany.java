import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TransportationCompany {
    private List<Vehicle> vehicles;

    public TransportationCompany() {
        this.vehicles = new ArrayList<>();
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void displayVehicles() {
        for (Vehicle vehicle : vehicles) {
            System.out.println("Make: " + vehicle.getMake());
            System.out.println("Model: " + vehicle.getModel());
            System.out.println("Year: " + vehicle.getYear());
            System.out.println("--------------------");
        }
    }

    public boolean removeVehicle(String make, String model, int year) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).getMake().equals(make) && vehicles.get(i).getModel().equals(model) && vehicles.get(i).getYear() == year) {
                vehicles.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean updateVehicle(String oldMake, String oldModel, int oldYear, String newMake, String newModel, int newYear) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getMake().equals(oldMake) && vehicle.getModel().equals(oldModel) && vehicle.getYear() == oldYear) {
                vehicle.setMake(newMake);
                vehicle.setModel(newModel);
                vehicle.setYear(newYear);
                return true;
            }
        }
        return false;
    }

    public void saveState(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Vehicle vehicle : vehicles) {
                writer.write(vehicle.getMake() + "," + vehicle.getModel() + "," + vehicle.getYear());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    public void restoreState(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            vehicles.clear();
    
            String line;
            while ((line = reader.readLine())!= null) {
                String[] parts = line.split(",");
                if (parts.length >= 3) {
                    String make = parts[0];
                    String model = parts[1];
                    int year = Integer.parseInt(parts[2]);
                    vehicles.add(new Vehicle(make, model, year));
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading from file: " + e.getMessage());
        }
    }
    
    
    
}
