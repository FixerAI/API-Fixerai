package br.com.fiap.bo;

import br.com.fiap.beans.Cliente;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.exceptions.ClienteNaoEncontradoException;

public class ClienteBO {

    private ClienteDAO clienteDAO = new ClienteDAO();

    public Cliente getClienteByCPF(String cpf) throws ClienteNaoEncontradoException {
        Cliente cliente = clienteDAO.getClienteByCpf(cpf);
        if (cliente == null) {
            throw new ClienteNaoEncontradoException("Cliente com CPF " + cpf + " não encontrado.");
        }
        return cliente;
    }

    public void inserirCliente(Cliente cliente) {
        clienteDAO.insertCliente(cliente);
    }

    public void updateCliente(Cliente cliente) throws ClienteNaoEncontradoException {
        if (clienteDAO.getClienteByCpf(cliente.getCpf()) == null) {
            throw new ClienteNaoEncontradoException("Cliente com ID " + cliente.getCpf() + " não encontrado.");
        }
        clienteDAO.updateCliente(cliente);
    }

    public void deleteCliente(String cpf) throws ClienteNaoEncontradoException {
        if (clienteDAO.getClienteByCpf(cpf) == null) {
            throw new ClienteNaoEncontradoException("Cliente com CPF " + cpf + " não encontrado.");
        }
        clienteDAO.deleteCliente(cpf);
    }
}
