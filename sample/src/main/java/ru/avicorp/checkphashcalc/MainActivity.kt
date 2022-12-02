package ru.avicorp.checkphashcalc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import ru.avicorp.phashcalc.pHashCalc

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Copy the files in root directory to the downloads folder on your device to check (String)
        val aPath: String =
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).path //get absolute path to folder download
        val sourceFileOne = "$aPath/sourceOne.jpg"
        val sourceFileTwo = "$aPath/sourceTwo.jpg"
        val sourceFileThree = "$aPath/sourceThree.jpg"


        val phashCalc = pHashCalc()//get to phashCalc library
        //Сalculate the percentages of identity of two JPEG(JPG) or BMP files (algorithm pHash)
        if (phashCalc.loadSourceFile(sourceFileOne, sourceFileTwo)) {
            println("pHash: ${phashCalc.calculateIdentical()}%")
        } else println("Files not found or check permission.")

        //Condition: files checked and uploaded
        if (phashCalc.checkCondition()) {
            //Greyscale hash files
            println("Greyscale hash files: ${phashCalc.getHashOne()} vs ${phashCalc.getHashTwo()}")
            //Average pixel greyscale files
            println("Average pixel greyscale files: ${phashCalc.getAveragePixelOne()} vs  ${phashCalc.getAveragePixelTwo()}")
        } else println("Please load files")

        // Checking the validity of the JPEG(JPG) by its structure (struct is displayed in the log)
        if (!phashCalc.validJPEGStruct(sourceFileThree)) println("This file is not JPEG(JPG)") else println(
            "JPEG(JPG) struct OK."
        )
    }
}