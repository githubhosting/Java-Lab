# Installation and Setup of JDBC:

## Step 1: Install MySQL Connector/J
- Visit [MySQL Connector/J download page](https://dev.mysql.com/downloads/connector/j/).
- Choose the "Platform Independent" option.
- Download the zip file and extract it to a known folder.

## Step 2: Configure VS Code for Java Project
- Open VS Code and create a new Java project.
- In the left panel, navigate to "JAVA PROJECTS," expand it, and then expand "Referenced Libraries."
- Click on the plus icon.

## Step 3: Add MySQL Connector/J to Project
- Select the JAR file from the extracted zip folder.

# Setting Up Database:

## Step 4: Open XAMPP and Access MySQL Command Line
- Open the XAMPP folder in the C drive.
- Navigate to `mysql > bin` and open the command prompt (cmd) in that folder.

## Step 5: Connect to MySQL Server
- Run the command: `mysql -u root`

# Coding and Database Configuration:

## Step 6: Create Java File and Run Code
- Create a file named `StudentDatabaseCRUD.java` and execute the code.

## Step 7: Create Database in MySQL Terminal
- Execute the following code in the interactive MySQL terminal:
  - [MySQL Terminal Code](https://gist.github.com/myselfshravan/73f199ddff959af67f57590173d1e8b1)

## Step 8: Update JDBC URL
- Change the JDBC URL in your code by appending the database name at the end.

# Final Steps:

## Step 9: Run the Code
- Execute your Java code after setting up the database and updating the JDBC URL.
  - [Java Code](https://gist.github.com/myselfshravan/52cac49f8d9bfa19ca63a3344cc4fadc)

# Additional Step (if XAMPP control panel cannot be used):

## Step 10: Stop MySQL Service
- If you are unable to start XAMPP from the control panel:
  - Ensure the current MySQL service is stopped.
  - Open the Run dialog (press Windows key + R).
  - Type `services.msc` and press Enter.
  - In the Services window, locate the service named MySQL80.
  - Right-click on it and select "Stop" to halt the service.

**Note:** 

## Step 11: Set MySQL User Credentials in Code
- In your Java code (`StudentDatabaseCRUD.java`):
  - Keep the following credentials:
    - Username: "root"
    - Password: "" (null or empty)

**All Codes:**
[Java Lab GitHub Repository](https://github.com/githubhosting/Java-Lab)
