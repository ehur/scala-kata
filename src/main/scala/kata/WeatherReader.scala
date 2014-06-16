package kata

import scala.io.Source

class WeatherReader(pathToFile: String) {

  var theData = null


  def readData() : List[String] = {
    val strippedFile = Source.fromURL(getClass.getResource("/"+pathToFile)).getLines().toList.tail.tail //remove first 2 records
    strippedFile.reverse.tail //returns just the data, but in reverse order, which probably doesn't matter
  }

  def readDailyVariations() : List[DailyVariation] = {
    readData().map {
       line: String =>
         val lineArray = line.trim().replace("*","").split(" +")
         new DailyVariation(lineArray(0)toInt, lineArray(1).toInt - lineArray(2).toInt)
     }

  }

  def getMaxVariation() : DailyVariation = {
    readDailyVariations().reduceLeft {(a:DailyVariation,b:DailyVariation) => if (a.variation > b.variation)  a else b}
  }
  def getMinVariation() : DailyVariation = {
    readDailyVariations().reduceLeft {(a:DailyVariation,b:DailyVariation) => if (a.variation < b.variation)  a else b}
  }

}


case class DailyVariation(dayNum:Int, variation:Int)
