package com.example.proiecttelefoane;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class HelloController implements Initializable {

    @FXML
    private Button AddMobil;
    @FXML
    private Button ShowMobil;

    List<TelefonMobil> listaTelMobile = new ArrayList<TelefonMobil>();

    List<String> sistemeDeOperare = Arrays.asList("Google Android ", "Apple iOS ", "Windows Phone ");

    List<String> modeleTelefon = Arrays.asList("IPhone ", "Samsung ", "Huawei ", "Xiaomi ", "One Plus ", "Lenovo ", "Google ", "Sony ", "ZTE ", "LG ");
    List<String> culoriTelefoane = Arrays.asList("Negru ", "Alb ", "Galben ", "Portocaliu ", "Roşu ", "Violet ", "Albastru ", "Turcoaz ", "Gri ", "Verde ","Purpuriu ","Cyan ");
    List<String> dimensiuniTelefon = Arrays.asList("5.2 inch ", "5.4 Inch ", "5.6 Inch ", "5.8 Inch ", "6.0 Inch ", "6.2 Inch, ", "6.4 Inch, ","6.6 Inch ", "6.8 Inch ", "7.0 Inch ");
    List<String> sanatateBaterie = Arrays.asList("Foarte bună ", "Bună ", "Normală ", "Deteriorată ", "Foarte Deteriorată");
    List<String> procesoareTelefon = Arrays.asList("A16 Bionic", "Snapdragon 8 Gen 2", "A15 Bionic ", "Dimensity 9000+", "Exynos 2200", "Kirin 9000", "Google Tensor G2", "Kirin 9300E");

    @FXML
    private ListView<TelefonMobil> Id1;

    @FXML
    public void OnAddTelMobil(){
        Random random = new Random();

        TelefonMobil tel = new TelefonMobil();
        tel.calitateFoto = random.nextInt(50);
        tel.pret = random.nextInt(1000, 5000);
        tel.sistemDeOperare = sistemeDeOperare.get(random.nextInt(0, sistemeDeOperare.size()));
        tel.model = modeleTelefon.get(random.nextInt(0, modeleTelefon.size()));
        tel.setCuloareTelefon(culoriTelefoane.get(random.nextInt(0, culoriTelefoane.size())));
        tel.setDimensiuniTelefon(dimensiuniTelefon.get(random.nextInt(0, dimensiuniTelefon.size())));
        tel.setProcesorTelefon(procesoareTelefon.get(random.nextInt(0, procesoareTelefon.size())));
        tel.setSanatateBaterie(sanatateBaterie.get(random.nextInt(0, sanatateBaterie.size())));

        addTelMobil(listaTelMobile, tel);
        Id1.getItems().setAll(listaTelMobile);

        try {
            FileOutputStream fos1 = new FileOutputStream("telMobile.txt");
            for (TelefonMobil i : listaTelMobile) {
                byte[] bytes = i.toString().getBytes();
                fos1.write(bytes);
            }
            fos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void onShowMobilList(){
        Id1.setVisible(true);
    }
    public void addTelMobil(List<TelefonMobil> listaTelMobil, TelefonMobil tel){
        listaTelMobil.add(tel);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id1.setVisible(false);
    }

    public List<TelefonMobil> getListaTelMobile() {
        return listaTelMobile;
    }

}