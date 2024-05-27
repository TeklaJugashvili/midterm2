public class Test {

    public static void main(String[] args) {
        TransportationCompany company = new TransportationCompany();

        Vehicle car1 = new Vehicle("Toyota", "Prius", 2018);
        Vehicle car2 = new Vehicle("Ford", "Mustang", 2021);
        company.addVehicle(car1);
        company.addVehicle(car2);

        System.out.println("All Vehicles:");
        company.displayVehicles();

        company.saveState("state.csv");

        company.restoreState("state.csv");

        System.out.println("\nRestored Vehicles:");
        company.displayVehicles();
    }
}
