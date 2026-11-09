package kelas.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import kelas.data.DataProduk;
import kelas.model.Produk;

public class DaftarController {
    @FXML private TableView<Produk> tableProduk;
    @FXML private TableColumn<Produk, String> colKode, colNama, colKategori;
    @FXML private TableColumn<Produk, Integer> colHarga;
    @FXML private TextField txtCari;

    @FXML
    public void initialize() {
        colKode.setCellValueFactory(new PropertyValueFactory<>("kode"));
        colNama.setCellValueFactory(new PropertyValueFactory<>("nama"));
        colKategori.setCellValueFactory(new PropertyValueFactory<>("kategori"));
        colHarga.setCellValueFactory(new PropertyValueFactory<>("harga"));

        tableProduk.setItems(DataProduk.getListProduk());
    }

    @FXML
    private void handleCari() {
        String keyword = txtCari.getText().toLowerCase();
        ObservableList<Produk> hasilCari = FXCollections.observableArrayList();
        
        for (Produk p : DataProduk.getListProduk()) {
            if (p.getNama().toLowerCase().contains(keyword)) {
                hasilCari.add(p);
            }
        }
        tableProduk.setItems(hasilCari);
    }

    @FXML
    private void handleDetail() {
        Produk produkPilih = tableProduk.getSelectionModel().getSelectedItem();
        if (produkPilih != null) {
            // PENTING: Sesuaikan baris ini dengan cara class Navigator.java milikmu memanggil form detail
            // Contoh: Navigator.loadDetail(produkPilih); 
            System.out.println("Membuka detail: " + produkPilih.getNama());
        }
    }
}