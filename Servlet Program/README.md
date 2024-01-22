# Setting Up Eclipse and Tomcat for Servlet Development

## Part A: Eclipse and Tomcat Configuration

### Step 1: Downloading Software

1. **Download Eclipse IDE and Apache Tomcat**: Choose the latest versions for better features and improved security. The packages are available in zip format.

2. **Install Tomcat**: Use the appropriate Windows Service Installer (32-bit or 64-bit depending on your system).

### Step 2: Configuring Tomcat in Eclipse

1. **Set Up Tomcat Runtime Environment**:
   - In Eclipse, navigate to `Windows` > `Preferences`.
   - Select `Server` > `Runtime Environments`.
   - Click on `Add` to configure a new server runtime environment.
   - Choose the version of Apache Tomcat you have installed (e.g., Tomcat v10.1).
   - Provide the path to the Tomcat installation directory (usually `C:\Program Files\Apache Software Foundation\Tomcat 10.1`).

2. **Add Server to Eclipse**:
   - In the `Servers` view, right-click and select `New` > `Server`.
   - Select Apache Tomcat v10.1 from the server type list.
   - Set the Tomcat installation directory and click `Finish`.

## Part B: Creating and Running a Servlet

### Step 1: Create a Dynamic Web Project

1. **Create Project**:
   - Go to `File` > `New` > `Dynamic Web Project`.
   - Enter your project name (e.g., `ServletProgram`).
   - Click `Finish`.

### Step 2: Add Servlet API JAR

1. **Include Servlet API**:
   - Right-click on your project in the Project Explorer.
   - Go to `Build Path` > `Configure Build Path`.
   - Click on the `Libraries` tab within the Java Build Path settings.
   - Click `Add External JARs`.
   - Navigate to your Tomcat installation's `lib` directory.
   - Select the `servlet-api.jar` file and click `OK`.

### Step 3: Create a Servlet

1. **Generate Servlet**:
   - Expand your project in the Project Explorer to find `Java Resources`.
   - Right-click on the `src` directory and go to `New` > `Servlet`.
   - Name your servlet (e.g., `HelloServlet`).
   - Ensure `doGet()` is selected and other methods are unchecked.
   - Click `Next`, then `Finish`.

### Step 4: Running the Servlet

1. **Deploy and Start Server**:
   - Right-click on your project in the Project Explorer.
   - Select `Run As` > `Run on Server`.
   - Choose the configured Tomcat server.
   - Click `Finish`.

After following these steps, your servlet should be accessible via the Tomcat server. If you encounter any issues, double-check the configuration settings and ensure that your project structure is correct. Remember to consult the official Eclipse and Tomcat documentation for more detailed instructions and troubleshooting tips.

# Creating and Configuring a Servlet in Eclipse

After setting up your Eclipse IDE and Tomcat server, you can create a servlet to handle web requests. Below are the steps and a sample Java servlet class named `VoterSrv` that you can use as a starting point.

## Steps to Create a Servlet

1. **Open Eclipse IDE**: Launch the Eclipse IDE and open the Dynamic Web Project where you want to create your servlet.

2. **Create a Servlet**:
   - In the Project Explorer, right-click on the `src` folder within your project.
   - Navigate to `New` > `Servlet`.
   - In the `Class name` field, enter `VoterSrv`.
   - Click `Next`. On the next screen, you can configure servlet initialization parameters and URL mappings if needed.
   - Click `Next` again. On this screen, you can select which HTTP methods you want to provide implementations for. For this servlet, ensure `service` is selected since we will be overriding it.
   - Click `Finish` to create the servlet class.

3. **Write Your Servlet Code**:
   - The newly created `VoterSrv.java` file should be open in the editor.
   - Replace any generated code with the Java code provided below.

## Servlet Java Code (`VoterSrv.java`)

Here is the Java servlet code that you can copy into your `VoterSrv.java` file:

