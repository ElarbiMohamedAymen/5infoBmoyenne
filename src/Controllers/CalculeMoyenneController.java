/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author ElarbiMohamedAymen
 */
public class CalculeMoyenneController implements Initializable {

    @FXML
    private JFXRadioButton GLradioButtion;
    @FXML
    private JFXRadioButton BIradioButtion;
    @FXML
    private JFXRadioButton AngularRadioButtion;
    @FXML
    private JFXTextField dotNETTF;
    @FXML
    private JFXTextField SOATF;
    @FXML
    private Label SOADOTMOY;
    @FXML
    private JFXTextField FRTF;
    @FXML
    private JFXTextField AngTF;
    @FXML
    private Label LanguesTF;
    @FXML
    private JFXTextField DroitTF;
    @FXML
    private JFXTextField SARTF;
    @FXML
    private JFXTextField SecTF;
    @FXML
    private Label RXMOY;
    @FXML
    private JFXTextField BDTF;
    @FXML
    private JFXTextField IATF;
    @FXML
    private Label IAMOY;
    @FXML
    private JFXTextField SpringTF;
    @FXML
    private JFXTextField ICTF;
    @FXML
    private Label optTF;
    @FXML
    private JFXTextField BITF;
    @FXML
    private JFXTextField AngularTF;
    @FXML
    private Label MOYENNETF;
    ToggleGroup group;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        group = new ToggleGroup();
        GLradioButtion.setToggleGroup(group);
        BIradioButtion.setToggleGroup(group);
        AngularRadioButtion.setToggleGroup(group);

    }

    @FXML
    private void CalculerMoyenne(ActionEvent event) {
        if (group.getSelectedToggle() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Gethro");
            alert.setHeaderText(null);
            alert.setContentText("Please choose an option...");
            alert.showAndWait();
        }
        if (!ControlSaisie(dotNETTF)) {
            return;
        }
        if (!ControlSaisie(SOATF)) {
            return;
        }
        if (!ControlSaisie(SARTF)) {
            return;
        }
        if (!ControlSaisie(SecTF)) {
            return;
        }
        if (!ControlSaisie(BDTF)) {
            return;
        }
        if (!ControlSaisie(FRTF)) {
            return;
        }
        if (!ControlSaisie(AngTF)) {
            return;
        }
        if (!ControlSaisie(DroitTF)) {
            return;
        }
        if (!ControlSaisie(IATF)) {
            return;
        }

        MOYENNETF.setText(moyenne());
    }

    @FXML
    private void ChoosingGL(ActionEvent event) {
        BITF.setDisable(true);
        AngularTF.setDisable(true);
        SpringTF.setDisable(false);
        ICTF.setDisable(false);
    }

    @FXML
    private void ChoosingBI(ActionEvent event) {

        AngularTF.setDisable(true);
        SpringTF.setDisable(true);
        ICTF.setDisable(true);
        BITF.setDisable(false);
    }

    @FXML
    private void ChoosingAngular(ActionEvent event) {
        BITF.setDisable(true);
        SpringTF.setDisable(true);
        ICTF.setDisable(true);
        AngularTF.setDisable(false);

    }

    private String moyenne() {
        Float DotNET, SOA, MoyenneSOADotNET,
                Fr, Ang, Droit, MoyenneLangue,
                IA,
                SAR, SEC, BD, MoyenneSarSecBd,
                Spring, IC, Bi, Angular, MoyenneOption;
        String tmp;

        try {
            tmp = dotNETTF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            DotNET = Float.valueOf(tmp) * 3;
        } catch (Exception e) {
            DotNET = 0f;
        }
        try {
            tmp = SOATF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            SOA = Float.valueOf(tmp) * 3;
        } catch (Exception e) {
            SOA = 0f;
        }
        MoyenneSOADotNET = (DotNET + SOA) / 6;
        SOADOTMOY.setText(String.valueOf(MoyenneSOADotNET));

        try {
            tmp = FRTF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }

            Fr = Float.valueOf(tmp) * 2;
        } catch (Exception e) {
            Fr = 0f;
        }
        try {
            tmp = AngTF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            Ang = Float.valueOf(tmp) * 2;
        } catch (Exception e) {
            Ang = 0f;
        }
        try {
            tmp = DroitTF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            Droit = Float.valueOf(tmp) * 2;
        } catch (Exception e) {
            Droit = 0f;
        }
        MoyenneLangue = (Fr + Ang + Droit) / 6;
        LanguesTF.setText(String.valueOf(MoyenneLangue));

        try {
            tmp = IATF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            IA = Float.valueOf(tmp) * 2;
        } catch (Exception e) {
            IA = 0f;
        }
        IAMOY.setText(String.valueOf(IA / 2));

        try {
            tmp = SARTF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            SAR = Float.valueOf(tmp) * 3;
        } catch (Exception e) {
            SAR = 0f;
        }
        try {
            tmp = SecTF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            SEC = Float.valueOf(tmp) * 3;
        } catch (Exception e) {
            SEC = 0f;
        }
        try {
            tmp = BDTF.getText().trim();
            if (tmp.contains(",")) {
                tmp = tmp.replaceAll(",", ".");
            }
            BD = Float.valueOf(tmp) * 2;
        } catch (Exception e) {
            BD = 0f;
        }
        MoyenneSarSecBd = (SAR + SEC + BD) / 8;
        RXMOY.setText(String.valueOf(MoyenneSarSecBd));

        JFXRadioButton selectedRadioButton = (JFXRadioButton) group.getSelectedToggle();
        String toogleGroupValue = selectedRadioButton.getText();

        if (toogleGroupValue.equals("GL")) {
            if (!ControlSaisie(SpringTF)) {
                return String.valueOf(0);
            }
            if (!ControlSaisie(ICTF)) {
                return String.valueOf(0);
            }
            try {
                tmp = SpringTF.getText().trim();
                if (tmp.contains(",")) {
                    tmp = tmp.replaceAll(",", ".");
                }
                Spring = Float.valueOf(tmp) * 1.5f;
            } catch (Exception e) {
                Spring = 0f;
            }
            try {
                tmp = ICTF.getText().trim();
                if (tmp.contains(",")) {
                    tmp = tmp.replaceAll(",", ".");
                }
                IC = Float.valueOf(tmp) * 1.5f;
            } catch (Exception e) {
                IC = 0f;
            }
            MoyenneOption = (Spring + IC);
        } else if (toogleGroupValue.equals("Angular")) {
            if (!ControlSaisie(AngularTF)) {
                return String.valueOf(0);
            }
            try {
                tmp = AngularTF.getText().trim();
                if (tmp.contains(",")) {
                    tmp = tmp.replaceAll(",", ".");
                }
                Angular = Float.valueOf(tmp) * 3;
            } catch (Exception e) {
                Angular = 0f;
            }
            MoyenneOption = Angular;
        } else {
            if (!ControlSaisie(BITF)) {
                return String.valueOf(0);
            }
            try {
                tmp = BITF.getText().trim();
                if (tmp.contains(",")) {
                    tmp = tmp.replaceAll(",", ".");
                }
                Bi = Float.valueOf(tmp) * 3;
            } catch (Exception e) {
                Bi = 0f;
            }
            MoyenneOption = Bi;
        }
        optTF.setText(String.valueOf(MoyenneOption / 3));
        Float MoyenneFinal = (DotNET + SOA + Fr + Ang + Droit + SAR + SEC + BD + IA + MoyenneOption) / 25;
        return String.valueOf(MoyenneFinal);
    }

    private boolean ControlSaisie(JFXTextField fXTextField) {
        float test;
        try {
            test = Float.valueOf(fXTextField.getText());
            if (test < 0 || test > 20) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Dialog");
                alert.setHeaderText(null);
                alert.setContentText("Note doit etre entre 0 et 20");
                alert.showAndWait();
                fXTextField.requestFocus();
                return false;
            }
        } catch (Exception E) {
            test = 0f;
        }
        return true;
    }
}
