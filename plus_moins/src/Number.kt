fun main(args: Array<String>) {

    print("Entre ton nombre:")
    val ask = readLine()!!
    val number1 = ask.toInt();
    var line : String
    fun sum(a: Int, b: Int) = a + b
    fun sub(a: Int, b: Int) = a - b
    val sum1 = sum(number1,12)
    val sub1 = sub(number1,12)

    println("Tape '-1' pour quitter !")
    print("Première tentative :")
    var var1 = 1
    do {
        line = readLine()!!
        var lineOk = line.toInt()

        if (lineOk == -1) {
            println("Closing Program")
            break
        }
        if (lineOk > number1) {
            print("Ton nombre est trop grand")
            if (lineOk < sum1) {
                println(", mais tu chauffes")
            }
            else {
                println(", et tu en es loin ! :/")
            }
        }
        if (lineOk < number1) {
            print("Ton nombre est trop petit")
            if  (lineOk > sub1) {
                println(", mais tu chauffes")
            }
            else {
                println(", et tu en es loin ! :/")
            }
        }
        if (lineOk == number1) {
            println("Bravo, tu as trouvé")
            break
        }
        var1 ++
        print("Tentative n°"+var1+" :")


    } while (true)

}
