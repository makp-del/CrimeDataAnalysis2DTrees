//Author: Manjunath K P


package edu.cmu.ds;

/**
 * The CrimeRecord class represents a single record of a crime incident with various attributes
 * such as geographic coordinates, time of occurrence, street location, type of offense, date,
 * tract information, latitude, and longitude.
 * <p>
 * This class provides methods to retrieve the values of these attributes and represents the record
 * in CSV format.
 *
 * @param x         Instance variables representing attributes of the crime record. X coordinate of the crime location
 * @param y         Y coordinate of the crime location
 * @param time      Time of the crime occurrence (in 24-hour format, e.g., 1300 for 1 PM)
 * @param street    Street where the crime occurred
 * @param offense   Type of offense committed (e.g., "Robbery")
 * @param date      Date of the crime (format: YYYY-MM-DD)
 * @param tract     Census tract information where the crime occurred
 * @param latitude  Latitude of the crime location
 * @param longitude Longitude of the crime location
 */
public record CrimeRecord(double x, double y, int time, String street, String offense, String date, String tract,
                          String latitude, String longitude) {

    /**
     * Constructor to initialize a CrimeRecord object with the given attributes.
     *
     * @param x         X coordinate of the crime location.
     * @param y         Y coordinate of the crime location.
     * @param time      Time of the crime occurrence.
     * @param street    Street where the crime occurred.
     * @param offense   Type of offense.
     * @param date      Date of the crime.
     * @param tract     Census tract information.
     * @param latitude  Latitude of the crime location.
     * @param longitude Longitude of the crime location.
     *                  <p>
     *                  Preconditions: All input parameters must be non-null. Time should be in valid 24-hour format.
     *                  Postconditions: A new CrimeRecord object is created with the provided values.
     *                  Time complexity: O(1), since it directly assigns values to instance variables.
     */
    public CrimeRecord {
    }

    /**
     * Returns the X coordinate of the crime location.
     *
     * @return X coordinate of the crime location.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the X coordinate.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public double x() {
        return x;
    }

    /**
     * Returns the Y coordinate of the crime location.
     *
     * @return Y coordinate of the crime location.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the Y coordinate.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public double y() {
        return y;
    }

    /**
     * Returns the time of the crime occurrence.
     *
     * @return Time of the crime occurrence.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the time of the crime.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public int time() {
        return time;
    }

    /**
     * Returns the street where the crime occurred.
     *
     * @return Street where the crime occurred.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the street name.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public String street() {
        return street;
    }

    /**
     * Returns the type of offense committed.
     *
     * @return Type of offense committed.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the offense type.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public String offense() {
        return offense;
    }

    /**
     * Returns the date when the crime occurred.
     *
     * @return Date when the crime occurred.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the date of the crime.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public String date() {
        return date;
    }

    /**
     * Returns the census tract information where the crime occurred.
     *
     * @return Census tract information.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the census tract.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public String tract() {
        return tract;
    }

    /**
     * Returns the latitude of the crime location.
     *
     * @return Latitude of the crime location.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the latitude.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public String latitude() {
        return latitude;
    }

    /**
     * Returns the longitude of the crime location.
     *
     * @return Longitude of the crime location.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the longitude.
     * Time complexity: O(1), since it returns a single value.
     */
    @Override
    public String longitude() {
        return longitude;
    }

    /**
     * Returns a string representation of the CrimeRecord object in CSV format.
     *
     * @return A CSV-formatted string representing the crime record.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns a string with the format: x,y,time,street,offense,date,tract,latitude,longitude.
     * Time complexity: O(1), since it concatenates a fixed number of values.
     */
    @Override
    public String toString() {
        return x + "," + y + "," + time + "," + street + "," + offense + "," + date + "," + tract + "," + latitude + "," + longitude;
    }
}