//Author: Manjunath K P

package edu.cmu.ds;

/**
 * The Neighbor class represents a neighbor in the k-Nearest Neighbors algorithm.
 * It contains a CrimeRecord object and the distance from the query point.
 */
public class Neighbor {
    CrimeRecord crimeDetails; // The CrimeRecord object
    double distance; // The distance from the query point

    /**
     * Constructor to create a Neighbor object
     *
     * @param crimeDetails The CrimeRecord object
     * @param distance     The distance from the query point
     *                     Preconditions: crimeDetails must be non-null, distance must be a valid double value.
     *                     Postconditions: A new Neighbor object is created with the given CrimeRecord and distance.
     *                     Time complexity: O(1), as it directly assigns values to instance variables.
     */
    public Neighbor(CrimeRecord crimeDetails, double distance) {
        this.crimeDetails = crimeDetails;
        this.distance = distance;
    }

    /**
     * Returns the CrimeRecord object
     *
     * @return The CrimeRecord object
     * Preconditions: None.
     * Postconditions: Returns the CrimeRecord object.
     * Time complexity: O(1), since it returns a single value.
     */

    public CrimeRecord getCrimeDetails() {
        return crimeDetails;
    }

    /**
     * Returns the distance from the query point
     *
     * @return The distance from the query point
     * Preconditions: None.
     * Postconditions: Returns the distance.
     * Time complexity: O(1), since it returns a single value.
     */
    public double getDistance() {
        return distance;
    }


    /**
     * Returns a string representation of the Neighbor object
     *
     * @return A string representation of the Neighbor object
     * Preconditions: None.
     * Postconditions: Returns a string representation of the Neighbor object.
     * Time complexity: O(1), since it constructs a string with constant number of operations.
     */
    @Override
    public String toString() {
        return "Nearest Crime: " + crimeDetails + ", Distance: " + distance;
    }
}
