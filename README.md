# Qurbani Distribution Manager

A desktop-based Java Swing application developed to manage and track the distribution of Qurbani meat among recipients. The system provides a simple graphical user interface for adding, viewing, and removing distribution records while automatically maintaining the total quantity distributed.

This project was built as a personal challenge to practice Java GUI development, event handling, file handling, data validation, and table-based data management using Java Swing.

---

## Features

- Add new recipients with distribution details
- Categorize recipients into predefined groups
  - Family
  - Relative
  - Neighbour
  - Needy
- Record distributed quantity in kilograms
- Store recipient area information
- Display all records in a table
- Delete selected records with confirmation dialog
- Automatically calculate total distributed quantity
- Persist data using a text file
- Load previously saved records on startup
- Input validation for empty fields and invalid quantity values

---

## Technologies Used

- Java
- Java Swing
- JTable
- DefaultTableModel
- File Handling
- Event Handling
- Object-Oriented Programming Concepts

---

## Project Structure

```text
QurbaniDistributionManager
│
├── src
│   └── qurbanidistributionmanager
│       └── QurbaniDistributionManager.java
│
├── screenshots
│   ├── output
│   │   ├── 1.PNG
│   │   └── 2.PNG
│   │
│   └── code_snippets
│       ├── 1.PNG
│       ├── 2.PNG
│       ├── ...
│       └── 15.PNG
│
├── data.txt
├── build.xml
├── manifest.mf
├── README.md
│
├── nbproject
└── test
```

---

## Application Screenshots

### Main Application Window

![Main Interface](screenshots/output/1.PNG)

The main interface allows users to:

- Enter recipient information
- Select recipient category
- Record quantity distribution
- Specify recipient area
- View all records in a table
- Monitor total distributed quantity

---

### Delete Confirmation Dialog

![Delete Confirmation](screenshots/output/2.PNG)

To prevent accidental deletions, the application displays a confirmation dialog before removing a record.

---

## Key Code Components

### Application Setup and Imports

![Application Setup](screenshots/code_snippets/1.PNG)

Imports required Swing, AWT event handling, file handling, and utility classes used throughout the application.

---

### User Interface Components

![UI Components](screenshots/code_snippets/5.PNG)

The application uses:

- JFrame
- JLabel
- JTextField
- JComboBox
- JTable
- JScrollPane
- JButton

to build the graphical user interface.

---

### Input Validation and Record Addition

![Input Validation](screenshots/code_snippets/7.PNG)

The application validates:

- Empty fields
- Numeric quantity values

before inserting data into the table.

---

### Quantity Calculation Logic

![Total Calculation](screenshots/code_snippets/10.PNG)

The total distributed quantity is automatically recalculated whenever records are added or deleted.

---

### File Persistence

![File Handling](screenshots/code_snippets/14.PNG)

Data is stored in a text file using file handling techniques and automatically loaded when the application starts.

---

## How It Works

1. User enters recipient details.
2. Category is selected from the dropdown menu.
3. Quantity and area information are provided.
4. Clicking **Add Recipient** validates and stores the record.
5. Records are displayed in a JTable.
6. Data is saved to `data.txt`.
7. Existing records are loaded automatically on startup.
8. Users can delete selected records through the delete button.
9. The total distributed quantity is updated dynamically.

---

## Data Storage Format

The application stores records in a simple comma-separated format inside `data.txt`.

Example:

```text
Ali,Family,5,Bahria Town
Ahmed,Needy,3,PWD
Fatima,Relative,4,G-13
Usman,Neighbour,2,DHA
```

This allows data to persist between application sessions without requiring a database.

---

## How to Run

### Compile

```bash
javac src/qurbanidistributionmanager/QurbaniDistributionManager.java
```

### Run

```bash
java -cp src qurbanidistributionmanager.QurbaniDistributionManager
```

---

## Concepts Practiced

This project helped strengthen practical understanding of:

- Java Swing GUI Development
- Event-Driven Programming
- JTable and DefaultTableModel
- Input Validation
- File Reading and Writing
- Exception Handling
- Data Persistence
- Java Application Structure

---

## Future Improvements

Possible enhancements include:

- Edit existing records
- Search functionality
- Sorting and filtering
- Export to CSV
- Database integration using MySQL
- Improved UI design using layout managers
- Statistics and reporting features

---

## Author

Muhammad Abdullah

GitHub: https://github.com/abdullahcodes-dev

---
