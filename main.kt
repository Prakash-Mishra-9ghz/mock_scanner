import java.io.File
import java.awt.Desktop


fun scanfile(filePath: String): String {
    val file = File(filePath)
    val license = mutableListOf<String>()
    val licenseCount = mutableMapOf<String, Int>()

    file.readLines().forEachIndexed { index, line ->
        when {
            line.contains("MIT License", ignoreCase = true) -> {
                license.add(
                    "Line ${index + 1}: MIT License found.\n" +
                            "Terms: Must include a copy of the MIT License and copyright notice."
                )
                licenseCount["MIT License"] = licenseCount.getOrDefault("MIT License", 0) + 1
            }

            line.contains("Apache License 2.0", ignoreCase = true) -> {
                license.add(
                    "Line ${index + 1}: Apache License 2.0 found.\n" +
                            "Terms: redistribution must provide a copy of this license and state modifications."
                )
                licenseCount["Apache License 2.0"] = licenseCount.getOrDefault("Apache License 2.0", 0) + 1
            }
            //Might add more
        }
    }

    license.add("\nSummary:")
    licenseCount.forEach { (lice, count) ->
        license.add("$lice - $count match(es)")
    }
    val output = license.joinToString("\n")

    return if (license.isEmpty()) {
        "No license founded."
    }
    else {
        output
    }
}

fun writeToFile(result: String, outputFilePath: String){
    val outputFile = File(outputFilePath)
    outputFile.writeText(result)
}

fun openFile(filePath: String){
    val file = File(filePath)
    if(file.exists()) {
        Desktop.getDesktop().open(file)
    }
    else {
        println("The file does not exist.")
    }
}

fun main() {
    println("Mock Scanner Started...")
    val inputFilePath = "sample.txt"
    val outputFilePath = "output.txt"

    val result = scanfile(inputFilePath)

    writeToFile(result, outputFilePath)

    openFile(outputFilePath)
}

