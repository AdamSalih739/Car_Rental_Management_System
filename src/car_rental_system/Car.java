
package coe318.lab7;

public class Car extends Vehicle {
    private boolean automatic;

    public Car(String plateNumber, String model, int year, boolean automatic) {
        // TO DO
        super(plateNumber, model, year);
        this.automatic = automatic;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    // Overriding toString
    @Override
    public String toString() {
        return "Car: " + super.toString() +
               (automatic ? " [Automatic]" : " [Manual]");
    }

    
    @Override
    public double calculateRentalPrice(int days) {
        //TO DO. complete the code such that Daily Rate for automatic cars are 65.0 an for non automatic cars are 55.0. 
        if (automatic) {
            return 65.0*days;
        } else {
            return 55.0*days;
        }
    }

  
    @Override
    public double calculateInsurancePremium(int days) {
        // TO DO. complete the code, such that daily insurence rate to be the vehicle’s base, increased by 10%
        return getBaseInsuranceRate()*1.10 * days;
    }


    // Overloaded version with GPS option
    public double calculateRentalPrice(int days, boolean gpsIncluded) {
        double base = calculateRentalPrice(days);
        if (gpsIncluded) {
            base += 10.0 * days; // GPS daily fee
        }
        return base;
    }

    // Static method HIDING superclass static method
    public static void printVehicleType() {
        System.out.println("Car");
    }
    
}
