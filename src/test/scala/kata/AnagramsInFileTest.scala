package kata

import org.scalatest.{FlatSpec, Matchers}

class AnagramsInFileTest extends FlatSpec with Matchers {

  it should "match kinship and pinkish" in {
      val finder = new EfficientAnagramFinder()
      val anagram = finder.getAnagramsOf("kinship")
      anagram should be (List("kinship","pinkish"))
  }

  it should "list all anagrams for all words" in {
     val finder = new EfficientAnagramFinder()
     val setsOfAnagrams = finder.getAnagrams()
     setsOfAnagrams.size should be (49960)
    setsOfAnagrams foreach println
//     setsOfAnagrams.size should be (20683)
  }

}
