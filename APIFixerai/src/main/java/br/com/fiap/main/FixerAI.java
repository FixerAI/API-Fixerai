package br.com.fiap.main;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;

public class FixerAI {

    static String textValue(String value) {
        return JOptionPane.showInputDialog(value);
    }

    static int integerValue(String value) {
        return Integer.parseInt(JOptionPane.showInputDialog(value));
    }

    static double doubleValue(String value) {
        return Double.parseDouble(JOptionPane.showInputDialog(value));
    }

    static LocalDate dateValue(String value) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return LocalDate.parse(JOptionPane.showInputDialog(value), formatter);
    }

    public static void main(String[] args) {
        ArrayList<Cliente> clienteArr = new ArrayList<>();
        ClienteDAO clienteDAO = new ClienteDAO();

        do {
            Cliente cliente = new Cliente();

            cliente.setCpf(textValue("Informe seu CPF:"));
            cliente.setNome(textValue("Digite seu nome:"));
            cliente.setDataNasc(dateValue("Informe sua data de nascimento (dd/MM/yyyy):"));
            cliente.setBairro(textValue("Informe seu bairro:"));
            cliente.setEmail(textValue("Digite seu email:"));
            cliente.setCep(textValue("Informe o CEP:"));
            cliente.setNumero(integerValue("Digite o número da residência:"));
            cliente.setComplemento(textValue("Informe o complemento (se houver):"));
            cliente.setLogradouro(textValue("Informe o logradouro:"));
            cliente.setTelefone(textValue("Digite seu telefone:"));
            cliente.setNumeroCNH(textValue("Informe o número da CNH:"));
            cliente.setDataVali(dateValue("Informe a data de validade da CNH (dd/MM/yyyy):"));
            cliente.setDataEmissao(dateValue("Informe a data de emissão da CNH (dd/MM/yyyy):"));
            cliente.setCategoria(textValue("Informe a categoria da CNH:"));

            clienteArr.add(cliente);

        } while (JOptionPane.showConfirmDialog(null, "Deseja adicionar outro cliente?", "Confirmação", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION);

        for (Cliente cliente : clienteArr) {
            System.out.println(
                "===== Dados do Cliente =====\n" +
                "Nome: " + cliente.getNome() + "\n" +
                "CPF: " + cliente.getCpf() + "\n" +
                "Data de Nascimento: " + cliente.getDataNasc() + "\n" +
                "Bairro: " + cliente.getBairro() + "\n" +
                "Email: " + cliente.getEmail() + "\n" +
                "CEP: " + cliente.getCep() + "\n" +
                "Número da Residência: " + cliente.getNumero() + "\n" +
                "Complemento: " + cliente.getComplemento() + "\n" +
                "Logradouro: " + cliente.getLogradouro() + "\n" +
                "Telefone: " + cliente.getTelefone() + "\n" +
                "Número da CNH: " + cliente.getNumeroCNH() + "\n" +
                "Validade da CNH: " + cliente.getDataVali() + "\n" +
                "Categoria da CNH: " + cliente.getCategoria() + "\n" +
                "============================\n"
            );
            
            clienteDAO.insertCliente(cliente);
            
        }


    }
}
