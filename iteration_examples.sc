val animals = List("lizard","cat","pig","chicken")
animals.foreach(println)




animals.foreach(animal => println("feed the " + animal))




for (animal <- animals) println(animal.length)




for (animal <- animals) yield animal.length
val lengthsMapped = animals.map(a => a.length)
val nums=List(1,2,3)
nums.map(x=>x+1).map(x=>x*x)

val tokens = List("the","program","halted")
val tags = List("DT","NN","VB")
val tokenTagPairs = tokens.zip(tags)

val mashed = for ((token,tag) <- tokenTagPairs) yield token + "/" + tag
mashed.mkString("#")

(for ((token,tag) <- tokens.zip(tags)) yield token + "/" + tag).mkString("#")

