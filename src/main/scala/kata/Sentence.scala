package kata

class Sentence (words: String) {
    val wordsInSentence = words.replaceAll(" ","")
    def isAnagramOf(other:Sentence): Boolean = {
      if (wordsInSentence.equalsIgnoreCase(other.wordsInSentence)) {
        true
      } else {
        val thisChars = wordsInSentence.toLowerCase.toList.sortWith(_ > _)
        val thoseChars = other.wordsInSentence.toLowerCase.toList.sortWith(_ > _)
        thisChars.equals(thoseChars)
      }

    }
}
