package Controller;

import Entity.KamarEntity;
import Entity.ReservasiEntity;
import Model.ModelManajer;

import java.util.List;
import java.util.Map;

public class ControllerAdmin {
    private ModelManajer modelManajer;

    public ControllerAdmin(ModelManajer modelManajer) {
        this.modelManajer = modelManajer;
    }
    public ControllerAdmin(){
        this.modelManajer = new ModelManajer();
    }

    public boolean loginAdmin(String username, String password) {
        return modelManajer.loginAdmin(username, password);
    }

    public void tambahDataKamar(int nomorKamar, String jenisBed, double hargaPerMalam) {
        modelManajer.tambahDataKamar(nomorKamar, jenisBed, hargaPerMalam);
    }

    public void editDataKamar(int nomorKamar, String jenisBedBaru, double hargaPerMalamBaru) {
        modelManajer.editDataKamar(nomorKamar, jenisBedBaru, hargaPerMalamBaru);
    }

    public void reservasiKamar(int nomorKamar, String namaTamu, String jenisPembayaran, int jumlahMalam) {
        modelManajer.reservasiKamar(nomorKamar, namaTamu, jenisPembayaran, jumlahMalam);
    }

    public List<KamarEntity> lihatInfoKamar() {
        return modelManajer.lihatInfoKamar();
    }

    public List<KamarEntity> lihatInfoKamarKosong() {
        return modelManajer.lihatInfoKamarKosong();
    }

    public ReservasiEntity lihatDetailReservasi(int nomorKamar) {
        return modelManajer.lihatDetailReservasi(nomorKamar);
    }

    public void checkOut(int nomorKamar) {
        modelManajer.checkOut(nomorKamar);
    }

    public List<ReservasiEntity> lihatDataTamu() {
        return modelManajer.lihatDataTamu();
    }

    public Map<Integer, ReservasiEntity> getDaftarReservasi() {
        return modelManajer.getDaftarReservasi();
    }
}
