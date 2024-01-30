package Model;

import Entity.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ModelManajer {
    private List<KamarEntity> daftarKamar;
    private Map<Integer, ReservasiEntity> daftarReservasi;


    public List<KamarEntity> lihatInfoKamar() {
        return daftarKamar;
    }
    
    public ModelManajer() {
        this.daftarKamar = new ArrayList<>();
        this.daftarReservasi = new HashMap<>();
    }

    public boolean loginAdmin(String username, String password) {
        ModelLogin modelLogin = new ModelLogin();
        return modelLogin.cekLogin(username, password);
    }



    public void tambahKamar(KamarEntity kamar) {
        daftarKamar.add(kamar);
    }
    public void tambahDataKamar(int nomorKamar, String jenisBed, double hargaPerMalam) {
        KamarEntity kamarBaru = new KamarEntity(nomorKamar, jenisBed, hargaPerMalam);
        tambahKamar(kamarBaru);
    }



    public void editDataKamar(int nomorKamar, String jenisBedBaru, double hargaPerMalamBaru) {
        for (KamarEntity kamar : daftarKamar) {
            if (kamar.getNomorKamar() == nomorKamar) {
                kamar.setJenisBed(jenisBedBaru);
                kamar.setHargaPerMalam(hargaPerMalamBaru);
                return;
            }
        }
    }



    public void reservasiKamar(int nomorKamar, String namaTamu, String jenisPembayaran, int jumlahMalam) {
        KamarEntity kamar = getKamarByNomor(nomorKamar);
        if (kamar != null) {
            ReservasiEntity reservasi = new ReservasiEntity(nomorKamar, namaTamu, jenisPembayaran, kamar.getHargaPerMalam(), jumlahMalam);
            daftarReservasi.put(nomorKamar, reservasi);
            reservasi.setCheckIn(true);
        } else {
        }
    }
    private KamarEntity getKamarByNomor(int nomorKamar) {
        for (KamarEntity kamar : daftarKamar) {
            if (kamar.getNomorKamar() == nomorKamar) {
                return kamar;
            }
        }
        return null;
    }

    

    public ReservasiEntity lihatDetailReservasi(int nomorKamar) {
        ReservasiEntity reservasi = daftarReservasi.get(nomorKamar);
        return reservasi;
    }
    



    public List<KamarEntity> lihatInfoKamarKosong() {
        List<KamarEntity> kamarKosong = new ArrayList<>();
        for (KamarEntity kamar : daftarKamar) {
            boolean sudahDipesan = daftarReservasi.containsKey(kamar.getNomorKamar());
            if (!sudahDipesan) {
                kamarKosong.add(kamar);
            }
        }
        return kamarKosong;
    }




    public void checkOut(int nomorKamar) {
        ReservasiEntity reservasi = daftarReservasi.get(nomorKamar);
        if (reservasi != null && reservasi.isCheckIn() && !reservasi.isCheckOut()) {
            reservasi.setCheckOut(true);
        } else {
        }
    }
    


    
    public List<ReservasiEntity> lihatDataTamu() {
        List<ReservasiEntity> tamuBelumCheckOut = new ArrayList<>();

        for (ReservasiEntity reservasi : daftarReservasi.values()) {
            if (!reservasi.isCheckOut()) {
                tamuBelumCheckOut.add(reservasi);
            }
        }

        return tamuBelumCheckOut;
    }
    public Map<Integer, ReservasiEntity> getDaftarReservasi() {
        return daftarReservasi;
    }
}