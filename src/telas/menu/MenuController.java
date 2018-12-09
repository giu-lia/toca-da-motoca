package telas.menu;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import secao.Secao;
import telas.addMoto.AddMotoTela;
import telas.alugarMoto.AlugarMotoTela;
import telas.cadastrarCliente.CadastrarClienteTela;
import telas.removerCliente.RemoverClienteTela;
import telas.removerMoto.RemoverMotoTela;

public class MenuController {

    /** Responsável por controlar os elementos da tela do Menu aka MenuTela.java**/

    public Label lblOla;

    public void ola(){
        lblOla.setText("Olá, " + Secao.getInstancia().getUsuarioLogado().getNome());
    }

    public void alugarMoto(){
        AlugarMotoTela alugarMotoTela = new AlugarMotoTela();

        Stage novaJanela = new Stage();
        try {
            alugarMotoTela.start(novaJanela);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void adicionarMoto(ActionEvent e){
        AddMotoTela addMotoTela = new AddMotoTela();

        Stage novaJanela = new Stage();
        try {
            addMotoTela.start(novaJanela);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void removerMoto(){
        RemoverMotoTela removerMotoTela = new RemoverMotoTela();

        Stage novaJanela = new Stage();
        try {
            removerMotoTela.start(novaJanela);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void cadastrarCliente(){
        CadastrarClienteTela cadastrarClienteTela = new CadastrarClienteTela();

        Stage novaJanela = new Stage();
        try {
            cadastrarClienteTela.start(novaJanela);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void removerCliente(){
        RemoverClienteTela removerClienteTela = new RemoverClienteTela();

        Stage novaJanela = new Stage();
        try {
            removerClienteTela.start(novaJanela);
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

}
