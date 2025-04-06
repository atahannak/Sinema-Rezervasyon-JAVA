import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SinemaRezervasyon {
    private static final int SATIR_SAYISI = 5;
    private static final int SUTUN_SAYISI = 8;
    private static final int VIP_FIYAT = 100;
    private static final int NORMAL_FIYAT = 50;
    private static HashMap<JButton, Integer> koltukFiyatlari = new HashMap<>();
    private static JLabel toplamFiyatLabel;
    private static int toplamFiyat = 0;

    public static void main(String[] args) {
        UIManager.put("OptionPane.yesButtonText", "Evet");
        UIManager.put("OptionPane.noButtonText", "Hayır");

        JFrame pencere = new JFrame("Sinema Salonu");
        pencere.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pencere.setSize(800, 450);

        JPanel ustPanel = new JPanel(new BorderLayout());

        JLabel baslikLabel = new JLabel("Sinema Koltuk Düzeni", SwingConstants.CENTER);
        baslikLabel.setFont(new Font("Arial", Font.BOLD, 16));

        toplamFiyatLabel = new JLabel("Toplam Fiyat: 0 TL", SwingConstants.CENTER);

        JLabel yazarLabel = new JLabel("Atahan Ak tarafından yapılmıştır", SwingConstants.RIGHT);
        yazarLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        yazarLabel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 10));

        JPanel ustSolPanel = new JPanel(new GridLayout(2, 1));
        ustSolPanel.add(baslikLabel);
        ustSolPanel.add(toplamFiyatLabel);

        ustPanel.add(ustSolPanel, BorderLayout.CENTER);
        ustPanel.add(yazarLabel, BorderLayout.EAST);

        JPanel panel = new JPanel(new GridLayout(SATIR_SAYISI, SUTUN_SAYISI, 5, 5));
        JButton[][] koltuklar = new JButton[SATIR_SAYISI][SUTUN_SAYISI];

        for (int satir = 0; satir < SATIR_SAYISI; satir++) {
            for (int sutun = 0; sutun < SUTUN_SAYISI; sutun++) {
                JButton koltukButonu = new JButton((satir + 1) + "-" + (sutun + 1));
                koltukButonu.setOpaque(true);
                koltukButonu.setBorderPainted(false);

                if (satir < 2) {
                    koltukButonu.setBackground(Color.CYAN); // VIP koltuklar
                    koltukFiyatlari.put(koltukButonu, VIP_FIYAT);
                } else {
                    koltukButonu.setBackground(Color.GREEN); // Normal koltuklar
                    koltukFiyatlari.put(koltukButonu, NORMAL_FIYAT);
                }

                koltukButonu.addActionListener(new KoltukIslemDinleyici(koltukButonu));
                koltuklar[satir][sutun] = koltukButonu;
                panel.add(koltukButonu);
            }
        }

        JPanel sagPanel = new JPanel();
        sagPanel.setLayout(new BoxLayout(sagPanel, BoxLayout.Y_AXIS));
        sagPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel bilgiBaslik = new JLabel("Bilgilendirme");
        bilgiBaslik.setFont(new Font("Arial", Font.BOLD, 14));
        bilgiBaslik.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel bosLabel = new JLabel("\u25A0 Boş Koltuk (Yeşil)");
        bosLabel.setForeground(Color.GREEN);
        JLabel vipLabel = new JLabel("\u25A0 VIP Koltuk (Cyan) - 100 TL");
        vipLabel.setForeground(Color.CYAN);
        JLabel satildiLabel = new JLabel("\u25A0 Satıldı (Turuncu)");
        satildiLabel.setForeground(Color.ORANGE);
        JLabel normalFiyat = new JLabel("\nNormal Koltuk Fiyatı: 50 TL");

        bosLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        vipLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        satildiLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        normalFiyat.setAlignmentX(Component.LEFT_ALIGNMENT);

        sagPanel.add(bilgiBaslik);
        sagPanel.add(Box.createVerticalStrut(10));
        sagPanel.add(bosLabel);
        sagPanel.add(vipLabel);
        sagPanel.add(satildiLabel);
        sagPanel.add(Box.createVerticalStrut(10));
        sagPanel.add(normalFiyat);

        pencere.add(ustPanel, BorderLayout.NORTH);
        pencere.add(panel, BorderLayout.CENTER);
        pencere.add(sagPanel, BorderLayout.EAST);

        pencere.setVisible(true);
    }

    static class KoltukIslemDinleyici implements ActionListener {
        private JButton buton;
        private String orijinalYazi;

        public KoltukIslemDinleyici(JButton buton) {
            this.buton = buton;
            this.orijinalYazi = buton.getText();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (buton.getBackground() == Color.ORANGE) {
                int secim = JOptionPane.showConfirmDialog(null, "Bu koltuğu iptal etmek istiyor musunuz?", "İptal", JOptionPane.YES_NO_OPTION);
                if (secim == JOptionPane.YES_OPTION) {
                    buton.setBackground(koltukFiyatlari.get(buton) == VIP_FIYAT ? Color.CYAN : Color.GREEN);
                    buton.setText(orijinalYazi);
                    toplamFiyat -= koltukFiyatlari.get(buton);
                }
            } else {
                int secim = JOptionPane.showConfirmDialog(null, "Bu koltuğu satın almak istiyor musunuz?", "Satın Al", JOptionPane.YES_NO_OPTION);
                if (secim == JOptionPane.YES_OPTION) {
                    buton.setBackground(Color.ORANGE);
                    buton.setText("Satıldı");
                    toplamFiyat += koltukFiyatlari.get(buton);
                }
            }
            toplamFiyatLabel.setText("Toplam Fiyat: " + toplamFiyat + " TL");
        }
    }
}
