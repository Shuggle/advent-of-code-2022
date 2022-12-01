package utils

import java.io.File

fun readInput(fileName: String): List<String> = File(fileName).useLines { it.toList() }
