package com.ge.JDBC;
/*Step 1 : Import the package and upload the JAR File.*/
import java.sql.*;

public class LaunchApplication {
    public static void main(String args[]) {

        Connection connect = null;
        Statement statement = null;

        try {

            /*Step 2: Load and Register the Driver from the JAR File*/
            Class.forName("org.postgresql.Driver");

            /*Step 3 : Establish the connection to the Database.*/
            connect = DriverManager.getConnection("jdbc:postgresql://localhost:5432/JDBC", "likhith", "Likhith@31");

            /*Step 4: Create the Statement Object*/
            statement = connect.createStatement();

            /*Step 5: Execute the Query*/
            /*Inserting the data into the Database*/
        /*
        String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(2,'Manoj',24,'Guntur')";
        int rowsAffected = statement.executeUpdate(sql);

        // Step 6: Process the Result
        if(rowsAffected == 0){
            System.out.println("Unable to insert the data.");
        }
        else{
            System.out.println("Data Inserted Successfully.");
        }
        */

            /*Updating the data in the Database*/
        /*
        String sql = "UPDATE studentinfo SET sage = 25 WHERE id = 2";
        int rowsAffected = statement.executeUpdate(sql);

        if(rowsAffected == 0){
            System.out.println("Update Failed.");
        }
        else{
            System.out.println("Update Successfull!");
        }
        */

            /*Retrieve the data from the Database*/
        /*
        String sql = "SELECT * FROM studentinfo";
        ResultSet rs = statement.executeQuery(sql);

        while(rs.next()){
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
            System.out.println(rs.getInt("id") + " " + rs.getString("sname") + " " + rs.getInt("sage") + " " + rs.getString("scity"));
        }
        */

            /*Deleting the data from the Database*/
        /*
        String sql = "DELETE FROM studentinfo WHERE id=1";
        int rowsAffected = statement.executeUpdate(sql);

        if(rowsAffected == 0){
            System.out.println("Failed to delete the record.");
        }
        else{
            System.out.println("Record deleted Successfully!");
        }
        */

            /*Executing CRUD operation with single execute() method*/
            String sql = "SELECT * FROM studentinfo";
            boolean status = statement.execute(sql);

            if (status) {
                /*This block gets executed if the query is SELECT statement*/
                System.out.println("If Block");
                ResultSet rs = statement.getResultSet();
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getInt(3) + " " + rs.getString(4));
                }
            } else {
                /*This block gets executed if it is either of insert, update or delete statements*/
                System.out.println("Else Block");
                int rowsAffected = statement.getUpdateCount();
                if (rowsAffected == 0) {
                    System.out.println("Operation Failed");
                } else {
                    System.out.println("Operation Successfull!");
                }
            }
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        finally{
            /*Step 7: Close the Resources*/
            try {
                statement.close();
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
