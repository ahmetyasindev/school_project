package entities;

import java.util.List; // Bunu import etmeyi unutma
import java.util.ArrayList;

public class Group {
    private int id;
    private String groupName;
    private String projectTopic;
    private List<Student> students;

    public Group(int id, String groupName, String projectTopic) {
        this.id = id;
        this.groupName = groupName;
        this.projectTopic = projectTopic;
        this.students = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getProjectTopic() {
        return projectTopic;
    }

    public void setProjectTopic(String projectTopic) {
        this.projectTopic = projectTopic;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
