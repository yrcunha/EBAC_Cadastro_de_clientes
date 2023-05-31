import br.com.yrcunha.dialog.ClientDialog;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        ClientDialog clientDialog = new ClientDialog();
        String option = cycle(clientDialog).trim();

        while (!"5".equals(option)) {
            switch (option) {
                case "1" -> {
                    boolean isCreate = clientDialog.createClient();
                    if (!isCreate) clientDialog.showError("Erro na criação de cliente!");
                    option = cycle(clientDialog);
                }
                case "2" -> {
                    clientDialog.findClient();
                    option = cycle(clientDialog).trim();
                }
                case "3" -> {
                    boolean isExclude = clientDialog.excludeClient();
                    if (!isExclude) clientDialog.showError("Erro ao deletar cliente!");
                    option = cycle(clientDialog).trim();
                }
                case "4" -> {
                    boolean isUpdate = clientDialog.updateClient();
                    if (!isUpdate) clientDialog.showError("Erro ao deletar cliente!");
                    option = cycle(clientDialog).trim();
                }
                default -> option = cycle(clientDialog);
            }
        }

        clientDialog.goOut("Até logo!", JOptionPane.INFORMATION_MESSAGE);
    }

    private static String cycle(ClientDialog clientDialog) {
        String option = clientDialog.showOptions().trim();
        while (!clientDialog.isValidOption(option)) {
            if ("".equals(option)) {
                clientDialog.goOut("Houve um erro na definição das opções!", JOptionPane.ERROR_MESSAGE);
            }
            option = clientDialog.showOptions();
        }
        return option;
    }
}