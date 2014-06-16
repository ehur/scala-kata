package kata

import scala.io.Source

class AnagramFinder {

  val listOfWords = Source.fromURL(getClass.getResource("/wordlist_utf8.txt")).getLines().toList

  def findAnagramsFor(searchWord:String) : List[String] = {
      listOfWords.filter(compareWord => (compareWord.toLowerCase.toSet == searchWord.toLowerCase.toSet
                                          && compareWord.length == searchWord.length
                                          && compareWord != searchWord))
  }


  def findAnagramsFor(searchWord:String, inList:List[String]) : List[String] = {
    val filtered = inList.filter(compareWord => (compareWord.toLowerCase.toSet == searchWord.toLowerCase.toSet
      && compareWord.length == searchWord.length
      && compareWord != searchWord))
    println(searchWord +": "+filtered)
    filtered
  }

  def findAllSetsOfAnagramsTuples(firstWord:String, theRest:List[String]) : List[(String,List[String])] = {
    if (theRest.tail.isEmpty) {
      List((firstWord,Nil))
    } else {
      val anagrams = findAnagramsFor(firstWord,theRest)
      val filteredRest = theRest filterNot (anagrams contains)
      (firstWord, anagrams) :: findAllSetsOfAnagramsTuples(filteredRest.head,filteredRest.tail)
    }
  }

  def findAnagramsTuples() : List[(String, List[String])] = {
    val firstWord = listOfWords.head
    findAllSetsOfAnagramsTuples(firstWord, listOfWords.tail)
  }
}
