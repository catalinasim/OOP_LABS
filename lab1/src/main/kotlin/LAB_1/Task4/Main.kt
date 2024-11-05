package LAB_1.Task4

import LAB_1.Task2.FileReader
import LAB_1.Task2.InfoDisplay
import LAB_1.Task2.TextData

fun main(args: Array<String>) {
    // Instantiate a FileReader object
    val reader = FileReader()
    // Check if the command line arguments satisfy the lab condition
    if (args.size >= 2 && args.size % 2 == 0) {
        // Instantiate an InfoDisplay object to print information
        val printer = InfoDisplay()
        for (i in args.indices step 2) {
            // Name of the file sent as a command line argument
            val name = args[i]
            // Filepath sent as a command line argument
            val path = args[i + 1]
            // Create a TextData object using the default constructor
            val text = TextData(fileName = name, text = reader.readFileIntoString(path))
            // Call the methods of the TextData using the printer object
            printer.displayInformation(text)
        }
    } else {
        // if the command line arguments don't satisfy the lab condition, throw an error
        error("Command-line arguments need to have the structure: nameOfTheFile pathToTheFile.")
        // example of cmd line arguments:
        // oop_lab.txt src/main/resources/Lab1/oop_lab.txt input.txt src/main/resources/Lab1/input.txt lab_opinion.txt src/main/resources/Lab1/lab_opinion.txt
    }
}
