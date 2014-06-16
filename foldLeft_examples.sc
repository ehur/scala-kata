val searchWord="thisisawordortwo"
val letterOccurrances = searchWord.toCharArray.foldLeft(Map[Char,Int]())((map,charElement) => map.get(charElement) match {
  case None => map + (charElement -> 1)
  case Some(count:Int) => map + (charElement -> (count+1))
})

val listOfWords=List("aaa","the","cat","act","refresh","fresher")
val mapOfWordsAndCharOccurrences = listOfWords.map(x => (collection.immutable.HashMap(x -> x.toCharArray.foldLeft(Map[Char,Int]())((map,charElement) => map.get(charElement) match {
  case None => map + (charElement -> 1)
  case Some(count:Int) => map + (charElement -> (count+1))
}))))

val oneMap=Map("one" -> Map("a" -> 1, "b" -> 1, "c" -> 2),"two" -> Map("a" -> 1, "b" -> 1, "c" -> 2),"three" -> Map("a" -> 2, "b" -> 1, "c" -> 2))
//oneMap.map(x => x match {case (k,v) => })
oneMap.groupBy(_._2)
oneMap.groupBy(_._2).map(x => x match {case (k,v) => (k -> v.map(minimap => minimap._1)) })
//oneMap.groupBy(_._2).map()
oneMap.toList.groupBy(_._2)