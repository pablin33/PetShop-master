package view;

import conexao.Conexao;
import entidades.Servicos;
import petshop.ServicosPet;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class ServicoView {
    String leia;


    ServicosPet servicosPet = new ServicosPet();
    Servicos servicos = new Servicos();

    public void CadastroServicos(){
        JOptionPane.showMessageDialog(null,"Cadastrando Servico");

        leia = JOptionPane.showInputDialog("Nome do Servico: ");
        servicos.setNome_servico(leia);

        leia = JOptionPane.showInputDialog("Preco do Servico: ");
        servicos.setPreco(Double.valueOf(leia));

        leia = JOptionPane.showInputDialog("Descricao do Servico: ");
        servicos.setDescricao(leia);


      servicosPet.CreateServico(servicos);

    }

    public void MostrarServicos(){

        for (Servicos showservicos : servicosPet.ShowServicos()) {
            System.out.println("ID do Servico: " + showservicos.getId_servico());
            System.out.println("Nome do Servico: " + showservicos.getNome_servico());
            System.out.println("Preco do Servico: " + showservicos.getPreco());
            System.out.println("Descricao do Servico: "+ showservicos.getDescricao());

        }
    }

    public void AtualizarServico(){
        JOptionPane.showMessageDialog(null,"Atualizando Servico");

        leia = JOptionPane.showInputDialog("Nome do Servico: ");
        servicos.setNome_servico(leia);

        leia = JOptionPane.showInputDialog("Preco do Servico: ");
        servicos.setPreco(Double.valueOf(leia));

        leia = JOptionPane.showInputDialog("Descricao do Servico: ");
        servicos.setDescricao(leia);


        servicosPet.UpdateServicos(servicos);
    }

    public void DeletarServico(int id_servico){

        String sql = "DELETE FROM servicos WHERE id_servico = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id_servico);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Servico deletado com sucesso");

        }catch (Exception exception){

            JOptionPane.showMessageDialog(null,exception);

        }

    }
}
