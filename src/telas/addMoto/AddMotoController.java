package telas.addMoto;

import bancoDeDados.VeiculoDAO;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.layout.Region;
import modelos.Veiculo;

public class AddMotoController {

    /** Responsável por controlar os elementos da tela de Adicionar Moto aka AddMotoTela.java.**/

    public TextField edtMarca;
    public TextField edtModelo;
    public TextField edtLargura;
    public TextField edtAltura;
    public TextField edtPeso;
    public TextField edtMotor;
    public TextField edtTanque;
    public TextField edtConsumo;
    public CheckBox chkPorta;
    public CheckBox chkRadio;
    public CheckBox chkCD;
    public CheckBox chkEscudo;
    public MenuButton menuCategoria;
    public TextField edtAno;
    public TextField edtAluguel;

    int categoria = 1;

    public void categoriaEconomica(ActionEvent e){
        categoria = 1;
        menuCategoria.setText("Economica");
    }

    public void categoriaStandard(ActionEvent e){
        categoria = 2;
        menuCategoria.setText("Standard");
    }

    public void categoriaPremium(ActionEvent e){
        categoria = 3;
        menuCategoria.setText("Premium");
    }

    public void salvarMoto(ActionEvent e){
        boolean temErro = false;
        String msgErro = "";

        System.out.println(chkPorta.isSelected());

        // obrigatorios

        if(edtAno.getText().equals("")){
            temErro = true;
            msgErro = "Defina o ano da moto.";
        }

        if(edtMarca.getText().equals("")){
            temErro = true;
            msgErro = "Defina a marca da moto.";
        }

        if(edtModelo.getText().equals("")){
            temErro = true;
            msgErro = "Defina o modelo da moto.";
        }

        if(edtLargura.getText().equals("")){
            temErro = true;
            msgErro = "Defina a largura da moto.";
        }

        if(edtAltura.getText().equals("")){
            temErro = true;
            msgErro = "Defina a altura da moto.";
        }

        if(edtMotor.getText().equals("")){
            temErro = true;
            msgErro = "Defina o motor da moto.";
        }

        if(edtTanque.getText().equals("")){
            temErro = true;
            msgErro = "Defina a capacidade do tanque da moto.";
        }

        if(edtConsumo.getText().equals("")){
            temErro = true;
            msgErro = "Defina o consumo médio da moto.";
        }

        if(temErro){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Campos inválidos");
            alert.setHeaderText("Campos inválidos");
            alert.setContentText(msgErro);
            alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
            alert.showAndWait();
        }
        else {
            Veiculo veiculo = new Veiculo(
                    true,
                    categoria,
                    edtMarca.getText(),
                    edtModelo.getText(),
                    Integer.valueOf(edtAno.getText()),
                    Float.valueOf(edtAltura.getText()),
                    Float.valueOf(edtLargura.getText()),
                    Float.valueOf(edtPeso.getText()),
                    edtMotor.getText(),
                    Float.valueOf(edtTanque.getText().replace(',', '.')),
                    Float.valueOf(edtConsumo.getText().replace(',', '.')),
                    chkPorta.isSelected(),
                    chkRadio.isSelected(),
                    chkCD.isSelected(),
                    chkEscudo.isSelected(),
                    Float.valueOf(edtAluguel.getText().replace(',', '.'))
                    );

            VeiculoDAO.salvarVeiculo(veiculo);
        }
    }

}