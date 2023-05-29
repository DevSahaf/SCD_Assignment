/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package group.pkg3.bse203150.bse203088.a3;

/**
 *
 * @author sahaf
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

class DoctorDAO implements DoctorDAOInterface {
    @Override
    public void create(Doctor doctor) {
        Connection connect = DB.connect();
        if (connect == null) {
            System.out.println("Couldn't establish connection");
            return;
        }
        try {
            String query = "INSERT INTO doctors (id, name, father_name, emailID, contact, address, qualification, gender, blood_group, joiningDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connect.prepareCall(query);
            stmt.setInt(1, doctor.getId());
            stmt.setString(2, doctor.getName());
            stmt.setString(3, doctor.getFatherName());
            stmt.setString(4, doctor.getEmailID());
            stmt.setInt(5, doctor.getContact());
            stmt.setString(6, doctor.getAddress());
            stmt.setString(7, doctor.getQualification());
            stmt.setString(8, doctor.getGender());
            stmt.setString(9, doctor.getBloodGroup());
            stmt.setString(10, doctor.getJoiningDate());
            stmt.executeUpdate();
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Doctor read(int doctorId) {
        Doctor doctor = null;
        Connection connect = DB.connect();

        if (connect == null) {
            System.out.println("Couldn't establish connection");
            return null;
        }

        try (PreparedStatement statement = connect.prepareStatement("SELECT * FROM doctors WHERE id = ?")) {
            statement.setInt(1, doctorId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String fatherName = resultSet.getString("father_name");
                    String emailID = resultSet.getString("emailID");
                    int contact = resultSet.getInt("contact");
                    String address = resultSet.getString("address");
                    String qualification = resultSet.getString("qualification");
                    String gender = resultSet.getString("gender");
                    String bloodGroup = resultSet.getString("blood_group");
                    String joiningDate = resultSet.getString("joiningDate");

                    doctor = new Doctor(id, name, fatherName, emailID, contact, address, qualification, gender, bloodGroup, joiningDate);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctor;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors = new ArrayList<>();
        Connection connect = DB.connect();

        if (connect == null) {
            System.out.println("Couldn't establish connection");
            return doctors;
        }

        try (PreparedStatement statement = connect.prepareStatement("SELECT * FROM doctors");
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String fatherName = resultSet.getString("father_name");
                String emailID = resultSet.getString("emailID");
                int contact = resultSet.getInt("contact");
                String address = resultSet.getString("address");
                String qualification = resultSet.getString("qualification");
                String gender = resultSet.getString("gender");
                String bloodGroup = resultSet.getString("blood_group");
                String joiningDate = resultSet.getString("joiningDate");

                Doctor doctor = new Doctor(id, name, fatherName, emailID, contact, address, qualification, gender, bloodGroup, joiningDate);
                doctors.add(doctor);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return doctors;
    }

    @Override
    public void update(int doctorId, Doctor doctor) {
        Connection connect = DB.connect();
        if (connect == null) {
            System.out.println("Couldn't establish connection");
            return;
        }
        try {
            String query = "UPDATE doctors SET name = ?, father_name = ?, emailID = ?, contact = ?, address = ?, qualification = ?, gender = ?, blood_group = ?, joiningDate = ? WHERE id = ?";
            PreparedStatement stmt = connect.prepareCall(query);
            stmt.setString(1, doctor.getName());
            stmt.setString(2, doctor.getFatherName());
            stmt.setString(3, doctor.getEmailID());
            stmt.setInt(4, doctor.getContact());
            stmt.setString(5, doctor.getAddress());
            stmt.setString(6, doctor.getQualification());
            stmt.setString(7, doctor.getGender());
            stmt.setString(8, doctor.getBloodGroup());
            stmt.setString(9, doctor.getJoiningDate());
            stmt.setInt(10, doctorId);
            stmt.executeUpdate();
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(int doctorId) {
        Connection connect = DB.connect();
        if (connect == null) {
            System.out.println("Couldn't establish connection");
            return;
        }
        try {
            String query = "DELETE FROM doctors WHERE id = ?";
            PreparedStatement stmt = connect.prepareCall(query);
            stmt.setInt(1, doctorId);
            stmt.executeUpdate();
            connect.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}


