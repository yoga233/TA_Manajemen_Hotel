// package View;
// import java.util.Scanner;

// import Model.ModelManajer;

// public class MainPage {
//     public static void main(String[] args) {
//         ModelManajer modelManajer = new ModelManajer();
//         Scanner scanner = new Scanner(System.in);

//         System.out.print("Username: ");
//         String username = scanner.nextLine();

//         System.out.print("Password: ");
//         String password = scanner.nextLine();

//         boolean isAdminLoggedIn = modelManajer.loginAdmin(username, password);
//         if (isAdminLoggedIn) {
//             System.out.println("Admin berhasil login.");
//         } else {
//             System.out.println("Login admin gagal.");
//         }

//         int menuChoice;
//         do {
//             System.out.println("\nMenu:");
//             System.out.println("1. Tambah Data Kamar");
//             System.out.println("2. Lihat Informasi Kamar");
//             System.out.println("3. Edit Data Kamar");
//             System.out.println("4. Reservasi Kamar (Check-in)");
//             System.out.println("5. Lihat Detail Reservasi");
//             System.out.println("6. Check-out");
//             System.out.println("7. Lihat Informasi Kamar Tersedia");
//             System.out.println("8. Lihat Data Tamu");
//             System.out.println("0. Keluar");
//             System.out.print("Pilih menu (0-8): ");
            
//             menuChoice = scanner.nextInt();
//             scanner.nextLine();
//             switch (menuChoice) {
//                 case 1:
//                     tambahDataKamar(modelManajer, scanner);
//                     break;
//                 case 2:
//                     modelManajer.lihatInfoKamar();
//                     break;
//                 case 3:
//                     editDataKamar(modelManajer, scanner);
//                     break;
//                 case 4:
//                     reservasiKamar(modelManajer, scanner);
//                     break;
//                 case 5:
//                     lihatDetailReservasi(modelManajer, scanner);
//                     break;
//                 case 6:
//                     checkOut(modelManajer, scanner);
//                     break;
//                 case 7:
//                     modelManajer.lihatInfoKamarKosong();
//                     break;
//                 case 8:
//                     modelManajer.lihatDataTamu();
//                     break;
//                 case 0:
//                     System.out.println("Keluar dari program. Sampai jumpa!");
//                     break;
//                 default:
//                     System.out.println("Menu tidak valid. Silakan pilih lagi.");
//                     break;
//             }
//         } while (menuChoice != 0);
//         scanner.close();
//     }

//     private static void tambahDataKamar(ModelManajer modelManajer, Scanner scanner) {
//         System.out.print("Nomor Kamar: ");
//         int nomorKamar = scanner.nextInt();
//         scanner.nextLine();

//         System.out.print("Jenis Bed: ");
//         String jenisBed = scanner.nextLine();

//         System.out.print("Harga per Malam: ");
//         double hargaPerMalam = scanner.nextDouble();

//         modelManajer.tambahDataKamar(nomorKamar, jenisBed, hargaPerMalam);
//         System.out.println("Data Kamar berhasil ditambahkan.");
//     }

//     private static void editDataKamar(ModelManajer modelManajer, Scanner scanner) {
//         System.out.print("Nomor Kamar yang akan diedit: ");
//         int nomorKamarEdit = scanner.nextInt();
//         scanner.nextLine();

//         System.out.print("Jenis Bed Baru: ");
//         String jenisBedBaru = scanner.nextLine();

//         System.out.print("Harga per Malam Baru: ");
//         double hargaPerMalamBaru = scanner.nextDouble();

//         modelManajer.editDataKamar(nomorKamarEdit, jenisBedBaru, hargaPerMalamBaru);
//         System.out.println("Data Kamar berhasil diubah.");
//     }

//     private static void reservasiKamar(ModelManajer modelManajer, Scanner scanner) {
//         System.out.print("Nomor Kamar untuk Reservasi (Check-in): ");
//         int nomorKamarReservasi = scanner.nextInt();
//         scanner.nextLine();

//         System.out.print("Nama Tamu: ");
//         String namaTamu = scanner.nextLine();

//         System.out.print("Jenis Pembayaran: ");
//         String jenisPembayaran = scanner.nextLine();

//         System.out.print("Lama Sewa (Malam): ");
//         int jumlahMalam = scanner.nextInt(); 

//         modelManajer.reservasiKamar(nomorKamarReservasi, namaTamu, jenisPembayaran, jumlahMalam);
//         System.out.println("Reservasi berhasil dilakukan (Check-in).");
//     }

//     private static void lihatDetailReservasi(ModelManajer modelManajer, Scanner scanner) {
//         System.out.print("Nomor Kamar untuk melihat detail reservasi: ");
//         int nomorKamarReservasi = scanner.nextInt();
//         modelManajer.lihatDetailReservasi(nomorKamarReservasi);
//     }

//     private static void checkOut(ModelManajer modelManajer, Scanner scanner) {
//         System.out.print("Nomor Kamar untuk Check-out: ");
//         int nomorKamarCheckOut = scanner.nextInt();
//         modelManajer.checkOut(nomorKamarCheckOut);
//         System.out.println("Check-out berhasil dilakukan.");
//     }
// }
