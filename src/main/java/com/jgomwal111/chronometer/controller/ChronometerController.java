package com.jgomwal111.chronometer.controller;

import com.jgomwal111.chronometer.model.dao.ChronometerDAO;
import com.jgomwal111.chronometer.model.dataObject.Chronometer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class ChronometerController implements Initializable {

    /**
     * Objetos usados para la clase
     */
    private Chronometer c;
    //private ChronometerDAO cDAO = new ChronometerDAO(c);

    /**
     * Elementos FXML
     */
    @FXML private Button btnPlay;
    @FXML private Button btnPause;
    @FXML private Button btnReset;
    @FXML private ImageView imgPlay;
    @FXML private ImageView imgPause;
    @FXML private ImageView imgReset;
    @FXML private TextField tfChronometer;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tfChronometer.setText("00:00:00");
        btnPlay.setVisible(true);
        imgPlay.setVisible(true);
        btnPause.setVisible(false);
        imgPause.setVisible(false);
        btnReset.setVisible(true);
        imgReset.setVisible(true);
    }

    @FXML public void play(){
        c = new Chronometer(-1,"",tfChronometer);
            c.start();
            System.out.println(c.getTime());

            if(!c.isInterrupted()) {
                btnPlay.setVisible(false);
                imgPlay.setVisible(false);
                btnPause.setVisible(true);
                imgPause.setVisible(true);
                btnReset.setVisible(false);
                imgReset.setVisible(false);
            }
    }

    @FXML public void pause(){
            if(!c.isInterrupted()){
                c.interrupt();
                btnPlay.setVisible(true);
                imgPlay.setVisible(true);
                btnPause.setVisible(false);
                imgPause.setVisible(false);
                btnReset.setVisible(true);
                imgReset.setVisible(true);
            }
    }

    @FXML public void reset(){
            if(c.isInterrupted()){
                tfChronometer.setText("00:00:00");
                btnPlay.setVisible(true);
                imgPlay.setVisible(true);
                btnPause.setVisible(false);
                imgPause.setVisible(false);
                btnReset.setVisible(true);
                imgReset.setVisible(true);
            }
    }


}