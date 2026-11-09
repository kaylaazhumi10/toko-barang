package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import kelas.model.Produk;

public class DetailController {
    @FXML private Label lblKode, lblNama, lblKategori, lblHarga;

    // Fungsi ini dipanggil dari Navigator/DaftarController untuk mengirim data
    public void setProduk(Produk p) {
        lblKode.setText(p.getKode());
        lblNama.setText(p.getNama());
        lblKategori.setText(p.getKategori());
        lblHarga.setText(String.valueOf(p.getHarga()));
    }
}
