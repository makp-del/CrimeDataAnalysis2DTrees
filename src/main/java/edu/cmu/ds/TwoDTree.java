//Author: Manjunath K P

package edu.cmu.ds;

import org.slf4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * The TwoDTree class represents a 2D tree data structure that stores crime records.
 * It supports operations like insertion, inorder, preorder, postorder, level order, and reverse level order traversal.
 * It also supports finding points within a given range and finding the nearest neighbor to a given point.
 */
public class TwoDTree {

    /**
     * The TreeNode class represents a node in the 2D tree.
     * It contains the coordinates, crime record, and references to the left and right child nodes.
     */

    private static final Logger logger = LoggerUtil.getLogger(TwoDTree.class);
    private TreeNode root; // Reference to the root node of the 2D tree

    /**
     * Constructor to create an empty 2D tree.
     * <p>
     * Preconditions: None.
     * Postconditions: A new TwoDTree object is created with root set to null.
     * Time complexity: O(1), as it only initializes the root pointer.
     */
    public TwoDTree(String crimeDataLocation) {
        root = null;
        try {
            loadCrimeData(crimeDataLocation);
        } catch (Exception e) {
            logger.error("Error while loading crime data from " + crimeDataLocation, e.getMessage());
        }
    }

    /**
     * Loads crime data from the given file location and inserts it into the 2D tree.
     *
     * @param crimeDataLocation The location of the crime data file.
     *                          <p>
     *                          Preconditions: crimeDataLocation must be a valid file path.
     *                          Postconditions: Crime records from the file are loaded into the 2D tree.
     *                          Time complexity: O(n), where n is the number of crime records in the file, as it reads each record from the file.
     */
    private void loadCrimeData(String crimeDataLocation) throws IOException {
        logger.info("Starting to load crime data from: " + crimeDataLocation);

        BufferedReader br = new BufferedReader(new FileReader(crimeDataLocation));
        String line;
        int recordCount = 0;  // To keep track of how many records are loaded

        // Read each line from the file
        while ((line = br.readLine()) != null) {

            //Skip first line
            if (recordCount == 0) {
                recordCount++;
                continue;
            }

            // Split the line by comma
            if (!line.trim().isEmpty()) {  // Skip empty lines
                String[] fields = line.split(",");
                if (fields.length >= 9) {  // Ensure that we have all necessary fields
                    try {
                        // Create a new CrimeRecord object from the fields
                        CrimeRecord crimeRecord = new CrimeRecord(Double.parseDouble(fields[0]), Double.parseDouble(fields[1]), Integer.parseInt(fields[2]), fields[3], fields[4], fields[5], fields[6], fields[7], fields[8]);
                        double[] coordinates = new double[]{crimeRecord.x(), crimeRecord.y()};
                        insert(coordinates, crimeRecord);
                        recordCount++;  // Increment count for each successfully loaded record
                    } catch (NumberFormatException e) {
                        logger.warn("Failed to parse crime record: " + line, e);
                    }
                } else {
                    // Log a warning for malformed lines
                    logger.warn("Skipping malformed line: " + line);
                }
            }
        }
        recordCount--;  // Decrement count to exclude header
        br.close();
        logger.info("Crime file loaded into 2D tree with " + recordCount + " records.");
    }

    /**
     * Inserts a new crime record into the 2D tree.
     *
     * @param coordinates The x and y coordinates of the crime record.
     * @param crimeRecord The crime record to be inserted.
     *                    <p>
     *                    Preconditions: coordinates and crimeRecord must be non-null.
     *                    Postconditions: A new TreeNode is created with the given coordinates and crime record and inserted into the 2D tree.
     *                    Time complexity: O(log n), where n is the number of nodes in the tree, as it traverses the tree to find the correct position.
     */
    void insert(double[] coordinates, CrimeRecord crimeRecord) {
        root = insertRec(root, coordinates, crimeRecord, 0);
    }

