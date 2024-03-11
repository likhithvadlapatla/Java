package com.ge.JDBC;
/*Step 1 : Import the package and upload the JAR File.*/
import java.sql.*;
import java.util.Scanner;

public class JDBCPreparedStatement {
    public static void main(String args[]) throws SQLException {

        Connection connect = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try
        {
            connect = JDBCUtil.getConnection();
            /*
            String query = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(?,?,?,?)";
            preparedStatement = connect.prepareStatement(query);

            System.out.println("Please enter the following details to be stored in DB");
            Scanner sc = new Scanner(System.in);

            System.out.println("Enter your ID : ");
            Integer id = sc.nextInt();

            System.out.println("Enter your name : ");
            String name = sc.next();

            System.out.println("Enter your age : ");
            Integer age = sc.nextInt();

            System.out.println("Enter your city : ");
            String city = sc.next();

            preparedStatement.setInt(1, id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, city);
            */

            /*
            String query = "UPDATE studentinfo SET sage = ? WHERE id = ?";
            preparedStatement = connect.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter the information that needs to be updated");
            System.out.println("Enter your ID : ");
            Integer id = sc.nextInt();
            System.out.println("Please enter your age to be updated : ");
            Integer age = sc.nextInt();

            preparedStatement.setInt(1, age);
            preparedStatement.setInt(2, id);
            */

            /*
            String query = "DELETE FROM studentinfo WHERE id = ?";
            preparedStatement = connect.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("Please enter info that needs to be Deleted");
            System.out.println("Enter your id : ");
            Integer id = sc.nextInt();
            preparedStatement.setInt(1, id);

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 0){
                System.out.println("Unable to delete the data");
            }
            else{
                System.out.println("Data Deleted Successfully!");
            }
            */

            /*
            String query = "SELECT id, sname, sage, scity FROM studentinfo WHERE id = ?";
            preparedStatement = connect.prepareStatement(query);

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your id for which data to be Retrieved : ");
            Integer id = sc.nextInt();
            preparedStatement.setInt(1,id);

            rs = preparedStatement.executeQuery();

            if(rs.next())
            {
                Integer sid = rs.getInt(1);
                String sname = rs.getString(2);
                Integer sage = rs.getInt(3);
                String scity = rs.getString(4);
                System.out.println(sid + " " + sname + " " + sage + " " + scity);
            }
            else
            {
               System.out.println("There is no record with id : "+ id);
            }
            */

            /*Batch Update*/
            /*This is only applicable for Update, Delete and Insert*/
            String query = "UPDATE studentinfo SET sage = ? WHERE id = ?";
            preparedStatement = connect.prepareStatement(query);

            preparedStatement.setInt(1,24);
            preparedStatement.setInt(2,2);
            preparedStatement.addBatch();
            preparedStatement.setInt(1,25);
            preparedStatement.setInt(2,3);
            preparedStatement.addBatch();

            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 0){
                System.out.println("Unable to update the data");
            }
            else{
                System.out.println("Data Updated Successfully!");
            }
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
            JDBCUtil.closeConnection(connect, preparedStatement);
        }
    }
}
