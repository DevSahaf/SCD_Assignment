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
public class RoomDAO {
    
    public void create(Room room) {
        Connection conn = DB.connect();
        if (conn == null) {
            System.out.println("Connection Failed");
            return;
        }
        try {
            String query = "INSERT INTO rooms (room_no, type, charges) VALUES (?, ?, ?)";
            PreparedStatement insert = conn.prepareCall(query);
            insert.setInt(1, room.getRoom_no());
            insert.setString(2, room.getType());
            insert.setInt(3, room.getCharges());
            insert.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public Room read(int roomNo) {
        Room room = null;
        Connection conn = DB.connect();

        if (conn == null) {
            System.out.println("Connection failed");
            return null;
        }

        try (PreparedStatement statement = conn.prepareStatement("SELECT * FROM rooms WHERE room_no = ?")) {
            statement.setInt(1, roomNo);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int room_no = resultSet.getInt("room_no");
                    String type = resultSet.getString("type");
                    int charges = resultSet.getInt("charges");

                    room = new Room(room_no, type, charges);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return room;
    }

    
    

    

    
    public void update(int roomNo, Room room) {
        Connection conn = DB.connect();
        if (conn == null) {
            System.out.println("Connection failed");
            return;
        }
        try {
            String query = "UPDATE rooms SET type = ?, charges = ? WHERE room_no = ?";
            PreparedStatement update = conn.prepareCall(query);
            update.setString(1, room.getType());
            update.setInt(2, room.getCharges());
            update.setInt(3, roomNo);
            update.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    
    public void delete(int roomNo) {
        Connection conn = DB.connect();
        if (conn == null) {
            System.out.println("Connection failed");
            return;
        }
        try {
            String query = "DELETE FROM rooms WHERE room_no = ?";
            PreparedStatement del = conn.prepareCall(query);
            del.setInt(1, roomNo);
            del.executeUpdate();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
