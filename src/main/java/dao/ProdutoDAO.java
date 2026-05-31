package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Produto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    private List<Produto> objetos = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private final String ARQUIVO = "produto.json";

    /**
     * Adiciona a indentação correta para o arquivo JSON
     * Construtor da classe que configura o mapeador do Jackson.
     */
    public ProdutoDAO(){
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
                objetos = mapper.readValue(arquivo, new TypeReference<List<Produto>>(){});
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
    public void inserir (Produto obj){
        objetos.add(obj);
        salvar();
    }
    public List<Produto> listar(){
        return objetos;
    }
    public Produto listarId(int id){
        for (Produto x : objetos){
            if (x.getId() == id){
                return x;
            }
        }
        return null;
    }
    public void excluir(Produto obj){
        Produto produtoEncontrado = listarId(obj.getId());
        if (produtoEncontrado != null){
            objetos.remove(produtoEncontrado);
            salvar();
        }
    }
    public void atualizar(Produto obj){
        Produto produtoEncontrado = listarId(obj.getId());
        if (produtoEncontrado != null){
            produtoEncontrado.setDescricao(obj.getDescricao());
            produtoEncontrado.setId(obj.getId());
            produtoEncontrado.setPreco(obj.getPreco());
            produtoEncontrado.setEstoque(obj.getEstoque());
            produtoEncontrado.setIdCategoria(obj.getIdCategoria());
            salvar();
        }
    }

}
