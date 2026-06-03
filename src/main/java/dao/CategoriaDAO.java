package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Categoria;
import model.Produto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    private List<Categoria> objetos = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private final String ARQUIVO = "categoria.json";

    /**
     * Adiciona a indentação correta para o arquivo JSON
     * Construtor da classe que configura o mapeador do Jackson.
     */
    public CategoriaDAO(){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
        abrir();
    }

    /**
     * readValue: Desserialização (JSON ⇾ Java).
     * Sobrecarga usada: lê dois paramêtros, origem dos dados e o formato do destino.
     * TypeReference: Obriga o Jackson a gravar e lembrar a tipagem exata
     * da lista. Evita que o JSON não seja convertido em objetos genéricos.
     */
    public void abrir(){
        try{
            File arquivo = new File(ARQUIVO);
            if (arquivo.exists()){
                objetos = mapper.readValue(arquivo, new TypeReference<List<Categoria>>(){});
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
    public void inserir(Categoria obj){
        int novoId = 1;

        if (!objetos.isEmpty()){
            int maiorId = 0;

            for (Categoria c : objetos){
                if (c.getId() > maiorId){
                    maiorId = c.getId();
                }
            }
            novoId = maiorId + 1;
        }
        obj.setId(novoId);
        objetos.add(obj);
        salvar();
    }
    public List<Categoria> listar(){
        return objetos;
    }
    public Categoria listarId(int id){
        for (Categoria x : objetos){
            if (x.getId() == id){
                return x;
            }
        }
        return null;
    }
    public void excluir(Categoria obj){
        Categoria categoriaEncontrada = listarId(obj.getId());
        if (categoriaEncontrada != null){
            objetos.remove(categoriaEncontrada);
            salvar();
        }
    }
    public void atualizar (Categoria obj){
        Categoria categoriaEncontrada = listarId(obj.getId());
        if (categoriaEncontrada != null){
            categoriaEncontrada.setDescricao(obj.getDescricao());
            salvar();
        }
    }
}
