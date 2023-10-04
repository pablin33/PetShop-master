package petshop;

import conexao.Conexao;
import entidades.Animal;


import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class AnimalPet {

    public void CreateAnimal(Animal animal){

        String sql = "INSERT INTO animais (id_animal, nome, raca, idade, especie, genero) VALUES(?,?,?,?,?,?)";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, animal.getId_animal());
            preparedStatement.setString(2,animal.getNome());
            preparedStatement.setString(3, animal.getRaca());
            preparedStatement.setInt(4, animal.getIdade());
            preparedStatement.setString(5,animal.getEspecie());
            preparedStatement.setString(6, animal.getGenero());


            preparedStatement.execute();
            JOptionPane.showMessageDialog(null," Animal cadastrado com sucesso");


        }catch (Exception exception) {

        exception.printStackTrace();

        }

    }
    public List<Animal> ShowAnimal() {

        String sql = "SELECT * FROM animais";

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;


        ArrayList<Animal> animal = new ArrayList<Animal>();
        //classe que vai recuperar os dados do banco.

        try {

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();


            while (resultSet.next()) {

                Animal animais = new Animal();


                animais.setId_animal(resultSet.getInt("id_animal"));
                animais.setNome(resultSet.getString("nome"));
                animais.setRaca(resultSet.getString("raca"));
                animais.setIdade(resultSet.getInt("idade"));
                animais.setEspecie(resultSet.getString("especie"));
                animais.setGenero(resultSet.getString("genero"));
                animal.add(animais);


            }

        } catch (Exception e) {

            e.printStackTrace();

        }
        return animal;
    }
    public static void UpdateAnimal(Animal animal){

        String sql = "UPDATE animais SET nome_animal=?,especie=?,raca=?,id_cliente=? WHERE id_animal=?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, animal.getNome());
            preparedStatement.setString(2,animal.getRaca());
            preparedStatement.setInt(3,animal.getIdade());
            preparedStatement.setString(4, animal.getEspecie());
            preparedStatement.setString(5,animal.getGenero());
            preparedStatement.setInt(6,animal.getId_animal());

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Animal atualizado com sucesso");

        }catch (Exception exception) {

            System.out.println("Erro: " + exception);
        }
    }
    public void DeletarAnimal(int id_animal){

        String sql = "DELETE FROM animais WHERE id_animal = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id_animal);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Animal deletado com sucesso");

        }catch (Exception exception){

            JOptionPane.showMessageDialog(null,exception);

        }


    }

}
