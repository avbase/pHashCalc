# Android library pHashCalc:
Images (JPEG, BMP) comparison (perceptual hash algorithm).

[![platform](https://img.shields.io/badge/platform-Android-yellow.svg)](https://www.android.com)
[![Kotlin version](https://img.shields.io/badge/Kotlin-1.7.20-blue)]([https://kotlinlang.org/docs/whatsnew16.html](https://kotlinlang.org/docs/whatsnew1720.html))
[![mavenCentral](https://img.shields.io/badge/Download-v1.0.0-red)](https://search.maven.org/search?q=ru.avicorp.phashcalc)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://www.apache.org/licenses/LICENSE-2.0)


<img align="center" src="https://github.com/avbase/pHashCalc/blob/main/phashResult.gif" height="180" style="max-width: 50%; display: inline-block;" data-target="animated-image.originalImage">



###  Capabilities pHashCalc: 

Сalculates the percentages of identity of two JPEG(JPG) or BMP files (algorithm pHash).
Also checks the structure of a JPEG (JPG) file against the main signatures.

    - StartOfImage
    - ApplicationDefaultHeader
    - QuantizationTable
    - StartOfFrame
    - DefaultHuffmanTable
    - StartOfScan
    - EndOfImage

## How to use

The project's Maven access is hosted on OSS Sonatype (and available from Maven Central).
Android : pHashCalc supports Android starting on API 26 and up.

#### Using with Gradle

Add the dependencies into the project's build.gradle:
```groovy
repositories {
  mavenCentral()
}

dependencies {
   implementation("implementation "ru.avicorp:phashcalc:1.0.0")
}
```

#### Example

```groovy
val phash = pHashCalc()

//Сalculate the percentages of identity of two JPEG(JPG) or BMP files (algorithm pHash)
if (phash.loadSourceFile(namefileTwo, namefileOne)) {
            println("pHash: ${phash.calculateIdentical()}%")
} else println("Files not found or check permission.")

// Condition: files are uploaded
        if (phash.checkCondition()) {
            //Greyscale hash files
            println("Greyscale hash files: ${phash.getHashOne()} vs ${phash.getHashTwo()}")
            
            //Average pixel greyscale files
            println("Average pixel greyscale files: ${phash.getAveragePixelOne()} vs  ${phash.getAveragePixelTwo()}")
            
        } else println("Please load files")

// Checking the validity of the JPEG(JPG) by its structure (struct is displayed in the log)
        if (!phash.validJPEGStruct(namefileThree)) println("This file is not JPEG(JPG)")

```
### Usage description

The library implements the pHash algorithm that uses perceptual hashes to compare images, (detailed documentation and description of algorithms using perceptual hashes can be found at [pHash](https://pHash.org)), my implementation of this algorithm was used to build a video surveillance system for a private house [smartHomeVideoControl](https://avicorp.ru)

### License

 Copyright (C) 2017 The Λrrow Authors

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
