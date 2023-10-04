package view;

import entidades.Cliente;
import petshop.ClientePet;


import javax.swing.*;


public class ClienteView {

    String leia;


    ClientePet clientePet = new ClientePet();
    Cliente cliente = new Cliente();

    public void CadastroCliente(){
        JOptionPane.showMessageDialog(null,"Cadastrando Cliente");

        leia = JOptionPane.showInputDialog("Nome do Cliente: ");
        cliente.setNome(leia);

        leia = JOptionPane.showInputDialog("Endereco do Cliente: ");
        cliente.setEndereco(leia);

        leia = JOptionPane.showInputDialog("Telefone do Cliente: ");
        cliente.setTelefone(leia);

        leia = JOptionPane.showInputDialog("Cpf do cliente: ");
        cliente.setCpf(leia);

        clientePet.CreateCliente(cliente);

    }

    public void MostrarCliente(){

        for (Cliente showClientes : clientePet.ShowClientes()) {
            System.out.println("ID do cliente: " + showClientes.getId_cliente());
            System.out.println("Nome do cliente: " + showClientes.getNome());
            System.out.println("Endereco do cliente: " + showClientes.getEndereco());
            System.out.println("Telefone do cliente: "+ showClientes.getTelefone());
            System.out.println("Cpf do cliente: "+ showClientes.getCpf());

        }
    }

    public void AtualizarCliente(){
        JOptionPane.showMessageDialog(null,"Atualizando Cliente");

        leia = JOptionPane.showInputDialog("Nome do Cliente: ");
        cliente.setNome(leia);

        leia = JOptionPane.showInputDialog("Endereco do Cliente: ");
        cliente.setEndereco(leia);

        leia = JOptionPane.showInputDialog("Telefone do Cliente: ");
        cliente.setTelefone(leia);

        leia = JOptionPane.showInputDialog("Cpf do cliente: ");
        cliente.setCpf(leia);

        clientePet.UpdateClientes(cliente);
    }


    public void DeletarCliente() {
        String input = JOptionPane.showInputDialog("Qual cliente deseja deletar? [ID]");


        int id = Integer.parseInt(input);

        int confirm = JOptionPane.showConfirmDialog(null, "Tem certeza?");

        if (confirm == JOptionPane.OK_OPTION) {

            clientePet.DeletarCliente(id);
        } else {
            JOptionPane.showMessageDialog(null, "Exclusão cancelada");
        }

    }


}