    /**
     * Recursive helper method to insert a new crime record into the 2D tree.
     *
     * @param root        The root of the current subtree.
     * @param coordinates The x and y coordinates of the crime record.
     * @param crimeRecord The crime record to be inserted.
     * @param depth       The depth of the current node in the tree.
     * @return The root of the updated subtree.
     * <p>
     * Preconditions: coordinates and crimeRecord must be non-null.
     * Postconditions: A new TreeNode is created with the given coordinates and crime record and inserted into the subtree rooted at root.
     * Time complexity: O(log n), where n is the number of nodes in the subtree, as it traverses the subtree to find the correct position.
     */
    private TreeNode insertRec(TreeNode root, double[] coordinates, CrimeRecord crimeRecord, int depth) {
        // If the tree is empty, create a new node
        if (root == null) {
            return new TreeNode(coordinates, crimeRecord);
        }
        // Calculate the current dimension based on the depth
        int currentDimension = depth % 2;
        // Compare the current dimension of the node with the given coordinates
        if (coordinates[currentDimension] < root.coordinates[currentDimension]) {
            root.left = insertRec(root.left, coordinates, crimeRecord, depth + 1);
        } else {
            // If the coordinates are greater or equal, insert into the right subtree
            root.right = insertRec(root.right, coordinates, crimeRecord, depth + 1);
        }
        return root;
    }

    /**
     * Performs an inorder traversal of the 2D tree.
     * <p>
     * Preconditions: None.
     * Postconditions: The crime records in the tree are printed in inorder traversal.
     * Time complexity: O(n), where n is the number of nodes in the tree, as it visits each node exactly once.
     */
    public void inorder() {
        logger.info("Inorder traversal of the tree:");
        inorderRec(root);
    }

