package view;

import conexao.Conexao;
import entidades.Animal;
import petshop.AnimalPet;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class AnimalView {

    AnimalPet animalPet = new AnimalPet();
    Animal animal = new Animal();

    String leia;

    public void CadastroAnimal(){
        JOptionPane.showMessageDialog(null,"Cadastrando Animal");

        leia = JOptionPane.showInputDialog("Nome do Animal: ");
        animal.setNome(leia);

        leia = JOptionPane.showInputDialog("Idade do animal: ");
        animal.setIdade(Integer.parseInt(leia));

        leia = JOptionPane.showInputDialog("Genero do Animal: ");
        animal.setGenero(leia);

        leia = JOptionPane.showInputDialog("Raca do Animal: ");
        animal.setRaca(leia);

        leia = JOptionPane.showInputDialog("Especie do Animal: ");
        animal.setEspecie(leia);

        animalPet.CreateAnimal(animal);

    }

    public void MostrarAnimal(){

        for (Animal showAnimal : animalPet.ShowAnimal()) {
            System.out.println("ID do Animal: " + showAnimal.getId_animal());
            System.out.println("Nome do Animal: " + showAnimal.getNome());
            System.out.println("Idade do Animal: " + showAnimal.getIdade());
            System.out.println("Genero do Animal: "+ showAnimal.getGenero());
            System.out.println("Raca do Animal: "+ showAnimal.getRaca());
            System.out.println("Especie do Animal: "+ showAnimal.getEspecie());
        }
    }

    public void AtualizarAnimal() {
        JOptionPane.showMessageDialog(null, "Atualizando Animal");

        leia = JOptionPane.showInputDialog("Nome do Animal: ");
        animal.setNome(leia);

        leia = JOptionPane.showInputDialog("Idade do animal: ");
        animal.setIdade(Integer.parseInt(leia));

        leia = JOptionPane.showInputDialog("Genero do Animal: ");
        animal.setGenero(leia);

        leia = JOptionPane.showInputDialog("Raca do Animal: ");
        animal.setRaca(leia);

        leia = JOptionPane.showInputDialog("Especie do Animal: ");
        animal.setEspecie(leia);


        AnimalPet.UpdateAnimal(animal);
    }

    public void DeletarAnimal(int id){

        String sql = "DELETE FROM animais WHERE id_animais = ?";

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try{

            connection = Conexao.conexaoMySQL();
            preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            preparedStatement.execute();

            JOptionPane.showMessageDialog(null,"Animal deletado com sucesso");

        }catch (Exception exception){

            JOptionPane.showMessageDialog(null,exception);

        }

    }

}
