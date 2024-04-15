fun media(vararg notas:Float):Float{
    var soma = 0f

    for(i in notas){
        soma += i
    }

    return(soma / notas.size)
}




// Generic
fun <T> genericoMedia(vararg parametro: T): Float{

    var soma = 0f

    for(i in parametro){
        if(i is Float){
            soma += i
        }
    }

    return soma / parametro.size
}