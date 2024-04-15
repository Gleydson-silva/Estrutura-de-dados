import java.util.*

class Grafo {
    private val grafos = mutableMapOf<String, MutableMap<String, Int>>()

    fun adicionarVertice(vertice: String) {
        grafos[vertice] = mutableMapOf()
    }

    fun adicionarAresta(inicio: String, fim: String, peso: Int) {
        grafos[inicio]?.put(fim, peso)
    }

    fun dijkstra(inicio: String, fim: String): List<String> {
        val custos = mutableMapOf<String, Int>()
        val pais = mutableMapOf<String, String>()
        val processados = mutableSetOf<String>()
        val fila = PriorityQueue<Pair<Int, String>>(compareBy { it.first })

        grafos.keys.forEach { vertice ->
            custos[vertice] = Int.MAX_VALUE
            pais[vertice] = ""
        }

        custos[inicio] = 0
        fila.offer(0 to inicio)

        while (fila.isNotEmpty()) {
            val (custoAtual, verticeAtual) = fila.poll()
            if (verticeAtual == fim) {
                val caminho = mutableListOf<String>()
                var vertice = fim
                while (vertice != inicio) {
                    caminho.add(vertice)
                    vertice = pais[vertice]!!
                }
                caminho.add(inicio)
                caminho.add(custoAtual.toString())
                caminho.reverse()
                return caminho
            }

            if (processados.contains(verticeAtual)) {
                continue
            }
            processados.add(verticeAtual)

            grafos[verticeAtual]?.forEach { (vizinho, peso) ->
                val novoCusto = custoAtual + peso
                if (novoCusto < custos[vizinho]!!) {
                    custos[vizinho] = novoCusto
                    pais[vizinho] = verticeAtual
                    fila.offer(novoCusto to vizinho)
                }
            }
        }
        return emptyList()
    }
}

fun main() {
    val grafo = Grafo()
    grafo.adicionarVertice("a")
    grafo.adicionarVertice("b")
    grafo.adicionarVertice("c")
    grafo.adicionarVertice("d")
    grafo.adicionarVertice("f")

    grafo.adicionarAresta("a", "b", 5)
    grafo.adicionarAresta("a", "c", 2)
    grafo.adicionarAresta("b", "d", 4)
    grafo.adicionarAresta("c", "b", 8)
    grafo.adicionarAresta("c", "d", 7)
    grafo.adicionarAresta("d", "f", 6)

    val caminho = grafo.dijkstra("a", "f")
    println("Menor caminho de 'a' para 'f': ${caminho.joinToString(" -> ")}")
}
