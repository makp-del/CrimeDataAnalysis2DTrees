package edu.cmu.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ListOfCrimesTest {

    private ListOfCrimes listOfCrimes;
    private CrimeRecord crime1;
    private CrimeRecord crime2;
    private CrimeRecord crime3;

    @BeforeEach
    void setUp() {
        listOfCrimes = new ListOfCrimes();
        crime1 = new CrimeRecord(100.5, 200.6, 1300, "Main St", "Robbery", "2024-09-28", "12345", "40.1234", "-79.5678");
        crime2 = new CrimeRecord(110.7, 210.8, 1400, "Elm St", "Assault", "2024-09-27", "54321", "41.1234", "-78.5678");
        crime3 = new CrimeRecord(120.9, 220.9, 1500, "Oak St", "Theft", "2024-09-26", "98765", "42.1234", "-77.5678");
    }

    @Test
    void testAddCrime() {
        listOfCrimes.addCrime(crime1);
        listOfCrimes.addCrime(crime2);
        assertEquals(crime1, listOfCrimes.getCrime(0));
        assertEquals(crime2, listOfCrimes.getCrime(1));
    }

    @Test
    void testGetCrime() {
        listOfCrimes.addCrime(crime1);
        listOfCrimes.addCrime(crime2);
        listOfCrimes.addCrime(crime3);

        assertEquals(crime1, listOfCrimes.getCrime(0));
        assertEquals(crime2, listOfCrimes.getCrime(1));
        assertEquals(crime3, listOfCrimes.getCrime(2));
    }

    @Test
    void testGetCrimeOutOfBounds() {
        listOfCrimes.addCrime(crime1);
        assertNull(listOfCrimes.getCrime(2));
        assertNull(listOfCrimes.getCrime(-1));
    }

    @Test
    void testToString() {
        listOfCrimes.addCrime(crime1);
        listOfCrimes.addCrime(crime2);

        String expected = crime1.toString() + "\n" + crime2.toString() + "\n";
        assertEquals(expected, listOfCrimes.toString());
    }

    @Test
    void testToKML() {
        listOfCrimes.addCrime(crime1);
        listOfCrimes.addCrime(crime2);

        String expectedKML = """
            <?xml version="1.0" encoding="UTF-8" ?>
            <kml xmlns="http://www.opengis.net/kml/2.2">
            <Document>
            <Placemark>
            <name>Robbery</name>
            <description>Main St</description>
            <Point>
            <coordinates>-79.5678,40.1234,0</coordinates>
            </Point>
            </Placemark>
            <Placemark>
            <name>Assault</name>
            <description>Elm St</description>
            <Point>
            <coordinates>-78.5678,41.1234,0</coordinates>
            </Point>
            </Placemark>
            </Document>
            </kml>""";

        assertEquals(expectedKML.trim(), listOfCrimes.toKML().trim());
    }
}