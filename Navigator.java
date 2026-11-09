package kelas;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import kelas.controller.DetailController;
import kelas.data.DataProduk;
import kelas.model.Produk;

import java.io.IOException;

public class Navigator {
    private Stage stage;
    private DataProduk dataProduk;

    public Navigator(Stage stage, DataProduk dataProduk) {
        this.stage = stage;
        this.dataProduk = dataProduk;
    }

    public void bukaForm() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kelas/form.fxml"));
            Parent root = loader.load();
            
            stage.setScene(new Scene(root));
            stage.setTitle("Form Tambah Produk");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal memuat form.fxml");
        }
    }

    public void bukaDaftar() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kelas/daftar.fxml"));
            Parent root = loader.load();
            
            stage.setScene(new Scene(root));
            stage.setTitle("Daftar Produk");
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal memuat daftar.fxml");
        }
    }

    public void bukaDetail(Produk produkPilih) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/kelas/detail.fxml"));
            Parent root = loader.load();
            
            DetailController controller = loader.getController();
            controller.setProduk(produkPilih);
            
            Stage stageDetail = new Stage();
            stageDetail.setScene(new Scene(root));
            stageDetail.setTitle("Detail Produk");
            stageDetail.show();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Gagal memuat detail.fxml");
        }
    }
}