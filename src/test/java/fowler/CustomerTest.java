package fowler;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CustomerTest {
    private Customer customer;

    @BeforeEach
    void setUp() {
        customer = new Customer("joe");
        Movie m1 = new Movie("movie1", 1);
        Movie m2 = new Movie("movie2", 2);
        Rental r1 = new Rental(m1, 10);
        Rental r2 = new Rental(m2, 5);

        customer.addRental(r1);
        customer.addRental(r2);
    }

    @Test
    void statement() {
        String expected = "fowler.Rental Record for joe\n" +
                "\tTitle\t\tDays\tAmount\n" +
                "\tmovie1\t\t10\t30.0\n" +
                "\tmovie2\t\t5\t4.5\n" +
                "Amount owed is 34.5\n" +
                "You earned 3 frequent renter points";
        String result = customer.statement();
        assertEquals(expected, result);
    }
}