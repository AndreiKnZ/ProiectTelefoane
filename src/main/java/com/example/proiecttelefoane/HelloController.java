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
    private Button AddFix;
    @FXML
    private Button ShowFix;

    List<TelefonFix> listaTelFixe = new ArrayList<TelefonFix>();

    List<String> sistemeDeOperare = Arrays.asList("Google Android ", "Apple iOS ", "Windows Phone ");

    List<String> modeleTelefon = Arrays.asList("IPhone ", "Samsung ", "Huawei ", "Xiaomi ", "One Plus ", "Lenovo ", "Google ", "Sony ", "ZTE ", "LG ");
    List<String> culoriTelefoane = Arrays.asList("Negru ", "Alb ", "Galben ", "Portocaliu ", "Roşu ", "Violet ", "Albastru ", "Turcoaz ", "Gri ", "Verde ", "Purpuriu ", "Cyan ");
    List<String> dimensiuniTelefon = Arrays.asList("5.2 inch ", "5.4 Inch ", "5.6 Inch ", "5.8 Inch ", "6.0 Inch ", "6.2 Inch, ", "6.4 Inch, ", "6.6 Inch ", "6.8 Inch ", "7.0 Inch ");
    List<String> sanatateBaterie = Arrays.asList("Foarte bună ", "Bună ", "Normală ", "Deteriorată ", "Foarte Deteriorată");
    List<String> procesoareTelefon = Arrays.asList("A16 Bionic", "Snapdragon 8 Gen 2", "A15 Bionic ", "Dimensity 9000+", "Exynos 2200", "Kirin 9000", "Google Tensor G2", "Kirin 9300E");

    @FXML
    private ListView<TelefonFix> Id2;

    @FXML
    public void OnAddTelFix() {
        Random random = new Random();

        TelefonFix tel = new TelefonFix();
        tel.calitateFoto = random.nextInt(50);
        tel.pret = random.nextInt(1000, 5000);
        tel.sistemDeOperare = sistemeDeOperare.get(random.nextInt(0, sistemeDeOperare.size()));
        tel.model = modeleTelefon.get(random.nextInt(0, modeleTelefon.size()));
        tel.setCuloareTelefon(culoriTelefoane.get(random.nextInt(0, culoriTelefoane.size())));
        tel.setRazaDeActiune(random.nextInt(0, 20));

        addTelFix(listaTelFixe, tel);
        Id2.getItems().setAll(listaTelFixe);

        try {
            FileOutputStream fos1 = new FileOutputStream("telFixe.txt");
            for (TelefonFix i : listaTelFixe) {
                byte[] bytes = i.toString().getBytes();
                fos1.write(bytes);
            }
            fos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    public void onShowFixList(){
        Id2.setVisible(true);
    }

    public void addTelFix(List<TelefonFix> listaTelFixe, TelefonFix tel){
        listaTelFixe.add(tel);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id2.setVisible(false);
    }

    public List<TelefonFix> getListaTelFixe() {
        return listaTelFixe;
    }

}