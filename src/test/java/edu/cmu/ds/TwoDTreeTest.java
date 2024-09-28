package edu.cmu.ds;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

class TwoDTreeTest {

    private TwoDTree twoDTree;

    @BeforeEach
    void setUp() {
        // Initialize an empty tree
        twoDTree = new TwoDTree("testCrimeData.csv");
    }

    @Test
    void testInsertAndInorderTraversal() {
        // Create sample CrimeRecords
        CrimeRecord crime1 = new CrimeRecord(10.0, 20.0, 1300, "Main St", "Robbery", "2024-09-28", "12345", "40.1234", "-79.5678");
        CrimeRecord crime2 = new CrimeRecord(15.0, 25.0, 1400, "Elm St", "Assault", "2024-09-28", "54321", "41.1234", "-80.5678");
        CrimeRecord crime3 = new CrimeRecord(5.0, 10.0, 1500, "Oak St", "Burglary", "2024-09-28", "67890", "42.1234", "-81.5678");

        // Insert records
        twoDTree.insert(new double[]{crime1.x(), crime1.y()}, crime1);
        twoDTree.insert(new double[]{crime2.x(), crime2.y()}, crime2);
        twoDTree.insert(new double[]{crime3.x(), crime3.y()}, crime3);

        // Perform inorder traversal and assert the traversal order
        // For this, we would ideally mock logger calls or check traversal correctness by capturing logs
    }

    @Test
    void testNearestNeighbor() {
        // Create sample CrimeRecords
        CrimeRecord crime1 = new CrimeRecord(10.0, 20.0, 1300, "Main St", "Robbery", "2024-09-28", "12345", "40.1234", "-79.5678");
        CrimeRecord crime2 = new CrimeRecord(15.0, 25.0, 1400, "Elm St", "Assault", "2024-09-28", "54321", "41.1234", "-80.5678");
        CrimeRecord crime3 = new CrimeRecord(5.0, 10.0, 1500, "Oak St", "Burglary", "2024-09-28", "67890", "42.1234", "-81.5678");

        // Insert records
        twoDTree.insert(new double[]{crime1.x(), crime1.y()}, crime1);
        twoDTree.insert(new double[]{crime2.x(), crime2.y()}, crime2);
        twoDTree.insert(new double[]{crime3.x(), crime3.y()}, crime3);

        // Find nearest neighbor to a specific point
        Neighbor nearest = twoDTree.nearestNeighbor(new double[]{12.0, 22.0});
        assertEquals(crime1, nearest.getCrimeDetails());
    }

    @Test
    void testFindPointsInRange() {
        // Create sample CrimeRecords
        CrimeRecord crime1 = new CrimeRecord(10.0, 20.0, 1300, "Main St", "Robbery", "2024-09-28", "12345", "40.1234", "-79.5678");
        CrimeRecord crime2 = new CrimeRecord(15.0, 25.0, 1400, "Elm St", "Assault", "2024-09-28", "54321", "41.1234", "-80.5678");
        CrimeRecord crime3 = new CrimeRecord(5.0, 10.0, 1500, "Oak St", "Burglary", "2024-09-28", "67890", "42.1234", "-81.5678");

        // Insert records
        twoDTree.insert(new double[]{crime1.x(), crime1.y()}, crime1);
        twoDTree.insert(new double[]{crime2.x(), crime2.y()}, crime2);
        twoDTree.insert(new double[]{crime3.x(), crime3.y()}, crime3);

        // Find points in range
        ListOfCrimes crimesInRange = twoDTree.findPointsInRange(new double[]{8.0, 18.0}, new double[]{20.0, 30.0});
        assertEquals(2, crimesInRange.size());  // crime1 and crime2 should be in range
    }

    @Test
    void testLoadCrimeData() throws IOException {
        // This test will require a mock or real file to read data from
        // Assuming we are testing with an actual file:
        TwoDTree tree = new TwoDTree("testCrimeData.csv");
        assertNotNull(tree);
        // You would check here if crime records are correctly loaded and inserted into the tree
    }
}