package com.example.proiecttelefoane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.function.Predicate;

public class HelloController implements Initializable {

    @FXML
    private Button AddMobil;
    @FXML
    private Button AddFix;
    @FXML
    private Button AddPublic;
    @FXML
    private Button ShowMobil;
    @FXML
    private Button ShowFix;
    @FXML
    private Button ShowPublic;
    @FXML
    private TextField searchTelPublic;
    @FXML
    private TextField searchTelFix;
    @FXML
    private TextField searchTelMobil;

    List<TelefonMobil> listaTelMobile = new ArrayList<TelefonMobil>();

    List<TelefonFix> listaTelFixe = new ArrayList<TelefonFix>();

    List<TelefonPublic> listaTelPublice = new ArrayList<TelefonPublic>();

    List<String> sistemeDeOperare = Arrays.asList("Google Android ", "Apple iOS ", "Windows Phone ");

    List<String> modeleTelefon = Arrays.asList("IPhone ", "Samsung ", "Huawei ", "Xiaomi ", "One Plus ", "Lenovo ", "Google ", "Sony ", "ZTE ", "LG ");
    List<String> culoriTelefoane = Arrays.asList("Negru ", "Alb ", "Galben ", "Portocaliu ", "Roşu ", "Violet ", "Albastru ", "Turcoaz ", "Gri ", "Verde ", "Purpuriu ", "Cyan ");
    List<String> dimensiuniTelefon = Arrays.asList("5.2 inch ", "5.4 Inch ", "5.6 Inch ", "5.8 Inch ", "6.0 Inch ", "6.2 Inch, ", "6.4 Inch, ", "6.6 Inch ", "6.8 Inch ", "7.0 Inch ");
    List<String> sanatateBaterie = Arrays.asList("Foarte bună ", "Bună ", "Normală ", "Deteriorată ", "Foarte Deteriorată");
    List<String> procesoareTelefon = Arrays.asList("A16 Bionic", "Snapdragon 8 Gen 2", "A15 Bionic ", "Dimensity 9000+", "Exynos 2200", "Kirin 9000", "Google Tensor G2", "Kirin 9300E");

    @FXML
    private ListView<TelefonMobil> Id1;
    @FXML
    private ListView<TelefonFix> Id2;
    @FXML
    private ListView<TelefonPublic> Id3;

    @FXML
    private Button buttonSearchMobil;
    @FXML
    private Button buttonSearchFix;
    @FXML
    private Button buttonSearchPublic;
    @FXML
    private Button buttonImport;
    @FXML
    private ListView<String> listaImport;

   @FXML
    public void searchByMarcaMobil(){
        List<TelefonMobil> lst_aux = new ArrayList<TelefonMobil>();

        for(TelefonMobil i: listaTelMobile){
            String searchText = searchTelMobil.getText().trim().toLowerCase();
            String modelText = i.getModel().trim().toLowerCase();
            //System.out.println(searchText + " - " + modelText);
           if(searchText.equals(modelText)){
                //System.out.println("ceva");
                lst_aux.add(i);
           }
        }

        Id1.getItems().setAll(lst_aux);
    }

    @FXML
    public void searchByMarcaFix(){
        List<TelefonFix> lst_aux = new ArrayList<TelefonFix>();

        for(TelefonFix i: listaTelFixe){
            String searchText = searchTelFix.getText().trim().toLowerCase();
            String modelText = i.getModel().trim().toLowerCase();
            //System.out.println(searchText + " - " + modelText);
            if(searchText.equals(modelText)){
                //System.out.println("ceva");
                lst_aux.add(i);
            }
        }

        Id2.getItems().setAll(lst_aux);
    }

