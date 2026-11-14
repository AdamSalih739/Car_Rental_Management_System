# Car Rental System (Java / OOP)

A Java program that models a vehicle rental service using inheritance, interfaces, and polymorphism. It calculates rental prices and insurance premiums for different vehicle types and prints rental contract summaries. Built for COE 318 (Lab 7) at Toronto Metropolitan University.

## What's inside

- **Class hierarchy:** `Vehicle` is the base class, with `Car` and `Truck` as subclasses
- **Interfaces:** `Rentable` (pricing and rental lifecycle) and `Insurable` (insurance premiums)
- **Polymorphic pricing:** each vehicle type overrides rental price and insurance calculations
- **Rental contracts:** combine base rental price and optional insurance into a total cost
- **Java concepts demonstrated:** overriding, overloading, static method hiding, `final` methods, interface casting

## Project Structure

- `Insurable.java` → interface with `calculateInsurancePremium(int days)`
- `Rentable.java` → interface with `calculateRentalPrice`, `startRental`, `endRental`
- `Vehicle.java` → base class implementing both interfaces (default rate and insurance logic)
- `Car.java` → extends `Vehicle`, adds transmission type and a GPS-option overload
- `Truck.java` → extends `Vehicle`, adds load capacity
- `RentalContract.java` → calculates and prints the total price (rental + insurance)
- `RentalService.java` → entry point (`main`), logging, and rental processing

## Pricing Rules

| Vehicle | Daily rental rate | Daily insurance rate |
|---------|-------------------|----------------------|
| Vehicle (generic) | $100.00 | $20.00 (base rate) |
| Car (automatic) | $65.00 | base + 10% = $22.00 |
| Car (manual) | $55.00 | base + 10% = $22.00 |
| Car with GPS | rental rate + $10.00 | same as above |
| Truck | $90.00 + $10.00 per ton of capacity | base + 50% = $30.00 |

## Sample Results

| Vehicle | Days | Rental price ($) |
|---------|------|------------------|
| Toyota Corolla (automatic) | 3 | 195.00 |
| Volvo FH (12 ton truck) | 2 | 420.00 |
| BMW 7 Series (automatic) | 1 | 65.00 |
| Honda Civic (manual) | 1 | 55.00 |

Honda Civic (manual, 3 days): $165.00 without GPS, $195.00 with GPS.

Rental contracts with insurance:

| Vehicle | Days | Rental | Insurance | Total |
|---------|------|--------|-----------|-------|
| Toyota Corolla | 4 | 260.00 | 88.00 | 348.00 |
| BMW 7 Series | 2 | 130.00 | 44.00 | 174.00 |

### Example output

```
[INFO] Processing rental for Car
Starting rental for Car: 2020 Toyota Corolla (ABC-123) [Automatic]
Base rental price for 3 days: 195.0
Ending rental for Car: 2020 Toyota Corolla (ABC-123) [Automatic]

=== Rental Contract Summary ===
Vehicle type: Car
Days: 4
Insurance added: true
Total price: 348.0
===============================
```

## OOP Concepts Demonstrated

| Concept | Where |
|---------|-------|
| Inheritance | `Car` and `Truck` extend `Vehicle` |
| Interfaces | `Vehicle` implements `Rentable` and `Insurable` |
| Method overriding | `calculateRentalPrice` and `calculateInsurancePremium` in `Car` and `Truck` |
| Method overloading | `Car.calculateRentalPrice(int days, boolean gpsIncluded)` |
| Static method hiding | `printVehicleType()` in `Vehicle`, `Car`, and `Truck` |
| `final` methods | `getBaseInsuranceRate()` and `printPlate()` cannot be overridden |
| Polymorphism | `RentalService.processRental(Rentable, int)` works with any `Rentable` |
| Type casting | `RentalContract` casts a `Rentable` to `Insurable` for premiums |

## How to Run

1. Compile (from the project root):
   `javac -d out src/coe318/lab7/*.java`
2. Run:
   `java -cp out coe318.lab7.RentalService`

Or open the project in NetBeans/IntelliJ and run `RentalService.java`.

## Notes

- `RentalContract` casts its `Rentable` to `Insurable` when insurance is added. This works because every `Vehicle` implements both, but a `Rentable` that isn't `Insurable` would throw a `ClassCastException`.
- Static methods are hidden, not overridden, so the version called depends on the reference type, not the object.

## Tools Used

- Java
- Interfaces and abstraction
- Inheritance and polymorphism

## Author

[Your Name] – COE 318, Toronto Metropolitan University
