# 🏫 OKUL YÖNETİM SİSTEMİ (N-KATMANLI MİMARİ)

Bu proje, temel Java bilgisi ile modern kurumsal yazılım mimarisi prensiplerinin (OOP ve Katmanlı Yapı) uygulandığı konsol tabanlı bir yönetim simülasyonudur.

---

## 🚀 1. GEREKSİNİMLER
- Java Development Kit (JDK 17+)
- IntelliJ IDEA (veya başka bir IDE)

## 💡 2. PROJENİN TEMEL ÖZELLİKLERİ (Functional)
* **Kullanıcı Yönetimi:** Öğrenci ekleme, listeleme ve ID ile arama.
* **Grup Yönetimi:** Otomatik ve manuel grup oluşturma, listeye ekleme.
* **Akademik Takip:** Bireysel ödev atama ve yoklama alma modülleri.
* **Zamanlama:** Gruplara rastgele randevu saatleri atanması.

## ⚙️ 3. MİMARİ VURGUSU (The Engineering)

Bu projenin en güçlü yanı, tüm mimarinin SOLID prensiplerine uygun, N-Katmanlı bir yapıda kurulmuş olmasıdır.

| Katman | Sorumluluk | Örnek Sınıf |
| :--- | :--- | :--- |
| **Entities** | Veri Modellerini taşır. | `Student`, `Group`, `Appointment` |
| **Data Access** | Veri Saklama/Erişim (CRUD). | `StudentDao` (Interface), `InMemoryStudentDao` |
| **Business** | İş Kurallarını ve Algoritmaları barındırır. | `StudentManager`, `GroupManager` |

* **Bağımlılık Yönetimi:** Manager sınıfları, Constructor Injection kullanılarak kurulmuştur. (Örn: `ProductManager(ProductDao dao)`). Bu sayede `InMemory` listesinden gerçek bir veritabanına geçiş (Loose Coupling) kolayca yapılabilir.
* **Kapsülleme (Encapsulation):** Tüm alanlar `private`'tır. Veri bütünlüğü `Getter/Setter` ile korunmuştur.

## 🎲 4. ALGORTİTMA (Round-Robin Dağıtım)
* Öğrenciler, `Collections.shuffle` ile rastgele karıştırılır.
* Ardından **Modulo Operatörü (`%`)** kullanılarak, gruplara (Alpha, Beta) adil ve sırayla dağıtılır. (Örn: 1. Grup, 2. Grup, 3. Grup, Sonra Tekrar 1. Grup).
* Bu, projenin en önemli algoritmik değeridir.

## 👨‍💻 GELİŞTİRİCİ
**Adı:** Ahmet Yasin Başyiğit
**Profil:** [linkedin.com/in/ahmetyasinbasyigit]
**Eğitim:** İnönü Üniversitesi - Bilgisayar Programcılığı

---