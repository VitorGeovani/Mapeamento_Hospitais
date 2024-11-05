import java.util.Map;

import javax.swing.JOptionPane;

public class App {
    public static void main(String[] args) {
        // Criando o grafo de regiões e hospitais
        Grafo grafo = new Grafo();

        // Adiciona vértices para regiões
        grafo.adicionarVertice("Sul");
        grafo.adicionarVertice("Sudeste");
        grafo.adicionarVertice("Nordeste");

        // Adiciona vértices para hospitais
        grafo.adicionarVertice("Hospital Santa Catarina");
        grafo.adicionarVertice("Hospital Regional");
        grafo.adicionarVertice("Hospital São Lucas");
        grafo.adicionarVertice("Hospital das Clínicas");
        grafo.adicionarVertice("Hospital Albert Einstein");
        grafo.adicionarVertice("Hospital Sírio-Libanês");
        grafo.adicionarVertice("Hospital Português");
        grafo.adicionarVertice("Hospital da Bahia");
        grafo.adicionarVertice("Hospital São Rafael");

        // Adiciona arestas com pesos entre regiões e hospitais
        grafo.adicionarAresta("Sul", "Hospital Santa Catarina", 5);
        grafo.adicionarAresta("Sul", "Hospital Regional", 10);
        grafo.adicionarAresta("Sul", "Hospital São Lucas", 15);

        grafo.adicionarAresta("Sudeste", "Hospital das Clínicas", 8);
        grafo.adicionarAresta("Sudeste", "Hospital Albert Einstein", 12);
        grafo.adicionarAresta("Sudeste", "Hospital Sírio-Libanês", 20);

        grafo.adicionarAresta("Nordeste", "Hospital Português", 6);
        grafo.adicionarAresta("Nordeste", "Hospital da Bahia", 13);
        grafo.adicionarAresta("Nordeste", "Hospital São Rafael", 25);

        // opções de regiões
        String[] regioes = { "Sul", "Sudeste", "Nordeste" };

        // interface de opções
        String regiao = (String) JOptionPane.showInputDialog(null, "Selecione a Região:", "Regiões",
                JOptionPane.QUESTION_MESSAGE, null, regioes, regioes[0]);

        if (regiao != null) {
            Vertice verticeRegiao = grafo.obterVertice(regiao);

            if (verticeRegiao != null) {
                StringBuilder resultado = new StringBuilder("Hospitais na região " + regiao + ":\n");
                Map<Vertice, Integer> arestas = verticeRegiao.getArestas(); // Obtém as arestas do vértice da região

                // Itera sobre as arestas para construir a lista de hospitais
                for (Map.Entry<Vertice, Integer> entry : arestas.entrySet()) {
                    Vertice hospital = entry.getKey(); // Obtém o hospital (chave do HashMap)
                    int peso = entry.getValue(); // Obtém a distância (valor do HashMap)
                    resultado.append("- ")
                            .append(hospital.getNome())
                            .append(" (Distância: ")
                            .append(peso)
                            .append(" km)\n");
                }

                // Exibe os hospitais
                JOptionPane.showMessageDialog(null, resultado.toString());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma região selecionada!");
        }
    }
}
