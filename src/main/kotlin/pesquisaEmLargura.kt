import java.util.LinkedList

fun main() {
    var grafo: Map<String, Array<String>> = montaGrafo()

    pesquisa("você", grafo)

}

fun montaGrafo(): Map<String, Array<String>>
{
    var grafo: MutableMap<String,Array<String>> = mutableMapOf()

    grafo["você"] = arrayOf("alice","bob","claire")
    grafo["bob"] = arrayOf("anuj", "peggy")
    grafo["alice"] = arrayOf("peggy")
    grafo["claire"] = arrayOf("thom","jonny")
    grafo["anuj"] = arrayOf()
    grafo["peggy"] = arrayOf()
    grafo["thom"] = arrayOf()
    grafo["jonny"] = arrayOf()



    //println(grafo["você"]?.joinToString())

    return grafo
}

fun pesquisa(nome: String, grafo: Map<String, Array<String>>): Boolean
{
    var fila: LinkedList<String> = LinkedList()
    var verificadas: MutableList<String> = mutableListOf()
    var pessoa:String

    for (i in grafo[nome]!!) {

        fila.offer(i)
    }


    while (fila.isNotEmpty())
    {
        pessoa = fila.poll()
        if(pessoa !in verificadas)
        {
            if (pessoa(pessoa))
            {
                println("$pessoa é um vendedor de manga")
                return true
            }
            else
            {
                for (i in grafo[pessoa]!!) {
                    fila.offer(i)
                }
                verificadas.add(pessoa)
            }
        }

    }
    return false

}

fun pessoa(nome:String) = nome == "jonny"



