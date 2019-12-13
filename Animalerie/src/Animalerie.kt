import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption


fun main(args: Array<String>) {
    var chienNumber = 1
    var chatNumber = 1
    var perroquetNumber = 1
    val path = System.getProperty("user.dir") + "\\src\\AllAnimal.kt"

    println("Bienvenue dans l'animalerie.")
    println("Nous avons "+ chienNumber +" chiens, "+ chatNumber +"chats et "+ perroquetNumber +" perroquets.")
    print("Pour connaitre les informations d'un animal, taper son espèce (chien,chat,perroquet)")
    print("Pour ajouter un animal taper: add \"espèce\" \"cri\" ; exemple : add mouton beeeeee")
    print("Pour afficher toutes les espèces présentes, taper: afficher")

    var line : String
    do {
        println("")
        print("Entrée : ")
        line = readLine()!!
        if (line.contains("add ", true)) {
            line = line.replace("add ", "")
            var line2 = line.split(" ")
            var name = line2[0]
            var sound = line2[1]



            val text = ("\n \n" +
                    "class "+name+" : Animal{\n" +
                    " override var sound = \""+ sound +
                    "\"\n override var name = \""+name+
                    "\"\n }")
            try {
                Files.write(Paths.get(path), text.toByteArray(), StandardOpenOption.APPEND)
            } catch (e: IOException) {
            }

    }

        when (line) {
            "chien" -> print("Je suis un ${Chien().name} et je fais " + "${Chien().sound}" + " !")
            "chat" -> print("Je suis un ${Chat().name} et je fais " + "${Chat().sound}" + " !")
            "perroquet" -> print("Je suis un ${Perroquet().name} et je fais " + "${Perroquet().sound}" + " !")
        }
        if (line == "afficher"){
            print("Nous sommes des : ${Perroquet().name} ,${Chien().name} ,${Chat().name} ," +
                "et autres : ")
            try {
                for (x in 0 until 100 step 5) {
                    var classname = Files.readAllLines(Paths.get(path)).get(x)

                    if (classname.contains("class ", true)) {
                        classname = classname.replace("class ", "")
                        classname = classname.replace(" : Animal{", "")
                        print(classname+", ")
                    }

                }
                println("")
            }

            catch (e: IndexOutOfBoundsException){
                continue
            }


        }
        if (line !== "afficher" && line !== "chat" && line !== "chien" && line !== "perroquet"){
            try {
                for (x in 0 until 100 step 5) {
                    var classname = Files.readAllLines(Paths.get(path)).get(x)

                    var classsound = Files.readAllLines(Paths.get(path)).get(x+1)
                    classsound = classsound.replace("override var sound = \"", "")
                    classsound = classsound.replace("\"", "")
                    classsound = classsound.replace(" ", "")

                    if (classname.contains("class ", true)) {
                        classname = classname.replace("class ", "")
                        classname = classname.replace(" : Animal{", "")
                        if (line == classname){
                            print("Je suis un "+classname+" et je fais " +  classsound +" !")


                        }
                    }

                }
                println("")
            }

            catch (e: IndexOutOfBoundsException){
                continue
            }


        }

    } while (true)
}





