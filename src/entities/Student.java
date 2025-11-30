package entities;

public class Student {
    private int id;
    private String fullName;
    private String studentNumber;
    private String individualAssignment;
    private boolean isAssignmentCompleted;
    private boolean isPresent;
    private boolean hasGroup;

    public Student(int id, String fullName, String studentNumber, String individualAssignment, boolean isAssignmentCompleted) {
        this.id = id;
        this.fullName = fullName;
        this.studentNumber = studentNumber;
        this.individualAssignment = individualAssignment;
        this.isAssignmentCompleted = isAssignmentCompleted;

    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getIndividualAssignment() {
        return individualAssignment;
    }

    public void setIndividualAssignment(String individualAssignment) {
        this.individualAssignment = individualAssignment;
    }

    public boolean isAssignmentCompleted() {
        return isAssignmentCompleted;
    }

    public void setAssignmentCompleted(boolean assignmentCompleted) {
        this.isAssignmentCompleted = assignmentCompleted;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isPresent() {
        return isPresent;
    }

    public void setPresent(boolean present) {
        isPresent = present;
    }

    public boolean isHasGroup() {
        return hasGroup;
    }

    public void setHasGroup(boolean hasGroup) {
        this.hasGroup = hasGroup;
    }
}