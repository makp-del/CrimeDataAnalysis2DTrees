package edu.cmu.ds;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CrimeRecordTest {

    @Test
    void testCrimeRecordCreation() {
        CrimeRecord crimeRecord = new CrimeRecord(100.5, 200.6, 1300, "Main St", "Robbery", "2024-09-28", "12345", "40.1234", "-79.5678");

        assertEquals(100.5, crimeRecord.x());
        assertEquals(200.6, crimeRecord.y());
        assertEquals(1300, crimeRecord.time());
        assertEquals("Main St", crimeRecord.street());
        assertEquals("Robbery", crimeRecord.offense());
        assertEquals("2024-09-28", crimeRecord.date());
        assertEquals("12345", crimeRecord.tract());
        assertEquals("40.1234", crimeRecord.latitude());
        assertEquals("-79.5678", crimeRecord.longitude());
    }

    @Test
    void testToString() {
        CrimeRecord crimeRecord = new CrimeRecord(100.5, 200.6, 1300, "Main St", "Robbery", "2024-09-28", "12345", "40.1234", "-79.5678");

        String expected = "100.5,200.6,1300,Main St,Robbery,2024-09-28,12345,40.1234,-79.5678";
        assertEquals(expected, crimeRecord.toString());
    }
}