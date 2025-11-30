package dataAccess;

import entities.Student;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStudentDao implements StudentDao {

    private List<Student> students;

    @Override
    public List<Student> getAll() {
        return this.students;
    }

    @Override
    public Student getById(int id) {
        for (Student s : students) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public InMemoryStudentDao() {
        this.students = new ArrayList<>();
    }

    @Override
    public void add(Student student) {
        students.add(student);
        System.out.println("Veritabanına eklendi (Ram) " + student.getFullName());
    }
}