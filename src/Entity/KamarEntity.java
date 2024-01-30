package Entity;

public class KamarEntity extends BaseEntity {
    private int nomorKamar;
    private String jenisBed;
    private double hargaPerMalam;

    public KamarEntity(int nomorKamar, String jenisBed, double hargaPerMalam) {
        this.nomorKamar = nomorKamar;
        this.jenisBed = jenisBed;
        this.hargaPerMalam = hargaPerMalam;
    }
    @Override
    public String toString() {
        return "Nomor Kamar: " + nomorKamar +
               "\nJenis Bed: " + jenisBed +
               "\nHarga per Malam: " + hargaPerMalam;
    }
    public int getNomorKamar() {
        return nomorKamar;
    }

    public void setNomorKamar(int nomorKamar) {
        this.nomorKamar = nomorKamar;
    }

    public String getJenisBed() {
        return jenisBed;
    }

    public void setJenisBed(String jenisBed) {
        this.jenisBed = jenisBed;
    }

    public double getHargaPerMalam() {
        return hargaPerMalam;
    }

    public void setHargaPerMalam(double hargaPerMalam) {
        this.hargaPerMalam = hargaPerMalam;
    }
}


    