    @FXML
    public void searchByMarcaPublic(){
        List<TelefonPublic> lst_aux = new ArrayList<TelefonPublic>();

        for(TelefonPublic i: listaTelPublice){
            String searchText = searchTelPublic.getText().trim().toLowerCase();
            String modelText = i.getModel().trim().toLowerCase();
            //System.out.println(searchText + " - " + modelText);
            if(searchText.equals(modelText)){
                //System.out.println("ceva");
                lst_aux.add(i);
            }
        }

        Id3.getItems().setAll(lst_aux);
    }
    @FXML
    public void OnAddTelPublic() {
        Random random = new Random();

        TelefonPublic tel = new TelefonPublic();
        tel.calitateFoto = random.nextInt(50);
        tel.pret = random.nextInt( 5000);
        tel.sistemDeOperare = sistemeDeOperare.get(random.nextInt( sistemeDeOperare.size()));
        tel.model = modeleTelefon.get(random.nextInt(0, modeleTelefon.size()));
        tel.setCuloareTelefon(culoriTelefoane.get(random.nextInt( culoriTelefoane.size())));
        tel.setDimensiuneaCabinei(random.nextInt(5));
        tel.setDimensiuniTelefon(dimensiuniTelefon.get(random.nextInt( dimensiuniTelefon.size())));
        tel.setSanatateBaterie(sanatateBaterie.get(random.nextInt( sanatateBaterie.size())));

        addTelPublic(listaTelPublice, tel);
        Id3.getItems().setAll(listaTelPublice);

        try {
            FileOutputStream fos1 = new FileOutputStream("telPublice.txt");
            for (TelefonPublic i : listaTelPublice) {
                byte[] bytes = i.toString().getBytes();
                fos1.write(bytes);
            }
            fos1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void OnAddTelMobil() {
        Random random = new Random();

        TelefonMobil tel = new TelefonMobil();
        tel.calitateFoto = random.nextInt(50);
        tel.pret = random.nextInt( 5000);
        tel.sistemDeOperare = sistemeDeOperare.get(random.nextInt( sistemeDeOperare.size()));
        tel.model = modeleTelefon.get(random.nextInt( modeleTelefon.size()));
        tel.setCuloareTelefon(culoriTelefoane.get(random.nextInt( culoriTelefoane.size())));
        tel.setDimensiuniTelefon(dimensiuniTelefon.get(random.nextInt( dimensiuniTelefon.size())));
        tel.setProcesorTelefon(procesoareTelefon.get(random.nextInt( procesoareTelefon.size())));
        tel.setSanatateBaterie(sanatateBaterie.get(random.nextInt( sanatateBaterie.size())));

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
    public void OnAddTelFix() {
        Random random = new Random();

        TelefonFix tel = new TelefonFix();
        tel.calitateFoto = random.nextInt(50);
        tel.pret = random.nextInt( 5000);
        tel.sistemDeOperare = sistemeDeOperare.get(random.nextInt( sistemeDeOperare.size()));
        tel.model = modeleTelefon.get(random.nextInt( modeleTelefon.size()));
        tel.setCuloareTelefon(culoriTelefoane.get(random.nextInt( culoriTelefoane.size())));
        tel.setRazaDeActiune(random.nextInt(20));

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
    public void onShowMobilList() {
        Id1.setVisible(true);
        Id1.getItems().setAll(listaTelMobile);
    }

    @FXML
    public void onShowFixList() {
        Id2.setVisible(true);
        Id2.getItems().setAll(listaTelFixe);
    }

    @FXML
    public void onShowPublicList() {
        Id3.setVisible(true);
        Id3.getItems().setAll(listaTelPublice);
    }

    public void addTelMobil(List<TelefonMobil> listaTelMobil, TelefonMobil tel) {
        listaTelMobil.add(tel);

    }

    public void addTelFix(List<TelefonFix> listaTelFixe, TelefonFix tel) {
        listaTelFixe.add(tel);

    }

    public void addTelPublic(List<TelefonPublic> listaTelPublice, TelefonPublic tel) {
        listaTelPublice.add(tel);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Id3.setVisible(false);
        Id2.setVisible(false);
        Id1.setVisible(false);
        listaImport.setVisible(false);
    }

    public List<TelefonMobil> getListaTelMobile() {
        return listaTelMobile;
    }

    public List<TelefonFix> getListaTelFixe() {
        return listaTelFixe;
    }

    public List<TelefonPublic> getListaTelPublice() {
        return listaTelPublice;
    }

    @FXML
    public void importFisierTxt(){
        try {
            List<String> Importlista = new ArrayList<String>();
            // Create a FileReader object
            FileReader fileReader = new FileReader("fisierulMeu.txt");
            // Wrap the FileReader in a BufferedReader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            // Read the file line by line
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // Process the line
               // System.out.println(line);
                Importlista.add(line);
            }
            // Close the BufferedReader
            listaImport.getItems().setAll(Importlista);
            listaImport.setVisible(true);
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
