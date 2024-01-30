package Entity;

public class ReservasiEntity extends BaseEntity {
    private double hargaPerMalam;
    private int nomorKamar;
    private String namaTamu;
    private String jenisPembayaran;
    private boolean checkIn;
    private boolean checkOut;
    private int jumlahMalam;

    public ReservasiEntity(int nomorKamar, String namaTamu, String jenisPembayaran, double hargaPerMalam, int jumlahMalam) {
        this.nomorKamar = nomorKamar;
        this.namaTamu = namaTamu;
        this.jenisPembayaran = jenisPembayaran;
        this.checkIn = false;
        this.checkOut = false;
        this.hargaPerMalam = hargaPerMalam;
        this.jumlahMalam = jumlahMalam;
    }


    @Override
    public String toString() {
        return "Nomor Kamar: " + nomorKamar +
               "\nNama Tamu: " + namaTamu +
               "\nJenis Pembayaran: " + jenisPembayaran +
               "\nJumlah Malam: " + jumlahMalam +
               "\nHarga Per Malam: " + hargaPerMalam +
               "\nTotal Harga: " + hitungTotalHarga(this) +
               "\nCheck-In: " + checkIn +
               "\nCheck-Out: " + checkOut;
    }

    

    public int getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(int nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public String getNamaTamu() {
        return namaTamu;
    }

    public void setNamaTamu(String namaTamu) {
        this.namaTamu = namaTamu;
    }

    public String getJenisPembayaran() {
        return jenisPembayaran;
    }

    public void setJenisPembayaran(String jenisPembayaran) {
        this.jenisPembayaran = jenisPembayaran;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public int getJumlahMalam() {
        return jumlahMalam;
    }

    public void setJumlahMalam(int jumlahMalam) {
        this.jumlahMalam = jumlahMalam;
    }

    private double hitungTotalHarga(ReservasiEntity reservasi) {
        return reservasi.getHargaPerMalam() * reservasi.getJumlahMalam();
    }
}
