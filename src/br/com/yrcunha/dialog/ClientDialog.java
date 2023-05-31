package br.com.yrcunha.dialog;

import br.com.yrcunha.dao.ClientDao;
import br.com.yrcunha.dao.ClientMapDao;
import br.com.yrcunha.domain.Client;

import javax.swing.*;

public class ClientDialog {
    private final ClientDao clientDao;

    public ClientDialog() {
        clientDao = new ClientMapDao();
    }

    public Boolean isValidOption(String option) {
        return option.contains("1") | option.contains("2") | option.contains("3") | option.contains("4") | option.contains("5");
    }

    public void goOut(String message, int messageType) {
        JOptionPane.showMessageDialog(null, message, "Sair", messageType);
        System.exit(0);
    }

    public String showOptions() {
        return JOptionPane.showInputDialog(null, "Digite: \n 1) Para cadastrar; \n 2) Para consultar; \n 3) Para excluir; \n 4) Para alterar; ou, \n 5) Para sair \n", "Cadastro de Cliente", JOptionPane.INFORMATION_MESSAGE);
    }

    public boolean createClient() {
        String name = JOptionPane.showInputDialog("Qual o nome?");
        String document = JOptionPane.showInputDialog("Qual o CPF?");
        String phone = JOptionPane.showInputDialog("Qual o Telefone?");
        String address = JOptionPane.showInputDialog("Informações o endereço sepado por virgula: endereço, número da casa, cidade e estado.");
        // TODO, fazer tratamento dos dados de enderesso
        Client client = new Client(name, document, phone);
        return clientDao.create(client);
    }

    public void findClient() {
        String document = JOptionPane.showInputDialog("Caso queira uma busca especifica informe o CPF: ");
        Client client = clientDao.finByDocument(document);
        JOptionPane.showMessageDialog(null, client.toString());
    }

    public boolean excludeClient() {
        String document = JOptionPane.showInputDialog("Informe o CPF do cliente a ser deletado: ");
        return clientDao.delete(document);
    }

    public boolean updateClient() {
        String aditionalInfos = JOptionPane.showInputDialog("Informações adicionais, separe por virgula: telefone, endereço, número da casa, cidade e estado", "INFORMAÇÕES ADICIONAIS");
        return true;
    }

    public void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Erro!", JOptionPane.ERROR_MESSAGE);
    }
}
