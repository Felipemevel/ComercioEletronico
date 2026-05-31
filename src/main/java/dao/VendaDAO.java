package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import model.Venda;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO {

    private List<Venda> objetos = new ArrayList<>();
    private ObjectMapper mapper = new ObjectMapper();
    private final String ARQUIVO = "venda.json";

    /**
     * Adiciona a indentação correta para o arquivo JSON
     * Construtor da classe que configura o mapeador do Jackson.
     */
    public VendaDAO(){
        mapper.enable(SerializationFeature.INDENT_OUTPUT);
    }

    /**
     * writeValue: Serialização (Java → JSON).
     * Transforma o objeto da lista em um JSON.
     * TypeReference: Obriga o Jackson a gravar e lembrar a tipagem exata
     * da lista. Evita que o JSON não seja convertido em objetos genéricos.
     */
    public void abrir(){
        try{
            File arquivo = new File(ARQUIVO);
            if (arquivo.exists()){
                objetos = mapper.readValue(arquivo, new TypeReference<List<Venda>>(){});
            }
        } catch (Exception e) {objetos = new ArrayList<>();}
    }
    /**
     * writeValue: Serialização (Java → JSON).
     * Transforma o objeto da lista em um JSON.
     */
    public void salvar(){
        try{
            File arquivo = new File(ARQUIVO);
            mapper.writeValue(arquivo, objetos);
        } catch (Exception e){
            System.out.println("Não foi possível salvar: " + e.getMessage());
        }
    }
    public void inserir(Venda obj){
        objetos.add(obj);
        salvar();
    }
    public List<Venda> listar(){
        return objetos;
    }
    public Venda listarId(int id){
        for (Venda x : objetos){
            if (x.getId() == id){
                return x;
            }
        }
        return null;
    }
    public void excluir(Venda obj){
        Venda vendaEncontrada = listarId(obj.getId());
        if (vendaEncontrada != null){
            objetos.remove(vendaEncontrada);
            salvar();
        }
    }
    public void atualizar(Venda obj){
        Venda vendaEncontrada = listarId(obj.getId());
        if (vendaEncontrada != null){
            vendaEncontrada.setDate(obj.getDate());
            vendaEncontrada.setTotal(obj.getTotal());
            vendaEncontrada.setCarrinho(obj.getCarrinho());
            vendaEncontrada.setIdCLiente(obj.getIdCLiente());
            salvar();
        }
    }
}
