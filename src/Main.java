import business.AppointmentManager;
import business.GroupManager;
import business.StudentManager;
import dataAccess.InMemoryAppointmentDao;
import dataAccess.InMemoryStudentDao;
import entities.Appointment;
import entities.Group;
import entities.Student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student(1, "Ahmet Yasin", "101", "Java", false);
        Student student2 = new Student(2, "Emir", "102", "C++", false);
        Student student3 = new Student(3, "Ayşe", "103", "Python", true);
        Student student4 = new Student(4, "Mehmet", "104", "C#", false);

        StudentManager studentManager = new StudentManager(new InMemoryStudentDao());
        studentManager.add(student1);
        studentManager.add(student2);
        studentManager.add(student3);
        studentManager.add(student4);

        List<Group> gruplar = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        System.out.println("--- SINIF LİSTESİ ---");
        for (Student s : studentManager.getAll()) {
            System.out.println(s.getId() + ". " + s.getFullName() + " (" + s.getStudentNumber() + ")");
        }

        System.out.print("Hangi ID'li öğrenciyi 'Avengers' grubuna eklemek istersiniz?: ");
        int secilenId = scanner.nextInt();

        Student secilenOgrenci = studentManager.getById(secilenId);

        if (secilenOgrenci != null) {
            System.out.println("✅ Seçilen Öğrenci: " + secilenOgrenci.getFullName());

            Group manuelGrup = new Group(1, "Avengers Takımı", "Dünyayı Kurtarma");

            manuelGrup.getStudents().add(secilenOgrenci);

            secilenOgrenci.setHasGroup(true);

            gruplar.add(manuelGrup);

            System.out.println("🎉 BAŞARILI! " + secilenOgrenci.getFullName() + ", " + manuelGrup.getGroupName() + " grubuna eklendi.");
        } else {
            System.out.println("❌ Hata: Bu ID'ye sahip bir öğrenci bulunamadı!");
        }

        System.out.println("\n--- OTOMATİK GRUP DAĞITIMI BAŞLIYOR ---");

        gruplar.add(new Group(2, "Grup Alpha", "Yapay Zeka"));
        gruplar.add(new Group(3, "Grup Beta", "Siber Güvenlik"));

        GroupManager groupManager = new GroupManager();
        groupManager.autoDistribute(studentManager.getAll(), gruplar);

        System.out.println("\n--- RANDEVU OLUŞTURMA (RASTGELE SAATLER) ---");

        AppointmentManager appointmentManager = new AppointmentManager(new InMemoryAppointmentDao());

        List<String> musaitSaatler = new ArrayList<>();
        musaitSaatler.add("Pazartesi 09:00");
        musaitSaatler.add("Pazartesi 10:00");
        musaitSaatler.add("Pazartesi 13:00");
        musaitSaatler.add("Salı 09:00");
        musaitSaatler.add("Salı 14:00");
        musaitSaatler.add("Çarşamba 10:00");

        Collections.shuffle(musaitSaatler);

        for (int i = 0; i < gruplar.size(); i++) {
            if (i < musaitSaatler.size()) {
                Group siradakiGrup = gruplar.get(i);
                String cekilenSaat = musaitSaatler.get(i);

                Appointment randevu = new Appointment(i + 1, cekilenSaat, siradakiGrup);
                appointmentManager.add(randevu);
            }
        }

        System.out.println("\n--- BİREYSEL ÖDEV DAĞITIMI ---");

        List<String> odezler = new ArrayList<>();
        odezler.add("Java'da OOP Nedir?");
        odezler.add("SQL vs NoSQL Farkları");
        odezler.add("Git ve GitHub Kullanımı");
        odezler.add("Temiz Kod (Clean Code) İlkeleri");
        odezler.add("Yazılım Mimarileri");

        studentManager.distributeAssignments(odezler);


        System.out.println("\n--- GENEL SINIF YOKLAMASI BAŞLATILIYOR ---");
        System.out.println("Lütfen 'e' (Evet) veya 'h' (Hayır) giriniz.");

        for (Student s : studentManager.getAll()) {

            System.out.print("👉 " + s.getFullName() + " burada mı? (e/h): ");
            String cevap = scanner.next();

            boolean durumu = cevap.equalsIgnoreCase("e");

            studentManager.changeAttendance(s.getId(), durumu);
        }

        System.out.println("\n✅ TÜM SINIFIN YOKLAMASI TAMAMLANDI!");

        System.out.println("\n--- MANUEL ÖDEV VERME / DEĞİŞTİRME PANELİ ---");

        System.out.print("İşlem yapılacak Öğrenci ID: ");
        int ozelId = scanner.nextInt();
        scanner.nextLine();

        Student ozelOgrenci = studentManager.getById(ozelId);

        if (ozelOgrenci != null) {
            System.out.println("Seçilen Öğrenci: " + ozelOgrenci.getFullName());

            boolean islemYapilsinMi = true;

            String mevcutOdev = ozelOgrenci.getIndividualAssignment();

            if (mevcutOdev != null && !mevcutOdev.equals("*") && !mevcutOdev.isEmpty()) {
                System.out.println("⚠️ UYARI: Bu öğrencinin zaten bir ödevi var: " + mevcutOdev);
                System.out.print("Ödevi değiştirmek ister misiniz? (e/h): ");
                String cevap = scanner.nextLine();

                if (cevap.equalsIgnoreCase("h")) {
                    islemYapilsinMi = false;
                    System.out.println("❌ İşlem iptal edildi. Eski ödev kalıyor.");
                }
            }

            if (islemYapilsinMi) {
                System.out.print("Yeni Ödev Konusunu Giriniz: ");
                String yeniKonu = scanner.nextLine();

                studentManager.assignHomeworkToStudent(ozelId, yeniKonu);
            }

        } else {
            System.out.println("❌ HATA: Öğrenci bulunamadı!");
        }

    }
}