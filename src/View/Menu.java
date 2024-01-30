package View;
import Entity.KamarEntity;
import Entity.ReservasiEntity;
import Controller.*;

import javax.swing.*;
import java.awt.*;
import java.util.List; 

public class Menu extends JFrame {
    private ControllerAdmin admin;
    public JLabel judul, back, menu;
    private JTextArea outputArea;
    private LoginFrame loginFrame;
    JButton kembali, button;

    String[] fitur = {"Tambah Data", "Lihat Kamar", "Edit Kamar", "Check-in", "Check-out", "Lihat Reservasi", "Lihat Kamar Kosong", "Lihat Tamu"};

    int x = 50;
    int y = 100;

    public Menu(LoginFrame loginFrame) {
        this.admin = new ControllerAdmin();
        this.loginFrame = loginFrame;


        setTitle("~ MANAJEMEN HOTEL ~");
        setSize(600, 400);
        setLayout(null);
        component();
        action();
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void showMenu() {
        setVisible(true);
        loginFrame.setVisible(false);
    }
    
    

    public void component() {
        

        judul = new JLabel(": ~ MANAJEMEN HOTEL ~ :");
        judul.setBounds(207, 41, 180, 19);
        judul.setForeground(Color.black);

        menu = new JLabel(": ~~~ MENU ~~~~ :");
        menu.setBounds(235, 55, 180, 22);
        menu.setForeground(Color.black);

        outputArea = new JTextArea();
        outputArea.setBounds(10, 150, 580, 150);
        outputArea.setEditable(false);
        outputArea.setVisible(false);


        for (String data : fitur) {
            JButton tombol = new JButton(data);
            tombol.setBounds(x, y, 200, 30);
            
            tombol.setBackground(new Color(0x001F3F));
            tombol.setForeground(Color.WHITE);
            tombol.setFocusPainted(false);
            
            y += 50;
            add(tombol);
            if (data.equals("Check-in")) {
                x = 340;
                y = 100;
            }
        }


        kembali = new JButton("Kembali");
        kembali.setBounds(28, 317, 120, 27);

        ImageIcon imageIcon = new ImageIcon("src/Image/OIP.jpg");
        back = new JLabel(imageIcon);
        back.setIcon(new ImageIcon(imageIcon.getImage().getScaledInstance(600, 500, Image.SCALE_SMOOTH)));
        back.setBounds(0, 0, 600, 500);

        add(judul);
        add(kembali);
        add(menu);
        add(outputArea);
        add(back);
    }

    public void action() {
        kembali.addActionListener((aksi -> {
            dispose();
            loginFrame.setVisible(true);
        }));
        
        

        for (Component komponen : getContentPane().getComponents()) {
            if (komponen instanceof JButton) {
                JButton tombol = (JButton) komponen;
                switch (tombol.getText()) {
                    case "Tambah Data":
                        tombol.addActionListener(e -> displayTambahDataKamar());
                        break;
                    case "Lihat Kamar":
                        tombol.addActionListener(e -> displayInfoKamar());
                        break;
                    case "Edit Kamar":
                        tombol.addActionListener(e -> editDataKamar());
                        break;
                    case "Check-in":
                        tombol.addActionListener(e -> displayReservasiKamar());
                        break;
                    case "Check-out":
                        tombol.addActionListener(e -> displayCheckOut());
                        break;
                    case "Lihat Reservasi":
                        tombol.addActionListener(e -> displayLihatDetailReservasi());
                        break;
                    case "Lihat Kamar Kosong":
                        tombol.addActionListener(e -> displayInfoKamarKosong());
                        break;
                    case "Lihat Tamu":
                        tombol.addActionListener(e -> displayLihatDataTamu());
                        break;
                }
            }
        }
    }

    private void editDataKamar() {
        outputArea.setText("");
        int nomorKamar = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nomor Kamar yang akan diedit:"));
        String jenisBedBaru = JOptionPane.showInputDialog("Masukkan Jenis Bed Baru:");
        double hargaPerMalamBaru = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Harga per Malam Baru:"));
        admin.editDataKamar(nomorKamar, jenisBedBaru, hargaPerMalamBaru);
        JOptionPane.showMessageDialog(this, "Data Kamar berhasil diubah.");
    }




    private void displayInfoKamar() {
    
        List<KamarEntity> infoKamar = admin.lihatInfoKamar();
    
        for (KamarEntity kamar : infoKamar) {
            outputArea.append(kamar.toString() + "\n");
        }
    
        JDialog infoDialog = new JDialog(this, "Informasi Kamar", true);
        infoDialog.setSize(400, 300);
        infoDialog.setLayout(new BorderLayout());
    
        JTextArea infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);
    
        for (KamarEntity kamar : infoKamar) {
            infoTextArea.append(kamar.toString() + "\n");
        }
    
        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        infoDialog.add(scrollPane, BorderLayout.CENTER);
    
        JButton closeButton = new JButton("Tutup");
        closeButton.addActionListener(e -> infoDialog.dispose());
        infoDialog.add(closeButton, BorderLayout.SOUTH);
    
        infoDialog.setLocationRelativeTo(this);
        infoDialog.setVisible(true);
    }


    
    
