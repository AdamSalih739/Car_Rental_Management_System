package car_rental_system;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit tests for the Car class.
 */
public class CarTest {

    @Test
    public void testCalculateRentalPriceAutomatic() {
        Car car = new Car("AAA-111", "Test Model", 2024, true); // automatic
        double expected = 3 * 65.0; // 65 per day for automatic
        assertEquals(expected, car.calculateRentalPrice(3), 0.0001);
    }

    @Test
    public void testCalculateRentalPriceManual() {
        Car car = new Car("BBB-222", "Test Model", 2024, false); // manual
        double expected = 2 * 55.0; // 55 per day for manual
        assertEquals(expected, car.calculateRentalPrice(2), 0.0001);
    }

    @Test
    public void testCalculateInsurancePremium() {
        Car car = new Car("CCC-333", "Test Model", 2024, true);
        // base insurance from Vehicle is 20; Car adds 10% → 22 per day
        double expected = 5 * 22.0;
        assertEquals(expected, car.calculateInsurancePremium(5), 0.0001);
    }
}
