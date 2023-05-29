/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package group.pkg3.bse203150.bse203088.a3;

import java.util.List;

/**
 *
 * @author sahaf
 */
 interface DoctorDAOInterface {
    void create(Doctor doctor);
    Doctor read(int doctorId);
    List<Doctor> getAllDoctors();
    void update(int doctorId, Doctor doctor);
    void delete(int doctorId);
}
