package dataAccess;

import entities.Appointment;

import java.util.List;

public interface AppointmentDao {
    void add(Appointment appointment);

    List<Appointment> getAll();
}