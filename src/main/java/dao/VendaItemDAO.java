package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.VendaItem;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VendaItemDAO {

    private List<VendaItem> objetos = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private final String ARQUIVO = "vendaitem.json";

    /**
     * Adiciona a indentação correta para o arquivo JSON
     * Construtor da classe que configura o mapeador do Jackson.
     */
    public VendaItemDAO(){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * readValue: Desserialização (JSON ⇾ Java).
     * Sobrecarga usada: lê dois paramêtros, origem dos dados e o formato do destino.
     * TypeReference: Obriga o Jackson a gravar e lembrar a tipagem exata
     * da lista. Evita que o JSON não seja convertido em objetos genéricos.
     */
    public void abrir(){
        try {
            File arquivo = new File(ARQUIVO);
            if (arquivo.exists()){
                objetos = mapper.readValue(arquivo, new TypeReference<List<VendaItem>>(){});
            }
        } catch (Exception e) {objetos = new ArrayList<>();}
    }

    /**
     * writeValue: Serialização (Java → JSON).
     * Transforma o objeto da lista em um JSON.
     */
    public void salvar(){
        try {
            File arquivo = new File(ARQUIVO);
            mapper.writeValue(arquivo, objetos);
        } catch (Exception e) {
            System.out.println("Não foi possível salvar: " + e.getMessage());
        }
    }
    public void inserir(VendaItem obj){
        objetos.add(obj);
        salvar();
    }
    public List<VendaItem> listar(){
        return objetos;
    }
    public VendaItem listarId(int id){
        for (VendaItem x : objetos){
            if (x.getId() == id){
                return x;
            }
        }
        return null;
    }
    public void excluir(VendaItem obj){
        VendaItem vendaItemEncontrado = listarId(obj.getId());
        if (vendaItemEncontrado != null){
            objetos.remove(vendaItemEncontrado);
            salvar();
        }
    }
    public void atualizar(VendaItem obj){
        VendaItem vendaItemEncontrado = listarId(obj.getId());
        if (vendaItemEncontrado != null){
            vendaItemEncontrado.setIdProduto(obj.getIdProduto());
            vendaItemEncontrado.setPreco(obj.getPreco());
            vendaItemEncontrado.setQuantidade(obj.getQuantidade());
            vendaItemEncontrado.setIdVenda(obj.getIdVenda());
            salvar();
        }
    }
}
