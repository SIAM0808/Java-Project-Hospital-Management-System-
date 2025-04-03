
# Hospital Management System

![Java](https://img.shields.io/badge/Java-17-orange) ![Swing](https://img.shields.io/badge/Swing-GUI-blue) ![MySQL](https://img.shields.io/badge/MySQL-Database-green)

Welcome to the **Hospital Management System**, a Java-based desktop application designed to streamline hospital operations. Built with Java Swing for the GUI and MySQL for data management, this system provides an intuitive interface for managing patients, employees, rooms, departments, ambulances, and more.

## Table of Contents
- [Features](#features)
- [Screenshots](#screenshots)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Usage](#usage)
- [Project Structure](#project-structure)
- [Technologies Used](#technologies-used)
- [Contributing](#contributing)
- [License](#license)

## Features
- **User Authentication**: Secure login system for staff members.
- **Patient Management**:
  - Add new patients with details like ID, name, gender, disease, room number, and deposit.
  - View all patient information in a tabular format.
  - Update patient details (room, time, payment).
  - Discharge patients and update room availability.
- **Room Management**:
  - View all room details (room number, availability, price, status).
  - Search rooms by availability status.
- **Employee Management**: Display employee information (name, age, phone number, salary, etc.).
- **Department Management**: List departments with their contact numbers.
- **Ambulance Tracking**: View ambulance details (name, gender, availability, car name).
- **Reception Dashboard**: Centralized interface with quick access to all features.
- **Dynamic UI**: Responsive design with moving text banners and custom table renderers.

## Screenshots
*Add screenshots here once available. For now, imagine a sleek GUI with tables and buttons!*

## Prerequisites
- **Java Development Kit (JDK)**: Version 17 or higher.
- **MySQL**: A running MySQL server (e.g., localhost:3306).
- **MySQL Connector/J**: JDBC driver for Java-MySQL integration.
- **IDE**: IntelliJ IDEA, Eclipse, or any Java-supporting IDE (optional).

## Installation
1. **Clone the Repository**:
   ```bash
   git clone https://github.com/yourusername/hospital-management-system.git
   cd hospital-management-system
   ```

2. **Set Up MySQL Database**:
   - Create a database named `hospital_management_system`.
   - Import the schema (create tables like `patient_info`, `room`, `EMP_info`, `department`, `Ambulance`, `login`) or write SQL queries based on the code.
   - Update the `conection.java` file with your MySQL credentials:
     ```java
     connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital_management_system", "root", "your_password");
     ```

3. **Add Dependencies**:
   - Ensure `mysql-connector-java-x.x.xx.jar` and `rs2xml.jar` (for `DbUtils`) are in your project’s classpath.
   - Example for Maven (optional):
     ```xml
     <dependency>
         <groupId>mysql</groupId>
         <artifactId>mysql-connector-java</artifactId>
         <version>8.0.33</version>
     </dependency>
     <dependency>
         <groupId>net.proteanit.sql</groupId>
         <artifactId>rs2xml</artifactId>
         <version>1.0</version>
     </dependency>
     ```

4. **Run the Application**:
   - Compile and run `Login.java` as the entry point:
     ```bash
     javac -cp .:path/to/jars/* hospital_management_system/Login.java
     java -cp .:path/to/jars/* hospital_management_system.Login
     ```

## Usage
1. **Login**: Enter your username and password (stored in the `login` table).
2. **Reception Dashboard**: Use the buttons to navigate to different modules:
   - Add a new patient.
   - View room availability or search for specific rooms.
   - Check employee, department, or ambulance details.
   - Discharge patients or update their records.
3. **Logout**: Return to the login screen when done.

## Project Structure
```
hospital_management_system/
├── All_Patient_info.java      # Displays all patient details
├── ambulance.java             # Ambulance information viewer
├── conection.java             # Database connection handler
├── Department.java            # Department list viewer
├── Emplyoee_info.java         # Employee information viewer
├── Login.java                 # Login screen and authentication
├── NEW_PATIENT.java           # Form to add new patients
├── patient_discharge.java     # Patient discharge functionality
├── Reception.java             # Main dashboard
├── ROOM.java                  # Room details viewer
├── search_room.java           # Room search by availability
├── update_patient_details.java# Update patient information
└── Icons/                     # Folder for GUI images (e.g., login.png, patient.jpg)
```

## Technologies Used
- **Java**: Core programming language.
- **Swing**: For building the graphical user interface.
- **MySQL**: Relational database for storing hospital data.
- **JDBC**: Java Database Connectivity for database interaction.
- **rs2xml**: Utility to convert ResultSet to TableModel.

## Contributing
Contributions are welcome! Here’s how you can help:
1. Fork the repository.
2. Create a new branch (`git checkout -b feature-branch`).
3. Make your changes and commit (`git commit -m "Add feature"`).
4. Push to your branch (`git push origin feature-branch`).
5. Open a Pull Request.

Please ensure your code follows the existing style and includes appropriate comments.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
```

