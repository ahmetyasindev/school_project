package business;

import dataAccess.AppointmentDao;
import entities.Appointment;

import java.util.List;

public class AppointmentManager {

    private AppointmentDao appointmentDao;

    public AppointmentManager(AppointmentDao appointmentDao) {
        this.appointmentDao = appointmentDao;
    }

    public void add(Appointment appointment) {
        appointmentDao.add(appointment);
    }

    public List<Appointment> getAll() {
        return appointmentDao.getAll();
    }
}