    private void displayInfoKamarKosong() {

        List<KamarEntity> infoKamarKosong = admin.lihatInfoKamarKosong();

        outputArea.append("Jumlah Kamar Kosong: " + infoKamarKosong.size() + "\n");

        JDialog infoDialog = new JDialog(this, "Informasi Kamar Tersedia", true);
        infoDialog.setSize(400, 300);
        infoDialog.setLayout(new BorderLayout());

        JTextArea infoTextArea = new JTextArea();
        infoTextArea.setEditable(false);

        infoTextArea.append("Jumlah Kamar Kosong: " + infoKamarKosong.size() + "\n");

        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        infoDialog.add(scrollPane, BorderLayout.CENTER);

        JButton closeButton = new JButton("Tutup");
        closeButton.addActionListener(e -> infoDialog.dispose());
        infoDialog.add(closeButton, BorderLayout.SOUTH);

        infoDialog.setLocationRelativeTo(this);
        infoDialog.setVisible(true);
    }




    private void displayTambahDataKamar() {
        outputArea.setText("");
        int nomorKamar = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nomor Kamar:"));
        String jenisBed = JOptionPane.showInputDialog("Masukkan Jenis Bed:");
        double hargaPerMalam = Double.parseDouble(JOptionPane.showInputDialog("Masukkan Harga per Malam:"));
        admin.tambahDataKamar(nomorKamar, jenisBed, hargaPerMalam);
        JOptionPane.showMessageDialog(this, "Data Kamar berhasil ditambahkan.");
    }




    private void displayReservasiKamar() {
        outputArea.setText("");
        int nomorKamar = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nomor Kamar untuk Reservasi:"));
        String namaTamu = JOptionPane.showInputDialog("Masukkan Nama Tamu:");
        String jenisPembayaran = JOptionPane.showInputDialog("Masukkan Jenis Pembayaran:");
        int jumlahMalam = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Lama Sewa (Malam):"));
        admin.reservasiKamar(nomorKamar, namaTamu, jenisPembayaran, jumlahMalam);
        JOptionPane.showMessageDialog(this, "Reservasi berhasil dilakukan (Check-in).");
    }




    private void displayCheckOut() {
        outputArea.setText("");
        int nomorKamar = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nomor Kamar untuk Check-Out:"));
        admin.checkOut(nomorKamar);
        JOptionPane.showMessageDialog(this, "Check-out berhasil dilakukan.");
    }




    private void displayLihatDetailReservasi() {
        int nomorKamar = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Nomor Kamar untuk melihat detail reservasi:"));
    
        ReservasiEntity reservasi = admin.lihatDetailReservasi(nomorKamar);
    
        JDialog detailDialog = new JDialog(this, "Detail Reservasi", true);
        detailDialog.setSize(400, 300);
        detailDialog.setLayout(new BorderLayout());
    
        JTextArea detailTextArea = new JTextArea();
        detailTextArea.setEditable(false);
    
        if (reservasi != null) {
            detailTextArea.append("Nomor Kamar: " + reservasi.getNomorKamar() + "\n");
            detailTextArea.append("Nama Tamu: " + reservasi.getNamaTamu() + "\n");
            detailTextArea.append("Jenis Pembayaran: " + reservasi.getJenisPembayaran() + "\n");
            detailTextArea.append("Jumlah Malam: " + reservasi.getJumlahMalam() + "\n");
            detailTextArea.append("Total Harga: " + reservasi.getHargaPerMalam() * reservasi.getJumlahMalam() + "\n");
            detailTextArea.append("Check-In: " + reservasi.isCheckIn() + "\n");
            detailTextArea.append("Check-Out: " + reservasi.isCheckOut() + "\n");
            detailTextArea.append("---------------\n\n\n");
        } else {
            detailTextArea.append("Reservasi dengan Nomor Kamar " + nomorKamar + " tidak ditemukan.\n");
        }
    
        JScrollPane scrollPane = new JScrollPane(detailTextArea);
        detailDialog.add(scrollPane, BorderLayout.CENTER);
    
        JButton closeButton = new JButton("Tutup");
        closeButton.addActionListener(e -> detailDialog.dispose());
        detailDialog.add(closeButton, BorderLayout.SOUTH);
    
        detailDialog.setLocationRelativeTo(this);
        detailDialog.setVisible(true);
    }




    private void displayLihatDataTamu() {
        JTextArea infoTextAreaDialog = new JTextArea();
        infoTextAreaDialog.setEditable(false);
    
        infoTextAreaDialog.append("Data Tamu yang belum Check-Out:\n");
    
        for (ReservasiEntity reservasi : admin.lihatDataTamu()) {
            infoTextAreaDialog.append("Nama Tamu: " + reservasi.getNamaTamu() + "\n");
            infoTextAreaDialog.append("Nomor Kamar: " + reservasi.getNomorKamar() + "\n");
            infoTextAreaDialog.append("Jenis Pembayaran: " + reservasi.getJenisPembayaran() + "\n");
            infoTextAreaDialog.append("Check-In: " + reservasi.isCheckIn() + "\n");
            infoTextAreaDialog.append("Check-Out: " + reservasi.isCheckOut() + "\n");
            infoTextAreaDialog.append("---------------\n\n\n");
        }
    
        JDialog infoDialog = new JDialog(this, "Data Tamu", true);
        infoDialog.setSize(400, 300);
        infoDialog.setLayout(new BorderLayout());
    
        JScrollPane scrollPane = new JScrollPane(infoTextAreaDialog);
        infoDialog.add(scrollPane, BorderLayout.CENTER);
    
        JButton closeButton = new JButton("Tutup");
        closeButton.addActionListener(e -> infoDialog.dispose());
        infoDialog.add(closeButton, BorderLayout.SOUTH);
    
        infoDialog.setLocationRelativeTo(this);
        infoDialog.setVisible(true);
    }
    



    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true);
    
            Menu menu = new Menu( loginFrame);
            menu.showMenu();
        });
    }    
}
