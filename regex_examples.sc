val Name = """(Mr|Mrs|Ms)\. ([A-Z][a-z]+) ([A-Z][a-z]+)""".r
val smothers = "Mr. Jake Smothers"
val Name(title,firstName,lastName) = smothers


val found=Name.findAllIn(smothers)
found.foreach(println)

val sentence = "Mr. John Smith said hello to Ms. Jane Hill and then to Mr. Bill Brown"
val folks = Name.findAllIn(sentence).toList
val folksList = Name.findAllIn(sentence).matchData.toList

val firstMatch=folksList(1)
firstMatch.group(0)
firstMatch.group(1)
firstMatch.group(2)
firstMatch.group(3)
val (jantitle,janefirst,janelast) = (firstMatch.group(1),firstMatch.group(2),firstMatch.group(3))


val Seq(titlej,firstnamej,lastnamej) = 1 to 3 map firstMatch.group


Name.findAllIn(sentence).matchData.foreach(m => println("hello, " + m.group(1) + ". " + m.group(3)))



Name.findAllIn(sentence).matchData.filter(m => m.group(1) == "Mr").foreach(m => println("hello, " + m.group(1) + ". " + m.group(3)))



