val sentRaw = "The/DT index/NN of/IN the/DT 100/CD largest/JJS Nasdaq/NNP financial/JJ stocks/NNS rose/VBD modestly/RB as/IN well/RB ./."
val gokenGagPairs = sentRaw.split(" ").toList.map(x => x.split("/")).map(x => Tuple2(x(0),x(1)))
val (xTokens, xTags) = sentRaw.split(" ").toList.map(x => x.split("/")).map(x => Tuple2(x(0), x(1))).unzip


def coursePos (tag: String) = tag match {
  case "NN" | "NNS" | "NNP" | "NNPS"                       => "Noun"
  case "JJ" | "JJR" | "JJS"                                => "Adjective"
  case "VB" | "VBD" | "VBG" | "VBN" | "VBP" | "VBZ" | "MD" => "Verb"
  case "RB" | "RBR" | "RBS" | "WRB" | "EX"                 => "Adverb"
  case "PRP" | "PRP$" | "WP" | "WP$"                       => "Pronoun"
  case "DT" | "PDT" | "WDT"                                => "Article"
  case "CC"                                                => "Conjunction"
  case "IN" | "TO"                                         => "Preposition"
  case _                                                   => "Other"
}
val courseTags = xTags.map(coursePos)
val noNounsNoAdjectives = courseTags.filter(x => x != "Noun").filter(x => x != "Adjective").length
val noNounsNoAdjectivesAlt = courseTags.count(x => x != "Noun" && x != "Adjective")
val listOfWords = List("first","middle","last")
val searchWord = "ifrst"
searchWord.toSet
listOfWords.filter(compareWord => compareWord.toSet == searchWord.toSet)