package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Cliente;

public class ClienteDAO {

    private ObjectMapper mapper = new ObjectMapper();
    private List<Cliente> objetos = new ArrayList<>();
    private final String ARQUIVO = "clientes.json";

    public ClienteDAO(){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void abrir(){
        try {
            File arquivo = new File(ARQUIVO);
            if (arquivo.exists()){
               objetos = mapper.readValue(arquivo, new TypeReference<List<Cliente>>(){});
            }
        } catch (Exception e) { objetos = new ArrayList<>();}
    }

    public void salvar(){
        try {
            File arquivo = new File(ARQUIVO);
            mapper.writeValue(arquivo, objetos);
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public void inserir(Cliente obj){
        objetos.add(obj);
        salvar();
    }
    public List<Cliente> listar(){
        return objetos;
    }
    public Cliente listarId(int id){
        for (Cliente x : objetos){
            if (x.getId() == id){
                return x;
            }
        }
        return null;
    }
    public void excluir(Cliente obj){
        Cliente clienteEncontrado = listarId(obj.getId());
        if (clienteEncontrado != null){
            objetos.remove(clienteEncontrado);
            salvar();
        }
    }
    public void atualizar(Cliente obj){
        Cliente clienteEncontrado = listarId(obj.getId());
        if (clienteEncontrado != null){
            clienteEncontrado.setNome(obj.getNome());
            clienteEncontrado.setFone(obj.getFone());
            clienteEncontrado.setEmail(obj.getEmail());
            salvar();
        }
    }

}
