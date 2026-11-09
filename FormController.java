package kelas.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import kelas.Navigator;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class FormController {
    
    // Sesuaikan fx:id ini dengan yang ada di Scene Builder (form.fxml)
    @FXML private TextField txtKode;
    @FXML private TextField txtNama;
    @FXML private TextField txtHarga;
    @FXML private ComboBox<String> cmbKategori;

    private Navigator navigator;
    private DataProduk data;

    @FXML
    public void initialize() {
        // Mengisi pilihan kategori Makanan dan Minuman
        cmbKategori.getItems().addAll("Makanan", "Minuman");
        cmbKategori.setValue("Makanan"); // Nilai default
    }

    // Mengganti DataPembelian menjadi DataProduk
    public void setKonteks(Navigator navigator, DataProduk data) {
        this.navigator = navigator;
        this.data = data;
    }

    @FXML
    private void handleSimpan() {
        String kode = txtKode.getText();
        String nama = txtNama.getText();
        String kategori = cmbKategori.getValue();

        // Validasi nama tidak boleh kosong
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Error: Nama produk tidak boleh kosong!");
            return; 
        }

        // Validasi harga harus lebih dari 0
        int harga = 0;
        try {
            harga = Integer.parseInt(txtHarga.getText());
            if (harga <= 0) {
                System.out.println("Error: Harga harus lebih dari 0!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Error: Harga harus berupa angka!");
            return;
        }

        // Buat objek produk baru
        Produk produkBaru = new Produk(kode, nama, kategori, harga);
        
        // Simpan ke DataProduk
        DataProduk.tambahProduk(produkBaru);
        System.out.println("Berhasil menyimpan produk: " + nama);
        
        // Kembali ke daftar tabel setelah menyimpan
        if (navigator != null) {
            navigator.bukaDaftar();
        }
    }
}