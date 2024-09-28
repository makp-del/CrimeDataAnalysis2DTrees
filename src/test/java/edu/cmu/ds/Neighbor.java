package edu.cmu.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NeighborTest {

    private Neighbor neighbor;
    private CrimeRecord crimeRecord;

    @BeforeEach
    void setUp() {
        crimeRecord = new CrimeRecord(100.5, 200.6, 1300, "Main St", "Robbery", "2024-09-28", "12345", "40.1234", "-79.5678");
        neighbor = new Neighbor(crimeRecord, 5.0);
    }

    @Test
    void testGetCrimeDetails() {
        assertEquals(crimeRecord, neighbor.getCrimeDetails());
    }

    @Test
    void testGetDistance() {
        assertEquals(5.0, neighbor.getDistance());
    }

    @Test
    void testToString() {
        String expected = "Nearest Crime: " + crimeRecord.toString() + ", Distance: 5.0";
        assertEquals(expected, neighbor.toString());
    }
}