```java
import java.io.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;

public class VoterSrv extends HttpServlet {

    public void service(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        res.setContentType("text/html");
        PrintWriter pw = res.getWriter();
        String name = req.getParameter("name");
        int age = 0;

        try {
            age = Integer.parseInt(req.getParameter("age"));
        } catch (NumberFormatException e) {
            pw.println("<font color='red' size='4'>Invalid age. Please enter a numeric value.</font>");
            pw.println("<br><br><a href='index.html'>Back</a>");
            pw.close();
            return;
        }

        if (age >= 18) {
            pw.println("<font color='green' size='4'>Welcome " + name + " to this site.</font>");
        } else {
            pw.println("<font color='red' size='4'>Hello " + name + ", you are not authorized to visit the site.</font>");
        }
        pw.println("<br><br><a href='index.html'>Back</a>");
        pw.close();
    }
}
```

## Important Notes

- The `service` method is a generic method to handle HTTP requests and is not specific to GET or POST methods. If you want to handle specific HTTP methods, override `doGet` or `doPost` instead.
- The above code includes a try-catch block to handle `NumberFormatException`, which is a common exception when parsing integers.
- Always validate and sanitize inputs from users to avoid security issues like XSS (Cross-site Scripting).

Once the servlet is written, you can deploy and run your project on the Tomcat server as described in the previous instructions. Your servlet is now set up to respond to web requests, check the age parameter, and return a response based on the logic you've provided.

---

Certainly! Here are the steps to run a servlet program in Eclipse with Apache Tomcat:

1. **Add Tomcat Server to Eclipse**:
   - Go to `Windows` > `Preferences` > `Server` > `Runtime Environments`.
   - Click `Add` to configure a new Apache Tomcat server (version 10.1 or 10).
   - Check the option to `Create a new local server`.
   - Set the `Tomcat installation directory` (e.g., `C:\Program Files\Apache Software Foundation\Tomcat 10.1`).

2. **Start Tomcat Server**:
   - In the bottom pane of Eclipse, right-click on the server and select `Start`.
   - If the server doesn't start, double-click on it and change the admin port from 8005 to 8006.

3. **Create a New Dynamic Web Project**:
   - Ensure `Target runtime` is set to Apache Tomcat.
   - Check the option to `Generate web.xml deployment descriptor`.

4. **Add Servlet API to Build Path**:
   - Right-click on the project, go to `Build Path` > `Configure Build Path`.
   - Under `Modulepath`, click `Add External JARs`.
   - Navigate to the Tomcat `lib` directory and select the `servlet-api.jar`.

5. **Create a Servlet**:
   - Right-click on the project, go to `New` > `Servlet`.
   - Set the `Class name` to match the Java file name.
   - Only `doPost` and `doGet` methods should be checked.
   - Use `jakarta.servlet` instead of `javax.servlet` for Tomcat 10.1 compatibility.

6. **Run the Servlet**:
   - Right-click on the Java file, select `Run As` > `Run on Server`.
   - Choose the configured Tomcat server.
   - Click `Next`, then `Finish`.
   - If necessary, restart the server.

7. **Create HTML File**:
   - Place the HTML file under the `webapp` directory.
   - In the form action within the HTML code, set `action="check"` to match the servlet URL pattern.

8. **Save Java File**:
   - Ensure the Java servlet file is saved within the `Java` folder of the project structure.

9. **Modify `web.xml`**:
   - Locate the `web.xml` file under `WEB-INF` within the `webapp` directory.
   - Switch to the `Source` tab to edit the code.
   - Add servlet and servlet-mapping configurations.
   - The servlet name and servlet class should match the Java class name.
   - Set the URL pattern to `/check`.

10. **Restart the Server**:
    - If you made changes to `web.xml` or the servlet code, restart the Tomcat server to apply the changes.

By following these steps, you can configure, run, and test a servlet-based web application in Eclipse with Tomcat.