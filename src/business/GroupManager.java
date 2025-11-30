package business;

import entities.Group;
import entities.Student;

import java.util.Collections;
import java.util.List;

public class GroupManager {
    public void autoDistribute(List<Student> students, List<Group> groups) {
        Collections.shuffle(students);
        System.out.println("🎲 Kura çekiliyor... Öğrenciler karıştırıldı!");

        int groupCount = groups.size();

        for (int i = 0; i < students.size(); i++) {
            Student ogrenci = students.get(i);
            if (ogrenci.isHasGroup()) {
                System.out.println("⚠️ " + ogrenci.getFullName() + " zaten bir grupta, pas geçiliyor.");
                continue;
            }
            int grupSirasi = i % groupCount;
            Group secilenGrup = groups.get(grupSirasi);
            secilenGrup.getStudents().add(ogrenci);
            System.out.println("👉 " + ogrenci.getFullName() + " -> " + secilenGrup.getGroupName() + " grubuna atandı.");
            secilenGrup.getStudents().add(ogrenci);
            ogrenci.setHasGroup(true);
        }
    }
}