package petshop;


import conexao.Conexao;
import entidades.Cliente;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.util.ArrayList;
import java.util.List;


public class ClientePet {

    public void CreateCliente(Cliente cliente) {

        String sql = "INSERT INTO clientes(nome, telefone, endereco, cpf) VALUES(?,?,?,?)";

        Connection connection;
        PreparedStatement preparedStatement;

        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getTelefone());
            preparedStatement.setString(3, cliente.getEndereco());
            preparedStatement.setString(4, cliente.getCpf());

            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Cadastrado Com Sucesso");


        } catch (Exception exception) {

            exception.printStackTrace();

        }

    }

    public List<Cliente> ShowClientes() {

        String sql = "SELECT * FROM clientes";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        //classe que vai recuperar os dados do banco.
        ResultSet resultSet = null;


        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                Cliente cliente = new Cliente();

                cliente.setId_cliente(resultSet.getInt("id_cliente"));
                cliente.setNome(resultSet.getString("nome"));
                cliente.setEndereco(resultSet.getString("endereco"));
                cliente.setTelefone(resultSet.getString("telefone"));
                cliente.setCpf(resultSet.getString("cpf"));

                clientes.add(cliente);

            }


        } catch (Exception e) {

            e.printStackTrace();

        }
        return  clientes;
    }

      public void UpdateClientes(Cliente cliente){

        String sql = "UPDATE clientes SET nome = ?, endereco = ?, telefone = ?, cpf = ? WHERE id_cliente = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cliente.getNome());
            preparedStatement.setString(2, cliente.getEndereco());
            preparedStatement.setString(3,cliente.getCpf());
            preparedStatement.setInt(4,cliente.getId_cliente());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Cliente atualizado com sucesso");

        }catch (Exception exception){

            exception.printStackTrace();

        }

      }

      public void DeletarCliente(int id){

        String sql = "DELETE FROM clientes WHERE id_cliente = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Cliente deletado com sucesso");

        }catch (Exception exception){

            JOptionPane.showMessageDialog(null,exception);

        }


      }

}