
package coe318.lab7;

public class Truck  extends Vehicle {
    private double loadCapacityInTons;

    public Truck(String plateNumber, String model, int year, double loadCapacityInTons) {
      super(plateNumber, model, year);
      this.loadCapacityInTons = loadCapacityInTons;
    }

    public double getLoadCapacityInTons() {
        return loadCapacityInTons;
    }

    @Override
    public String toString() {
        return "Truck: " + super.toString() +
               " [Capacity: " + loadCapacityInTons + " tons]";
    }

    @Override
    public double calculateRentalPrice(int days) {
        // TO DO  when a daily rate starts at 90 dollars and increases by 10 dollars for each ton of load capacity.
        return (90 + 10*loadCapacityInTons)*days;
    }

    @Override
    public double calculateInsurancePremium(int days) {
       // TO Do: the daily rate is the base insurance rate increased by 50 percent
       return getBaseInsuranceRate() * 1.50 * days;
    }

    public static void printVehicleType() {
        System.out.println("Truck");
    }
    
}