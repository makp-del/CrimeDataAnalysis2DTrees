# CrimeDataAnalysis2DTrees
Analyzing crime data of Pittsburgh using 2D Trees supporting features like range search, nearest neighbor search.
=======
# Analysing Crime Records using 2D Trees

## Overview

This project implements a 2D Tree data structure for storing and managing crime records, based on geographic coordinates. The project includes functionalities such as inserting crime records, performing various tree traversals, finding the nearest neighbor (crime record) to a given point, and finding all crime records within a specified geographic range.

## Features

- **Crime Data Insertion:** Load and insert crime records into the 2D Tree from a CSV file.
- **2D Tree Traversals:**
    - Inorder
    - Preorder
    - Postorder
    - Level-order
    - Reverse level-order
- **Range Search:** Find all crime records within a specific rectangular geographic range.
- **Nearest Neighbor Search:** Find the nearest crime record to a given point.
- **KML Generation:** Generate KML files for visualizing crime locations in Google Earth (optional).

## Directory Structure

```bash
.
├── CrimeLatLonXY.csv  # Main crime data file
├── output
│   └── PGHCrimes.kml  # Output KML file for visualizing crime data
├── src
│   └── main
│       └── java
│           └── edu
│               └── cmu
│                   └── ds
│                       ├── CrimeRecord.java
│                       ├── ListOfCrimes.java
│                       ├── Neighbor.java
│                       ├── Queue.java
│                       ├── Stack.java
│                       ├── TwoDTree.java
├── test
│   └── java
│       └── edu
│           └── cmu
│               └── ds
│                   ├── CrimeRecordTest.java
│                   ├── ListOfCrimesTest.java
│                   ├── NeighborTest.java
│                   ├── QueueTest.java
│                   ├── StackTest.java
│                   ├── TwoDTreeTest.java
│   └── resources
│       └── testCrimeData.csv  # Test crime data for unit tests
├── pom.xml
└── README.md
```

## How to Run

### Prerequisites
- **Java 8+**
- **Maven 3+**
- **Git**
- **JUnit 5** for unit testing
- **SLF4J** for logging

### Running the Project

1. **Clone the Repository:**

   ```bash
   git clone https://github.com/your-username/CrimeRecordsProject.git
   cd CrimeRecordsProject
   ```

2. **Build the Project:**

   Use Maven to compile the project and run the tests.

   ```bash
   mvn clean install
   ```

3. **Run the Application:**

   The project can be extended to run as a command-line or GUI-based application that supports loading crime records and performing the operations mentioned above.

   ```bash
   java -cp target/your-artifact.jar edu.cmu.ds.MainClass
   ```

   > *Note:* Make sure to replace `MainClass` with the actual entry point of your application.

4. **Test the Application:**

   The project uses JUnit 5 for testing. To run the test cases, use:

   ```bash
   mvn test
   ```

## Crime Data Format

The main crime data is stored in `CrimeLatLonXY.csv`, and the test data is stored in `test/resources/testCrimeData.csv`. The format is as follows:

```csv
x,y,time,street,offense,date,tract,latitude,longitude
10.0,20.0,1300,Main St,Robbery,2024-09-28,12345,40.1234,-79.5678
15.0,25.0,1400,Elm St,Assault,2024-09-28,54321,41.1234,-80.5678
5.0,10.0,1500,Oak St,Burglary,2024-09-28,67890,42.1234,-81.5678
```

## Project Components

### 1. **`CrimeRecord.java`**
Represents a single crime record with various attributes like geographic coordinates, time of occurrence, street, offense type, date, census tract, and latitude/longitude.

### 2. **`TwoDTree.java`**
Implements a 2D Tree data structure for storing crime records based on their coordinates. It supports:
- **Insertion**
- **Inorder, Preorder, Postorder, Level-order, Reverse Level-order Traversal**
- **Finding crime records within a geographic range**
- **Finding the nearest crime record**

### 3. **`ListOfCrimes.java`**
A linked list to store crime records, used for range queries and other operations.

### 4. **`Queue.java` and `Stack.java`**
Auxiliary data structures used in tree traversals and for the reverse level-order traversal.

### 5. **`Neighbor.java`**
Represents a nearest neighbor with the crime record and the distance from a given point.

## Testing

### Unit Testing

All components of the project are covered with unit tests using **JUnit 5**. The following classes are tested:
- `CrimeRecordTest`
- `ListOfCrimesTest`
- `NeighborTest`
- `QueueTest`
- `StackTest`
- `TwoDTreeTest`

### Sample Test Data

The test data is provided in `test/resources/testCrimeData.csv`, which is used for loading and testing the functionality of the `TwoDTree` class.

## Logging

The project uses **SLF4J** for logging. Logs will be printed for important operations like loading crime data, performing tree traversals, and searching for the nearest neighbor.

## Future Enhancements

- **Optimizations**: Improve nearest neighbor search with pruning techniques.
- **Visualization**: Generate KML files to visualize crime data on Google Earth.
- **GUI**: Implement a graphical interface to interact with the 2D tree and visualize the results of traversals and searches.
- **Database Support**: Add support for persisting crime records in a database for large datasets.

## Contributing

Feel free to contribute to the project by opening issues, submitting pull requests, or suggesting new features.

## License

This project is licensed under the MIT License.

---