package car_rental_system;

public class RentalContract {
    private Rentable rentable;
    private int days;
    private boolean insuranceAdded;

    public RentalContract(Rentable rentable, int days, boolean insuranceAdded) {
        this.rentable = rentable;
        this.days = days;
        this.insuranceAdded = insuranceAdded;
    }

    public double calculateTotalPrice() {
        // TO DO  ➜ completed
        // Base price uses the Rentable's own implementation (polymorphism)
        double basePrice = rentable.calculateRentalPrice(days);
        double insurance = 0.0;

        if (insuranceAdded) {
            // Cast to Insurable to access insurance calculation
            insurance = ((Insurable) rentable).calculateInsurancePremium(days);
        }

        return basePrice + insurance;
    }

    public void printSummary() {
        System.out.println("=== Rental Contract Summary ===");
        System.out.println("Vehicle type: " + rentable.getClass().getSimpleName());
        System.out.println("Days: " + days);
        System.out.println("Insurance added: " + insuranceAdded);
        System.out.println("Total price: " + calculateTotalPrice());
        System.out.println("===============================");
    }
}
