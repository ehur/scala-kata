package kata

import org.scalatest.{Matchers, FlatSpec}

class AnagramTest extends FlatSpec with Matchers{

    it should "identify the same words are anagrams" in {
      new Sentence("fresher").isAnagramOf(new Sentence("fresher")) should be (true)
    }

    it should "identify two different words are anagrams" in {
      new Sentence("fresher").isAnagramOf(new Sentence("refresh")) should be (true)
    }

    it should "know that spaces do not count in anagrams" in {
      new Sentence("able was I a").isAnagramOf(new Sentence("waisablea")) should be (true)
    }

}