    /**
     * Recursive helper method to perform an inorder traversal of the 2D tree.
     *
     * @param root The root of the current subtree.
     *             <p>
     *             Preconditions: None.
     *             Postconditions: The crime records in the subtree rooted at root are printed in inorder traversal.
     *             Time complexity: O(n), where n is the number of nodes in the subtree, as it visits each node exactly once.
     */
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            logger.info("Crime: " + root.crimeRecord + " at (" + root.coordinates[0] + ", " + root.coordinates[1] + ")");
            inorderRec(root.right);
        }
    }

    /**
     * Performs a preorder traversal of the 2D tree.
     * <p>
     * Preconditions: None.
     * Postconditions: The crime records in the tree are printed in preorder traversal.
     * Time complexity: O(n), where n is the number of nodes in the tree, as it visits each node exactly once.
     */
    public void preorder() {
        logger.info("Preorder traversal of the tree:");
        preorderRec(root);
    }

    /**
     * Recursive helper method to perform a preorder traversal of the 2D tree.
     *
     * @param root The root of the current subtree.
     *             <p>
     *             Preconditions: None.
     *             Postconditions: The crime records in the subtree rooted at root are printed in preorder traversal.
     *             Time complexity: O(n), where n is the number of nodes in the subtree, as it visits each node exactly once.
     */
    private void preorderRec(TreeNode root) {
        if (root != null) {
            logger.info("Crime: " + root.crimeRecord.toString() + " at (" + root.coordinates[0] + ", " + root.coordinates[1] + ")");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    /**
     * Performs a postorder traversal of the 2D tree.
     * <p>
     * Preconditions: None.
     * Postconditions: The crime records in the tree are printed in postorder traversal.
     * Time complexity: O(n), where n is the number of nodes in the tree, as it visits each node exactly once.
     */
    public void postorder() {
        logger.info("Postorder traversal of the tree:");
        postorderRec(root);
    }

    /**
     * Recursive helper method to perform a postorder traversal of the 2D tree.
     *
     * @param root The root of the current subtree.
     *             <p>
     *             Preconditions: None.
     *             Postconditions: The crime records in the subtree rooted at root are printed in postorder traversal.
     *             Time complexity: O(n), where n is the number of nodes in the subtree, as it visits each node exactly once.
     */
    private void postorderRec(TreeNode root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            logger.info("Crime: " + root.crimeRecord.toString() + " at (" + root.coordinates[0] + ", " + root.coordinates[1] + ")");
        }
    }

    /**
     * Performs a level order traversal of the 2D tree.
     * <p>
     * Preconditions: None.
     * Postconditions: The crime records in the tree are printed in level order traversal.
     * Time complexity: O(n), where n is the number of nodes in the tree, as it visits each node exactly once.
     */
    /**
     * Time complexity analysis:
     * The levelOrderPrint method performs a level order traversal of the 2D tree.
     * It uses a queue to store the nodes and processes each node in the queue.
     * The method enqueues the root node and then dequeues each node, printing its crime record and enqueuing its children if they exist.
     * This process continues until the queue is empty, ensuring that each node is visited exactly once.
     * Therefore, the time complexity of the levelOrderPrint method is O(n), where n is the number of nodes in the tree.
     * This is because the method visits each node exactly once during the traversal.
     * The space complexity of the levelOrderPrint method is also O(n) in the worst case.
     */
    public void levelOrderPrint() {
        logger.info("Level order traversal of the tree:");

        // If the tree is empty, return
        if (root == null) {
            return;
        }

        // Create a queue to store the nodes
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.enqueue(root);

        // Process each node in the queue
        while (!queue.isEmpty()) {
            // Dequeue the current node
            TreeNode current = queue.dequeue();
            logger.info("Crime: " + current.crimeRecord.toString() + " at (" + current.coordinates[0] + ", " + current.coordinates[1] + ")");

            // Enqueue the left child if it exists
            if (current.left != null) {
                queue.enqueue(current.left);
            }

            // Enqueue the right child if it exists
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }

    /**
     * Performs a reverse level order traversal of the 2D tree.
     * <p>
     * Preconditions: None.
     * Postconditions: The crime records in the tree are printed in reverse level order traversal.
     * Time complexity: O(n), where n is the number of nodes in the tree, as it visits each node exactly once.
     */
    public void reverseLevelOrderPrint() {
        logger.info("Reverse level order traversal of the tree:");

        // If the tree is empty, return
        if (root == null) {
            return;
        }

        Stack<TreeNode> stack = new Stack<TreeNode>();
        Queue<TreeNode> queue = new Queue<TreeNode>();
        queue.enqueue(root);

        // Process each node in the queue
        while (!queue.isEmpty()) {
            TreeNode current = queue.dequeue();
            stack.push(current);

            // Enqueue the right child if it exists
            if (current.right != null) {
                queue.enqueue(current.right);
            }

            // Enqueue the left child if it exists
            if (current.left != null) {
                queue.enqueue(current.left);
            }
        }

        // Pop and print the nodes from the stack
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            logger.info("Crime: " + current.crimeRecord.toString() + " at (" + current.coordinates[0] + ", " + current.coordinates[1] + ")");
        }
    }

    /**
     * Finds all crime records within the given range of coordinates.
     *
     * @param lowerLeft  The lower left corner of the range.
     * @param upperRight The upper right corner of the range.
     * @return A list of crime records within the given range.
     * <p>
     * Preconditions: lowerLeft and upperRight must be valid coordinate arrays.
     * Postconditions: Returns a list of crime records within the given range.
     * Time complexity: O(n), where n is the number of nodes in the tree, as it visits each node exactly once.
     */
    public ListOfCrimes findPointsInRange(double[] lowerLeft, double[] upperRight) {
        ListOfCrimes crimesInRange = new ListOfCrimes();
        findPointsInRangeRec(root, lowerLeft, upperRight, 0, crimesInRange);
        return crimesInRange;
    }

    /**
     * Recursive helper method to find all crime records within the given range of coordinates.
     *
     * @param root          The root of the current subtree.
     * @param lowerLeft     The lower left corner of the range.
     * @param upperRight    The upper right corner of the range.
     * @param depth         The depth of the current node in the tree.
     * @param crimesInRange The list of crime records within the range.
     *                      <p>
     *                      Preconditions: lowerLeft and upperRight must be valid coordinate arrays, crimesInRange must be non-null.
     *                      Postconditions: Adds the crime records within the range to the list crimesInRange.
     *                      Time complexity: O(n), where n is the number of nodes in the subtree, as it visits each node exactly once.
     */
    private void findPointsInRangeRec(TreeNode root, double[] lowerLeft, double[] upperRight, int depth, ListOfCrimes crimesInRange) {
        if (root == null) {
            return;
        }

        int currentDimension = depth % 2;

        // If the current node is within the range, add it to the list
        if (root.coordinates[0] >= lowerLeft[0] && root.coordinates[0] <= upperRight[0] && root.coordinates[1] >= lowerLeft[1] && root.coordinates[1] <= upperRight[1]) {
            crimesInRange.addCrime(root.crimeRecord);
        }

        // Check if the current dimension is within the range
        if (root.coordinates[currentDimension] >= lowerLeft[currentDimension]) {
            findPointsInRangeRec(root.left, lowerLeft, upperRight, depth + 1, crimesInRange);
        }

        // Check if the current dimension is within the range
        if (root.coordinates[currentDimension] <= upperRight[currentDimension]) {
            findPointsInRangeRec(root.right, lowerLeft, upperRight, depth + 1, crimesInRange);
        }
    }

    /**
     * Finds the nearest neighbor to the given point in the 2D tree.
     *
     * @param coordinates The x and y coordinates of the query point.
     * @return The nearest neighbor to the query point.
     * <p>
     * Preconditions: coordinates must be a valid coordinate array.
     * Postconditions: Returns the nearest neighbor to the query point.
     * Time complexity: O(log n), where n is the number of nodes in the tree, as it traverses the tree to find the nearest neighbor.
     */
    public Neighbor nearestNeighbor(double[] coordinates) {
        logger.info("Finding nearest neighbor to point (" + coordinates[0] + ", " + coordinates[1] + ")");
        Neighbor nearest = new Neighbor(null, Double.MAX_VALUE);
        nearestNeighborRec(root, coordinates, 0, nearest);
        return nearest;
    }

    /**
     * Recursive helper method to find the nearest neighbor to the given point in the 2D tree.
     *
     * @param root        The root of the current subtree.
     * @param coordinates The x and y coordinates of the query point.
     * @param depth       The depth of the current node in the tree.
     * @param nearest     The nearest neighbor found so far.
     *                    <p>
     *                    Preconditions: coordinates must be a valid coordinate array, nearest must be non-null.
     *                    Postconditions: Updates the nearest neighbor based on the query point.
     *                    Time complexity: O(log n), where n is the number of nodes in the tree, as it traverses the tree to find the nearest neighbor.
     */
    private void nearestNeighborRec(TreeNode root, double[] coordinates, int depth, Neighbor nearest) {
        // If the tree is empty, return
        if (root == null) {
            return;
        }

        // Calculate the distance between the current node and the query point
        double currentDistance = Math.sqrt(Math.pow(coordinates[0] - root.coordinates[0], 2) + Math.pow(coordinates[1] - root.coordinates[1], 2));

        // If the current node is closer to the query point, update the nearest neighbor
        if (currentDistance < nearest.distance) {
            nearest.distance = currentDistance;
            nearest.crimeDetails = root.crimeRecord;
        }

        // Calculate the current dimension
        int currentDimension = depth % 2;

        //If the query point dimension is less than the current node dimension, search the left subtree
        if (coordinates[currentDimension] < root.coordinates[currentDimension]) {
            nearestNeighborRec(root.left, coordinates, depth + 1, nearest);
            // If the distance between the query point and the current node is less than the nearest distance, search the right subtree
            if (Math.pow(coordinates[currentDimension] - root.coordinates[currentDimension], 2) < nearest.distance) {
                nearestNeighborRec(root.right, coordinates, depth + 1, nearest);
            }
        }
        //If the query point dimension is greater than or equal to the current node dimension, search the right subtree
        else {
            nearestNeighborRec(root.right, coordinates, depth + 1, nearest);
            // If the distance between the query point and the current node is less than the nearest distance, search the left subtree
            if (Math.pow(coordinates[currentDimension] - root.coordinates[currentDimension], 2) < nearest.distance) {
                nearestNeighborRec(root.left, coordinates, depth + 1, nearest);
            }
        }
    }

    /**
     * The TreeNode class represents a node in the 2D tree.
     * It contains the coordinates, crime record, and references to the left and right child nodes.
     */
    private static class TreeNode {
        double[] coordinates; // The x and y coordinates of the node
        TreeNode left; // Reference to the left child node
        TreeNode right; // Reference to the right child node
        CrimeRecord crimeRecord; // The crime record associated with the node

        /**
         * Constructor to create a new node with the given coordinates and crime record.
         *
         * @param coordinates The x and y coordinates of the node.
         * @param crimeRecord The crime record associated with the node.
         *                    <p>
         *                    Preconditions: None.
         *                    Postconditions: A new TreeNode is created with the given coordinates, crime record, and null left and right child nodes.
         *                    Time complexity: O(1), as it only sets the instance variables.
         */
        public TreeNode(double[] coordinates, CrimeRecord crimeRecord) {
            this.coordinates = coordinates;
            this.crimeRecord = crimeRecord;
            this.left = null;
            this.right = null;
        }
    }

}