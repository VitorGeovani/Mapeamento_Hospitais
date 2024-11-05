import java.util.HashMap;
import java.util.Map;

public class Vertice {
    private String nome;
    private Map<Vertice, Integer> arestas; // Mapa de vértices adjacentes e suas distâncias

    public Vertice(String nome) {
        this.nome = nome;
        this.arestas = new HashMap<>();
    }

    public String getNome() {
        return nome;
    }

    public Map<Vertice, Integer> getArestas() {
        return arestas;
    }

    public void adicionarAresta(Vertice vertice, int peso) {
        arestas.put(vertice, peso); // Adiciona uma aresta ao mapa
    }
}
