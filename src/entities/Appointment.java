package entities;

public class Appointment {
    private int id;
    private String appointmentDate;
    private Group group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Appointment(int id, String appointmentDate, Group group) {
        this.id = id;
        this.appointmentDate = appointmentDate;
        this.group = group;


    }
}
