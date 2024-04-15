/*
Escreva um programa para calcular a soma dos números pares em um intervalo dado.
Crie um programa que inverta uma string.
Faça um programa que verifique se um número é primo.

 */

fun main() {
    //println(somaIntervalo(3,5))
    //println(inverteString("Testando a inversão de string"))
    println("O Número é primo: ${confereValorPrimo(7)}");
}

fun somaIntervalo(vlrIni: Int, vlrFim: Int): Int{

    var soma = 0
    for(i in vlrIni..vlrFim)
    {
        soma += i
    }

    return soma
}


fun inverteString(str: String): String
{
    var tamanho = str.length - 1
    var novaString = ""
    for (i in tamanho downTo 0)
    {
        novaString += str[i]
    }
    return novaString
}

fun confereValorPrimo(numero: Int):Boolean
{
    var retorno = true

    val numero1 = numero - 1


    for(i in 2..numero1)
    {
        if(numero%i == 0)
        {
            retorno = false
        }
    }

    return retorno
}