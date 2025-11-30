package dataAccess;

import entities.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);

    List<Student> getAll();

    Student getById(int id);
}
