/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package group.pkg3.bse203150.bse203088.a3;

/**
 *
 * @author sahaf
 */
public interface PatinetDAOInterface {
    void create(Patient patient);
    int find(int patientId);
    Patient read(int patientId);
    
    void update(int patientId, Patient patient);
    void delete(int patientId);
    
}
