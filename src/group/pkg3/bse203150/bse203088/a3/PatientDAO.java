/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group.pkg3.bse203150.bse203088.a3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sahaf
 */
public class PatientDAO {
    public void create(Patient patient) {
        Connection conn = DB.connect();
        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return;
        }
        try {
            String query = "INSERT INTO patients (patient_id, name, father_name, emailID, contact, address, gender, blood_group, age, info) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement insert = conn.prepareCall(query);
            insert.setInt(1, patient.getPatient_id());
            insert.setString(2, patient.getName());
            insert.setString(3, patient.getFather_name());
            insert.setString(4, patient.getEmailID());
            insert.setInt(5, patient.getContact());
            insert.setString(6, patient.getAddress());
            insert.setString(7, patient.getGender());
            insert.setString(8, patient.getBlood_group());
            insert.setInt(9, patient.getAge());
            insert.setString(10, patient.getInfo());
            insert.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public int find(int patientId) {
        int count = 0;
        Connection conn = DB.connect();

        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return -1;
        }

        try (PreparedStatement statement = conn.prepareStatement("SELECT COUNT(*) as count FROM patients WHERE patient_id = ?")) {
            statement.setInt(1, patientId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    count = resultSet.getInt("count");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return count;
    }

    
    public Patient read(int patientId) {
        Patient patient = null;
        Connection conn = DB.connect();

        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return null;
        }

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM patients WHERE patient_id = ?")) {
            statement.setInt(1, patientId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("patient_id");
                    String name = resultSet.getString("name");
                    String father_name = resultSet.getString("father_name");
                    String emailID = resultSet.getString("emailID");
                    int contact = resultSet.getInt("contact");
                    String address = resultSet.getString("address");
                    String gender = resultSet.getString("gender");
                    String blood_group = resultSet.getString("blood_group");
                    int age = resultSet.getInt("age");
                    String info = resultSet.getString("info");

                    patient = new Patient(id, name, father_name, emailID, contact, address, gender, blood_group, age, info);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return patient;
    }

    

    
    public void update(int patientId, Patient patient) {
        Connection conn = DB.connect();
        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return;
        }
        try {
            String query = "UPDATE patients SET name = ?, father_name = ?, emailID = ?, contact = ?, address = ?, gender = ?, blood_group = ?, age = ?, info = ? WHERE patient_id = ?";
            PreparedStatement insert = conn.prepareCall(query);
            insert.setString(1, patient.getName());
            insert.setString(2, patient.getFather_name());
            insert.setString(3, patient.getEmailID());
            insert.setInt(4, patient.getContact());
            insert.setString(5, patient.getAddress());
            insert.setString(6, patient.getGender());
            insert.setString(7, patient.getBlood_group());
            insert.setInt(8, patient.getAge());
            insert.setString(9, patient.getInfo());
            insert.setInt(10, patientId);
            insert.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void delete(int patientId) {
        Connection conn = DB.connect();
        if (conn == null) {
            System.out.println("Couldn't establish connection");
            return;
        }
        try {
            String query = "DELETE FROM patients WHERE patient_id = ?";
            PreparedStatement delete = conn.prepareCall(query);
            delete.setInt(1, patientId);
            delete.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
