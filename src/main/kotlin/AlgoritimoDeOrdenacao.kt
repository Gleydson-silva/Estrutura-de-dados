

fun main() {
    var lista: MutableList<Int> = mutableListOf(5,9,7,5,8,3,1,4,10,85)
    var novaLista: MutableList<Int> = mutableListOf()
    val tamanho = lista.size - 1


    for(i in 0..tamanho)
    {
        novaLista.add(lista[ordenacao(lista)])
        lista.removeAt(ordenacao(lista))

    }

    println(novaLista)

    println(buscaBinariaOrdenado(novaLista, 0))
}

fun ordenacao(list: MutableList<Int>):Int
{
    var menorValor = list[0]
    var menorIndice = 0

    for(i in 0..list.size-1)
    {
        if(list[i] < menorValor)
        {
            menorValor = list[i]
            menorIndice = i
        }
    }

    return menorIndice
}


fun buscaBinariaOrdenado(lista: List<Int>, item:Int): Int {

    var baixo = 0
    var meio = 0
    var chute = 0
    var alto = lista.size - 1

    while(baixo <= alto)
    {
        meio = (baixo + alto) / 2
        chute = lista[meio]
        if (chute == item){
            return meio
        }
        else if (chute > item){
            alto = meio - 1
        }
        else{
            baixo = meio + 1
        }
    }

    return -1
}