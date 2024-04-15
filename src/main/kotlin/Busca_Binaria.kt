fun main() {
    var lista = arrayOf(1,3,4,8,9);

    var posicao = buscaBinaria(lista, 8)

    println("Posição: " + posicao)
}

fun buscaBinaria(lista: Array<Int>, item:Int): Int {

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