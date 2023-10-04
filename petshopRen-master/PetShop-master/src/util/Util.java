package util;

import view.AnimalView;
import view.ClienteView;
import view.ServicoView;

import javax.swing.*;
import java.util.Scanner;


public class Util {
    ClienteView clienteView  = new ClienteView();
    AnimalView animalview = new AnimalView();

    ServicoView servicoview = new ServicoView();



    public void Options(){

        Scanner leia = new Scanner(System.in);

        int exit;

        do {
            System.out.println("================= CLIENTE =========");
            System.out.println("1- Cadastrar cliente");
            System.out.println("2- Mostrar cliente");
            System.out.println("3- Atualizar cliente");
            System.out.println("4- Deletar cliente");
            System.out.println("================= ANIMAL =========");
            System.out.println("5- Cadastrar animal");
            System.out.println("6- Mostrar animal");
            System.out.println("7- Atualizar animal");
            System.out.println("8- Deletar animal");
            System.out.println("================= SERVICO =========");
            System.out.println("9 - Cadastrar servico");
            System.out.println("10- Mostrar servico");
            System.out.println("11- Atualizar servico");
            System.out.println("12 - Deletar servico");
            System.out.println("Digite a opcao desejada: ");


            int option = Integer.parseInt(leia.nextLine());

            switch (option) {
                case 1:
                    clienteView.CadastroCliente();
                    break;
                case 2:
                    clienteView.MostrarCliente();
                    break;
                case 3:
                    clienteView.AtualizarCliente();
                    break;
                case 4:
                    clienteView.DeletarCliente();
                    break;
                case 5:
                    animalview.CadastroAnimal();
                    break;
                case 6:
                    animalview.MostrarAnimal();
                    break;
                case 7:
                    animalview.AtualizarAnimal();
                    break;
                case 8:
                    animalview.DeletarAnimal(leia.nextInt());
                    break;
                case 9:
                    servicoview.CadastroServicos();
                    break;
                case 10:
                    servicoview.MostrarServicos();
                    break;
                case 11:
                    servicoview.AtualizarServico();
                    break;
                case 12:
                    servicoview.DeletarServico(leia.nextInt());
                default:
                    JOptionPane.showMessageDialog(null,"Opcao invalida tente novamente");
                    break;
            }
            exit = JOptionPane.showConfirmDialog(null,"Deseja voltar ao menu? ");
        }while (exit != JOptionPane.NO_OPTION && exit != JOptionPane.CANCEL_OPTION);

    }

}