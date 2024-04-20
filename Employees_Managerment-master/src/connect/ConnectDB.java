package connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class ConnectDB {
	static final String DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/useraccount";
    static final String USER = "root";
    static final String PASS = "";

    
    public static List<Employee> getEmployee() throws ClassNotFoundException, SQLException {
        
    	Statement stmt = null;
        Connection conn = null;
        List<Employee> list = new ArrayList<>();
        try {
            System.out.println("STEP 1: Register JDBC driver");
            Class.forName(DRIVER_CLASS);

            System.out.println("STEP 2: Open a connection");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            System.out.println("STEP 3: Execute a query");
            stmt = conn.createStatement();
            
            ResultSet rs = stmt.executeQuery("SELECT * FROM Employee");

            System.out.println("STEP 4: Extract data from result set");
         
            while(rs.next()) {
            	int employyeID = rs.getInt("employeeID");
            	String firstName= rs.getString("firstName");
            	String lastName = rs.getString("lastName");
            	String dateOfBirth = rs.getString("dateOfBirth");
            	String gender = rs.getString("");
            	int departmentID = rs.getInt("departmentID");
            	//list.add(new Employee(employyeID, firstName, lastName, dateOfBirth, gender, departmentID));
            }
            rs.close();
            
        } catch (SQLException e) {
            throw e;
        } finally {
            System.out.println("STEP 5: Close connection");
            if (stmt != null)
                stmt.close();
            if (conn != null)
                conn.close();

        }
        
        System.out.println("Done!");
        return list;
    }
    
    public static void addEmployee(Employee e) throws ClassNotFoundException, SQLException {

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            System.out.println("STEP 1: Register JDBC driver");
            Class.forName(DRIVER_CLASS);

            System.out.println("STEP 2: Open a connection");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            System.out.println("STEP 3: Execute a query");

            String sql = "INSERT INTO user (employeeID,firstName,lastName,dateOfBirth,gender,departmentiD) VALUES (?, ?, ?, ?, ?, ?)";
            //statement = conn.prepareStatement(sql);
            //statement.setInt(1, e.getEmployeeID());
            //statement.setString(2,e.getFirstName());
            //statement.setString(3,e.getLastName());
            //statement.setString(4,e.getDateOfBirth());
            //statement.setString(5,e.getGender());
            //statement.setInt(1, e.getDepartmentID());
            System.out.println("STEP 4: Execute the INSERT statement");
            statement.executeUpdate();

            System.out.println("Data added to the user table");

        } catch (SQLException a) {
            throw a;
        } finally {
            System.out.println("STEP 5: Close connection");
            if (statement != null)
                statement.close();
            if (conn != null)
                conn.close();
        }
        System.out.println("Done!");
    }
}
