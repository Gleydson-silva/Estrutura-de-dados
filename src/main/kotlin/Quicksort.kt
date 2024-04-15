fun main() {
    var lista1: MutableList<Int> = mutableListOf(5, 3, 8, 4, 2, 7, 1)
    println("Array antes da ordenação:")
    println(lista1)


    println("Array após a ordenação:")
    println(quickSort(lista1))

    println()
    println()

    val arr = intArrayOf(5, 3, 8, 4, 2, 7, 1)
    println("Array antes da ordenação:")
    println(arr.contentToString())

    quickSort(arr, 0, arr.size - 1)

    println("Array após a ordenação:")
    println(arr.contentToString())
}

fun quickSort(lista: MutableList<Int>):List<Int> {
    var pivo:Int
    var maiores: MutableList<Int> = mutableListOf()
    var menores: MutableList<Int> = mutableListOf()
    if(lista.size < 2)
    {
        return lista
    }
    else
    {
        pivo = lista[0]
        lista.removeAt(0)
        for(i in lista) if(i > pivo) maiores.add(i)
        for(i in lista) if(i <= pivo) menores.add(i)

        return quickSort(menores) + pivo + quickSort(maiores)
    }

}


fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pivotIndex = partition(arr, low, high)
        quickSort(arr, low, pivotIndex - 1)
        quickSort(arr, pivotIndex + 1, high)
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[high]
    var i = low - 1

    for (j in low until high) {
        if (arr[j] <= pivot) {
            i++
            swap(arr, i, j)
        }
    }

    swap(arr, i + 1, high)
    return i + 1
}

fun swap(arr: IntArray, i: Int, j: Int) {
    val temp = arr[i]
    arr[i] = arr[j]
    arr[j] = temp
}

