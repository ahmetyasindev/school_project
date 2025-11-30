package business;

import dataAccess.StudentDao;
import entities.Student;

import java.util.List;
import java.util.Collections;

public class StudentManager {
    private StudentDao studentDao;

    public StudentManager(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    public void add(Student student) {
        studentDao.add(student);
    }

    public List<Student> getAll() {
        return studentDao.getAll();
    }

    public Student getById(int id) {
        return studentDao.getById(id);
    }

    public void distributeAssignments(List<String> topics) {

        Collections.shuffle(topics);
        System.out.println("\n📚 Ödev Konuları Karıştırıldı ve Dağıtılıyor...");

        List<Student> students = studentDao.getAll();

        for (int i = 0; i < students.size(); i++) {
            Student ogrenci = students.get(i);

            String konu = topics.get(i % topics.size());

            ogrenci.setIndividualAssignment(konu);
            ogrenci.setAssignmentCompleted(false);

            System.out.println("📝 " + ogrenci.getFullName() + " -> Konu: " + konu);
        }
    }

    public void changeAttendance(int id, boolean isPresent) {
        Student student = studentDao.getById(id);

        if (student != null) {
            student.setPresent(isPresent);
            String durum = isPresent ? "VAR" : "YOK";
            System.out.println("✅ " + student.getFullName() + " olarak işaretlendi: " + durum);
        } else {
            System.out.println("❌ Öğrenci bulunamadı!");
        }
    }

    public void assignHomeworkToStudent(int studentId, String homeworkTopic) {
        Student student = studentDao.getById(studentId);

        if (student != null) {
            student.setIndividualAssignment(homeworkTopic);
            student.setAssignmentCompleted(false);

            System.out.println("✅ BAŞARILI: " + student.getFullName() + " adlı öğrenciye '" + homeworkTopic + "' ödevi verildi.");
        } else {
            System.out.println("❌ HATA: " + studentId + " numaralı öğrenci bulunamadı!");
        }
    }

}


