package kelas.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import kelas.model.Produk;

public class DataProduk {
    private static ObservableList<Produk> listProduk = FXCollections.observableArrayList();

    public static ObservableList<Produk> getListProduk() {
        return listProduk;
    }

    public static void tambahProduk(Produk p) {
        listProduk.add(p);
    }
}