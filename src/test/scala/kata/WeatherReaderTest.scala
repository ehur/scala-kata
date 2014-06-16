package kata

import org.scalatest.{Matchers, FlatSpec}

class WeatherReaderTest extends FlatSpec with Matchers {

  "WeatherReader" should "extract the details" in {
    val reader = new WeatherReader("weather.dat")
    val dataFile = reader.readData()
    dataFile.size should be (30)
    dataFile.head.trim().indexOf("30  90") should be (0)
    dataFile.last.trim().indexOf("1  88") should be (0)
  }

  "WeatherReader" should "get variations per day" in {
    val reader = new WeatherReader("weather.dat")
    val variations = reader.readDailyVariations()
    variations.size should be (30)
    val v1 = DailyVariation(1,29)
    val v2 = DailyVariation(14,2)
    val v3 = DailyVariation(23,22)
    variations should contain allOf (v1,v2,v3)
  }

  "WeatherReader" should "find max variation" in {
    val reader = new WeatherReader("weather.dat")
    val maxVar = reader.getMaxVariation()
    val expected = DailyVariation(9,54)
    maxVar should be (expected)
  }


  "WeatherReader" should "find min variation" in {
    val reader = new WeatherReader("weather.dat")
    val minVar = reader.getMinVariation()
    val expected = DailyVariation(14,2)
    minVar should be (expected)
  }
}
