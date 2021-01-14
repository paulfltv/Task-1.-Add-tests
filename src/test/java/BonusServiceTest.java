import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;
        long actual = service.calculate(amount, true);
        assertEquals(500, actual);
    }
    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_60;
        boolean registered = true;
        long expected = 30;
        long actual = service.calculate(amount, true);
        assertEquals(30, actual);
    }
    @Test
    void shouldCalculateForNotregisteredAndUnderLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_60;
        boolean registered = false;
        long expected = 10;
        long actual = service.calculate(amount, false);
        assertEquals(10, actual);
    }
    @Test
    void shouldCalculateForNotregisteredAndOverLimit() {
        BonusService service = new BonusService();
        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;
        long actual = service.calculate(amount, false);
        assertEquals(500, actual);
    }
}