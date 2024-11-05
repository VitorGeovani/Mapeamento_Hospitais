import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Grafo {
    private Map<String, Vertice> vertices; // Mapa de nomes de vértices para objetos Vertice

    // Construtor: inicializa o mapa de vértices
    public Grafo() {
        this.vertices = new HashMap<>();
    }

    // Método para adicionar um novo vértice ao grafo
    public void adicionarVertice(String nome) {
        // Verifica se o vértice já existe para evitar duplicatas
        if (!vertices.containsKey(nome)) {
            Vertice vertice = new Vertice(nome); // Cria um novo vértice
            vertices.put(nome, vertice); // Adiciona o vértice ao mapa
        }
    }

    // Método para adicionar uma aresta entre dois vértices com um peso associado
    public void adicionarAresta(String origem, String destino, int peso) {
        // Obtém os vértices de origem e destino a partir do mapa
        Vertice verticeOrigem = vertices.get(origem);
        Vertice verticeDestino = vertices.get(destino);

        // Verifica se ambos os vértices existem
        if (verticeOrigem != null && verticeDestino != null) {
            verticeOrigem.adicionarAresta(verticeDestino, peso); // Adiciona a aresta ao vértice de origem
        }
    }

    // Método para obter um vértice pelo nome
    public Vertice obterVertice(String nome) {
        return vertices.get(nome); // Retorna o vértice correspondente ao nome
    }

    // Método de Busca em Largura (BFS) a partir de um vértice específico
    public void buscaEmLargura(String nomeInicio) {
        // Obtém o vértice de início para a busca
        Vertice verticeInicio = obterVertice(nomeInicio);
        if (verticeInicio == null) {
            System.out.println("Vértice não encontrado!");
            return; // Se o vértice não existir, encerra o método
        }

        // Usado para controlar os vértices visitados
        Map<Vertice, Boolean> visitados = new HashMap<>();
        Queue<Vertice> fila = new LinkedList<>(); // Fila para controlar a ordem de visita dos vértices

        // Marcar o vértice inicial como visitado e adicioná-lo à fila
        visitados.put(verticeInicio, true);
        fila.add(verticeInicio);

        System.out.println("Busca em Largura a partir do vértice: " + nomeInicio);

        // Loop principal da busca em largura
        while (!fila.isEmpty()) {
            Vertice atual = fila.poll(); // Remove o primeiro vértice da fila
            System.out.println(atual.getNome()); // Processa (exibe) o vértice atual

            // Explora todos os vizinhos do vértice atual
            for (Map.Entry<Vertice, Integer> entry : atual.getArestas().entrySet()) {
                Vertice vizinho = entry.getKey(); // Obtém o vértice vizinho a partir da aresta
                if (!visitados.containsKey(vizinho)) { // Verifica se o vizinho ainda não foi visitado
                    visitados.put(vizinho, true); // Marca o vizinho como visitado
                    fila.add(vizinho); // Adiciona o vizinho à fila para futuras explorações
                }
            }
        }
    }
}
