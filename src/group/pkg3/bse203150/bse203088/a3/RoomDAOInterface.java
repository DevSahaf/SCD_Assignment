/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package group.pkg3.bse203150.bse203088.a3;

/**
 *
 * @author sahaf
 */
public interface RoomDAOInterface {
    void create(Room room);
    Room read(int roomNo);
    void update(int roomNo, Room room);
    void delete(int roomNo);
}
