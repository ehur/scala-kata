package kata

object FizzBuzz {

  def getResult (i:Int) : String = {

    val divBy3 = i % 3
    val divBy5 = i % 5
    (divBy3,divBy5) match {
      case (0,0) => "fizzbuzz"
      case (0,_) => "fizz"
      case (_,0) => "buzz"
      case (_,_) =>  i.toString()
    }
  }

}
