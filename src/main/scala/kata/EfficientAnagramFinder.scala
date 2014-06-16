package kata

import scala.io.Source
import scala.collection.immutable.Iterable

class EfficientAnagramFinder {

  val listOfWords = Source.fromURL(getClass.getResource("/wordlist_utf8.txt")).getLines().toList
  val mapOfWordsAndCharOccurrences = listOfWords.map(x => x -> getLetterOccurrances(x)).toMap
  val charOccurrencesToWordLists = mapOfWordsAndCharOccurrences.groupBy(_._2).map(x => x match {case (k,v) => (k -> v.map(minimap => minimap._1)) })

//  def findAnagramsFor(searchWord:String): List[String] = {
//    val myOccurrences = mapOfWordsAndCharOccurrences(searchWord)
//    val matches = mapOfWordsAndCharOccurrences.filterNot(mapElement => mapElement._1 == searchWord).filter(mapElement2 => mapElement2._2 == myOccurrences)
//    matches.map(m => m._1).toList
//  }

  def getLetterOccurrances(searchWord:String): Map[Char,Int] = {
    searchWord.replaceAll("'","").toLowerCase.toCharArray.foldLeft(Map[Char,Int]())((map,charElement) => map.get(charElement) match {
      case None => map + (charElement -> 1)
      case Some(count:Int) => map + (charElement -> (count+1))
    })
  }

  def getAnagrams(): Map[Map[Char, Int], Iterable[String]] = {
    charOccurrencesToWordLists.filter(x => {
      x._2.size > 1
    } )
  }

  def getAnagramsOf(searchWord:String): List[String] = {
    val searchWordCharsKey = getLetterOccurrances(searchWord);
    charOccurrencesToWordLists(searchWordCharsKey).toList
  }

}
