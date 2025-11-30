package dataAccess;

import entities.Appointment;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAppointmentDao implements AppointmentDao {

    private List<Appointment> appointments;

    public InMemoryAppointmentDao() {
        this.appointments = new ArrayList<>();
    }

    @Override
    public void add(Appointment appointment) {
        appointments.add(appointment);
        System.out.println("🗓️ Randevu Oluşturuldu: " + appointment.getAppointmentDate() + " -> " + appointment.getGroup().getGroupName());
    }

    @Override
    public List<Appointment> getAll() {
        return this.appointments;
    }
}