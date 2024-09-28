//Author: Manjunath K P

package edu.cmu.ds;

import org.slf4j.Logger;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * The TwoDTreeDriver class provides a command-line interface to interact with the TwoDTree class.
 * It allows users to perform operations like inorder, preorder, postorder, levelOrder, reverseLevelOrder, search for points within a rectangle, and search for the nearest neighbor.
 */
public class TwoDTreeDriver {
    private static final Logger logger = LoggerUtil.getLogger(TwoDTreeDriver.class);

    public static void main(String[] args) {
        TwoDTree tree = new TwoDTree("CrimeLatLonXY.csv");

        Scanner scanner = new Scanner(System.in);

        // Loop to display the menu and get user input
        while (true) {
            logger.info("What would you like to do?");
            logger.info("1: Inorder");
            logger.info("2: Preorder");
            logger.info("3: LevelOrder");
            logger.info("4: Postorder");
            logger.info("5: ReverseLevelOrder");
            logger.info("6: Search for points within rectangle");
            logger.info("7: Search for nearest neighbor");
            logger.info("8: Quit");

            int choice = scanner.nextInt();

            // Switch case to handle user input
            switch (choice) {
                case 1:
                    tree.inorder();
                    break;
                case 2:
                    tree.preorder();
                    break;
                case 3:
                    tree.levelOrderPrint();
                    break;
                case 4:
                    tree.postorder();
                    break;
                case 5:
                    tree.reverseLevelOrderPrint();
                    break;
                case 6:
                    scanner.nextLine();
                    // Get the coordinates of the rectangle from the user
                    logger.info("Enter a rectangle bottom left (X1, Y1) and top right (X2, Y2) as four doubles");
                    String input = scanner.nextLine();
                    String[] coordinates = input.split("\\s+");
                    double x1 = Double.parseDouble(coordinates[0]);
                    double y1 = Double.parseDouble(coordinates[1]);
                    double x2 = Double.parseDouble(coordinates[2]);
                    double y2 = Double.parseDouble(coordinates[3]);

                    // Search for points within the given rectangle
                    logger.info("Searching for points within (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")");
                    ListOfCrimes crimes = tree.findPointsInRange(new double[]{x1, y1}, new double[]{x2, y2});
                    if (crimes != null) {
                        // Display the crimes found and write them to a KML file
                        logger.info(crimes.toString());
                        String kmlOutput = crimes.toKML();
                        try {
                            // Write the KML output to a file
                            FileWriter writer = new FileWriter("PGHCrimes.kml");
                            writer.write(kmlOutput);
                            writer.close();
                            logger.info("KML file 'PGHCrimes.kml' written successfully");
                        } catch (IOException e) {
                            // Log an error if writing the file fails
                            logger.error("Error while writing KML file: {}", e.getMessage());
                        }
                    } else {
                        // Log a message if no crimes are found
                        logger.info("No crimes found within the given range");
                    }
                    break;
                case 7:
                    // Get the point from the user
                    logger.info("Enter a point (X, Y) as two doubles");
                    double x = scanner.nextDouble();
                    double y = scanner.nextDouble();
                    // Search for the nearest crime to the given point
                    logger.info("Searching for the nearest crime to point (" + x + ", " + y + ")");
                    Neighbor nearest = tree.nearestNeighbor(new double[]{x, y});
                    logger.info(nearest.toString());
                    break;
                case 8:
                    // Exit the program
                    logger.info("Thank you for exploring Pittsburgh crimes in the 1990s.");
                    scanner.close();
                    return;
                default:
                    logger.info("Invalid option. Please enter a number between 1 and 8.");
            }
        }
    }
}
