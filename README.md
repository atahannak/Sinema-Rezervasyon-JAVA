# 🎬 Sinema Koltuk Rezervasyon Sistemi

Bu proje, Java Swing kullanılarak geliştirilmiş bir **Sinema Koltuk Rezervasyon Uygulamasıdır**. Kullanıcılar, sinema salonundaki koltukları görsel olarak inceleyebilir, VIP veya normal koltuklar arasında seçim yaparak bilet satın alabilir ve daha önce satın aldıkları koltukları iptal edebilirler. Uygulama, kullanıcı dostu bir arayüzle basit ve etkili bir rezervasyon deneyimi sunar.

---

## 🧩 Özellikler

- **Koltuk Görselleştirme:**  
  5 satır ve 8 sütundan oluşan koltuk düzeni, her koltuk bir buton ile temsil edilerek gösterilir.

- **Koltuk Renk Kodları:**  
  - 🟩 Yeşil: Boş koltuk  
  - 🟦 Cyan: VIP koltuk  
  - 🟧 Turuncu: Satılmış koltuk

- **Koltuk Sınıflandırması:**  
  - İlk 2 sıra VIP (100 TL)  
  - Diğer sıralar normal koltuk (50 TL)

- **Satın Alma & İptal İşlemleri:**  
  - Boş koltuklar satın alınabilir, satın alınan koltuklar iptal edilebilir.  
  - Her işlem kullanıcıya onay penceresi ile sorulur.  
  - Satış sonrası koltuk durumu ve fiyatlar güncellenir.

- **Toplam Fiyat Takibi:**  
  - Satın alma ve iptal işlemlerinde toplam fiyat otomatik güncellenir.

- **Kullanıcı Arayüzü:**  
  - Swing teknolojisi ile görsel, anlaşılır ve işlevsel bir pencere yapısı  
  - Bilgilendirme paneli ve açıklayıcı etiketler  
  - Uygulama başlığında "Sinema Salonu" ibaresi

---

## 🛠️ Kullanılan Teknolojiler

- Java
- Java Swing (GUI)
- AWT (Layout ve Event Handling)

---

## 🧑‍💻 Geliştirici Notu

Kod içerisine çeşitli açıklayıcı yorumlar eklenmiştir. Bu yorumlar sayesinde programın her bir adımının **neden** yazıldığı daha iyi anlaşılır. Özellikle eğitim amacıyla geliştirilen projelerde bu tarz açıklamalar, kodun sürdürülebilirliği açısından büyük kolaylık sağlar.


---

## 🚀 Başlamak İçin

1. Projeyi klonlayın:
   ```bash
   git clone https://github.com/kullaniciadi/sinema-rezervasyon.git
