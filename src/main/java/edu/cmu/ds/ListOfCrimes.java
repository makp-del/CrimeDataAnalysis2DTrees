//Author: Manjunath K P

package edu.cmu.ds;

/**
 * The ListOfCrimes class is a linked list data structure that holds multiple CrimeRecord objects.
 * It supports operations to add new crimes, retrieve crimes by index, convert the list to a string,
 * and generate a KML file for visualizing the crime locations in Google Earth.
 */
public class ListOfCrimes {

    private CrimeNode head; // Reference to the first node in the list

    /**
     * Constructor to create an empty list of crimes.
     * <p>
     * Preconditions: None.
     * Postconditions: A new ListOfCrimes object is created with head set to null.
     * Time complexity: O(1), as it only initializes the head pointer.
     */
    public ListOfCrimes() {
        head = null;
    }

    /**
     * Adds a new crime record to the list.
     *
     * @param crime CrimeRecord to be added to the list.
     *              <p>
     *              Preconditions: crime must be non-null.
     *              Postconditions: A new CrimeNode is created with the given crime and added to the end of the list.
     *              Time complexity: O(n), where n is the number of nodes in the list, as it traverses the list to find the end.
     */
    public void addCrime(CrimeRecord crime) {
        CrimeNode newNode = new CrimeNode(crime);
        if (head == null) {
            head = newNode;
        } else {
            CrimeNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    /**
     * Retrieves the crime record at the specified index.
     *
     * @param index Index of the crime record to retrieve.
     * @return CrimeRecord at the specified index, or null if index is out of bounds.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the CrimeRecord at the specified index, or null if index is out of bounds.
     * Time complexity: O(n), where n is the index, as it traverses the list to find the node at the given index.
     */
    public CrimeRecord getCrime(int index) {
        // Check if index is out of bounds
        if (index < 0) {
            return null;
        }
        // Traverse the list to find the node at the given index
        CrimeNode current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) {
                return null;
            }
            current = current.next;
        }
        // Return the crime record at the specified index
        if (current == null) {
            return null;
        }
        return current.crime;
    }

    /**
     * Returns a string representation of the list of crimes.
     *
     * @return String representation of the list of crimes.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns a string containing all the crime records in the list.
     * Time complexity: O(n), where n is the number of nodes in the list, as it traverses the list to build the string.
     */
    @Override
    public String toString() {
        // Build a string with all the crime records
        StringBuilder sb = new StringBuilder();
        CrimeNode current = head;
        // Traverse the list and append each crime record to the string
        while (current != null) {
            sb.append(current.crime);
            sb.append("\n");
            current = current.next;
            // Add a separator between records
        }
        // Return the string representation of the list
        return sb.toString();
    }

    /**
     * Generates a KML file containing the crime locations for visualization in Google Earth.
     *
     * @return KML-formatted string representing the crime locations.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns a KML-formatted string with Placemark elements for each crime record.
     * Time complexity: O(n), where n is the number of nodes in the list, as it traverses the list to build the KML string.
     */
    public String toKML() {
        // Build a KML string with Placemark elements for each crime record
        StringBuilder kml = new StringBuilder();
        kml.append("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
        kml.append("<kml xmlns=\"http://www.opengis.net/kml/2.2\">\n");
        kml.append("<Document>\n");
        // Traverse the list and add a Placemark for each crime record
        CrimeNode current = head;
        while (current != null) {
            String offense = current.crime.offense();
            String description = current.crime.street();
            String lat = current.crime.latitude();
            String lon = current.crime.longitude();

            kml.append("<Placemark>\n");
            kml.append("<name>").append(offense).append("</name>\n");
            kml.append("<description>").append(description).append("</description>\n");
            kml.append("<Point>\n");
            kml.append("<coordinates>").append(lon).append(",").append(lat).append(",0</coordinates>\n");
            kml.append("</Point>\n");
            kml.append("</Placemark>\n");

            current = current.next;
            // Add a Placemark for each crime record
        }
        // Return the KML-formatted string
        kml.append("</Document>\n");
        kml.append("</kml>");
        return kml.toString();
    }

    /**
     * Returns the number of crime records in the list.
     *
     * @return Number of crime records in the list.
     * <p>
     * Preconditions: None.
     * Postconditions: Returns the number of crime records in the list.
     * Time complexity: O(n), where n is the number of nodes in the list, as it traverses the list to count the nodes.
     */
    public int size() {
        int count = 0;
        CrimeNode current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    /**
     * The CrimeNode class is a linked list node that holds a CrimeRecord object and a reference to the next node.
     */
    private static class CrimeNode {
        private final CrimeRecord crime; // The crime record
        private CrimeNode next; // Reference to the next node

        /**
         * Constructor to create a new node with the given CrimeRecord.
         *
         * @param crime CrimeRecord to be stored in the node.
         *              <p>
         *              Preconditions: crime must be non-null.
         *              Postconditions: A new CrimeNode is created with the given crime and null next pointer.
         *              Time complexity: O(1), as it only sets two instance variables.
         */
        public CrimeNode(CrimeRecord crime) {
            this.crime = crime;
            this.next = null;
        }
    }

}
