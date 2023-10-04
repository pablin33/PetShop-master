package petshop;

import conexao.Conexao;

import entidades.Servicos;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ServicosPet {

    public void CreateServico(Servicos servicos) {

        String sql = "INSERT INTO servicos (id_servico, nome_servico, preco, descricao) VALUES(?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, servicos.getId_servico());
            preparedStatement.setString(2, servicos.getNome_servico());
            preparedStatement.setDouble(3, servicos.getPreco());
            preparedStatement.setString(4, servicos.getDescricao());

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, " Servico cadastrado com sucesso");

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    public List<Servicos> ShowServicos() {

        String sql = "SELECT * FROM servicos";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ArrayList<Servicos> servicos = new ArrayList<Servicos>();
        //classe que vai recuperar os dados do banco.
        ResultSet resultSet = null;

        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                Servicos servico = new Servicos();


                servico.setId_servico(resultSet.getInt("id_servico"));
                servico.setNome_servico(resultSet.getString("nome_servico"));
                servico.setPreco(resultSet.getDouble("preco"));
                servico.setDescricao(resultSet.getString("descricao"));

                servicos.add(servico);


            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return servicos;
    }

    public void UpdateServicos(Servicos servicos) {

        String sql = "UPDATE servicos SET id_servico = ?, nome_servico = ?, preco = ?, descricao = ?, WHERE id_servico = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, servicos.getNome_servico());
            preparedStatement.setDouble(2, servicos.getPreco());
            preparedStatement.setString(3, servicos.getDescricao());
            preparedStatement.setInt(4, servicos.getId_servico());


            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Servico atualizado com sucesso");

        } catch (Exception exception) {

            exception.printStackTrace();

        }
    }

    public void DeletarServico(int id_servico) {

        String sql = "DELETE FROM servicos WHERE id_servicos = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id_servico);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null, "Servico deletado com sucesso");

        } catch (Exception exception) {

            JOptionPane.showMessageDialog(null, exception);

        }

    }

}
