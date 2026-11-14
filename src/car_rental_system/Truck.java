package car_rental_system;

public class Truck extends Vehicle {
    private double loadCapacityInTons;

    public Truck(String plateNumber, String model, int year, double loadCapacityInTons) {
        // call superclass constructor and set field
        super(plateNumber, model, year);
        this.loadCapacityInTons = loadCapacityInTons;
    }

    public double getLoadCapacityInTons() {
        return loadCapacityInTons;
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString()
                + " [Capacity: " + loadCapacityInTons + " tons]";
    }

    @Override
    public double calculateRentalPrice(int days) {
        // Daily rate starts at 90 and increases by 10 for each ton
        double dailyRate = 90.0 + 10.0 * loadCapacityInTons;
        return dailyRate * days;
    }

    @Override
    public double calculateInsurancePremium(int days) {
        // Daily insurance = base insurance rate increased by 50%
        double dailyInsurance = getBaseInsuranceRate() * 1.50;
        return dailyInsurance * days;
    }

    public static void printVehicleType() {
        System.out.println("Truck");
    }
}
