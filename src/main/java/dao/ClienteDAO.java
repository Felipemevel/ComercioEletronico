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

    /**
     * Adiciona a indentação correta para o arquivo JSON
     * Construtor da classe que configura o mapeador do Jackson.
     */
    public ClienteDAO(){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    public void abrir(){
        try {
            File arquivo = new File(ARQUIVO);
            if (arquivo.exists()){
                /**
                 * readValue: Desserialização (JSON ⇾ Java).
                 * Sobrecarga usada: lê dois paramêtros, origem dos dados e o formato do destino.
                 */
               objetos = mapper.readValue(arquivo, new TypeReference<List<Cliente>>(){});
                /**
                 * TypeReference: Obriga o Jackson a gravar e lembrar a tipagem exata
                 * da lista. Evita que o JSON não seja convertido em objetos genéricos.
                 */
            }
        } catch (Exception e) { objetos = new ArrayList<>();}
    }

    public void salvar(){
        try {
            /**
             * writeValue: Serialização (Java → JSON).
             * Transforma o objeto da lista em um JSON.
             */
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
