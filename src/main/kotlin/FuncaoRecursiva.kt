fun main() {
    //println(fatorial(5))
    var lista: MutableList<Int> = mutableListOf(2,6,4,5)
    //println(soma(lista))

    println(contar(lista))


}

fun fatorial(x:Int):Int
{
    if (x == 1)
    {
        return 1
    }
    else
    {
        return x * fatorial(x - 1)
    }

}


fun soma(x: MutableList<Int>):Int
{
    var valor = 0
    if(x.isEmpty())
    {
        return 0
    }
    else
    {
        valor = x[0]
        x.removeAt(0)
        return valor + soma(x)
    }

}

fun contar(x: MutableList<Int>):Int
{
    if(x.isEmpty())
    {
       return 0
    }
    else {
        x.removeAt(0)
        return 1 + contar(x)
    }
}

