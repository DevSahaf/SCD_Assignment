/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group.pkg3.bse203150.bse203088.a3;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author sahaf
 */
public class DB {
    public static Connection connect()  {
       try {
            
            String url = "jdbc:mysql://localhost:3306/HospitalDB";
            return DriverManager.getConnection(url, "root", "");
        } catch (SQLException e) {
           System.out.format("An error occurred: %s\n", e.getMessage());
         

        return null;
    }
    }
    public DB() {
        Connection conn = DB.connect();
        if (conn == null) {
            System.out.println("Connection Failed");
            return;
}

        try {
            Statement statement = conn.createStatement();
            String createdocterTable = "CREATE TABLE IF NOT EXISTS doctors ("
                    + "id INT  PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "father_name VARCHAR(255) NOT NULL,"
                    + "emailID VARCHAR(255) NOT NULL,"
                    + "contact INT NOT NULL,"
                    + "address VARCHAR(255) NOT NULL,"
                    + "Qualification VARCHAR(255) NOT NULL,"
                    + "gender VARCHAR(255) NOT NULL,"
                    + "blood_group VARCHAR(255) NOT NULL,"
                    +"joiningDate VARCHAR(255) NOT NULL"
                    + ")";
            statement.executeUpdate(createdocterTable);

            
            String createPatientTable = "CREATE TABLE IF NOT EXISTS patients ("
                    +"patient_id INT  PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "father_name VARCHAR(255) NOT NULL,"
                    + "emailID VARCHAR(255) NOT NULL,"
                    + "contact INT NOT NULL,"
                    + "address VARCHAR(255) NOT NULL,"
                    + "gender VARCHAR(255) NOT NULL,"
                    + "blood_group VARCHAR(255) NOT NULL,"
                    +"age int NOT NULL,"
                    + "info VARCHAR(255) NOT NULL"
                    + ")";
            statement.executeUpdate(createPatientTable);
            
            String createRoomTable = "CREATE TABLE IF NOT EXISTS rooms ("
                    + "room_no INT  PRIMARY KEY,"
                    + "type VARCHAR(255) NOT NULL,"
                    + "charges INT NOT NULL"
                    + ")";
            statement.executeUpdate(createRoomTable);
            String createServicesTable = "CREATE TABLE IF NOT EXISTS services ("
                    + "name VARCHAR(255) NOT NULL,"
                    + "date VARCHAR(255) NOT NULL,"
                    + "charges INT NOT NULL,"
                    + "patient_id INT NOT NULL,"
                    + "patient_name VARCHAR(255) NOT NULL"
                    + ")";
            statement.executeUpdate(createServicesTable);
            String createPatientAdmissionTable = "CREATE TABLE IF NOT EXISTS patient_admission ("
        + "patientID INT NOT NULL,"
        + "name VARCHAR(255) NOT NULL,"
        + "docID INT NOT NULL,"
        + "docName VARCHAR(255) NOT NULL,"
        + "disease VARCHAR(255) NOT NULL,"
        + "gender VARCHAR(255) NOT NULL,"
        + "remarks VARCHAR(255) NOT NULL,"
        + "bloodGroup VARCHAR(255) NOT NULL,"
        + "admissionDate VARCHAR(255) NOT NULL,"
        + "roomNo INT NOT NULL"
        + ")";
statement.executeUpdate(createPatientAdmissionTable);

            conn.close();
        }
        catch (SQLException e) {
            System.out.format("ERROR: %s", e.getMessage());
        }
    }
    
}
