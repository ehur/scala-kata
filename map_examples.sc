val line = "1  88    59    74          53.8       0.00 F       280  9.6 270  17  1.6  93 23 1004.5"
val lineArray = line.split(" +")
lineArray(0)
lineArray(1)
lineArray(2)
val result = (lineArray(0), lineArray(1).toInt - lineArray(2).toInt )

val li = List("first line","second line","third line")
val listOfTuples = li.map{x:String => {
                  val arrayy = x.split(" ")
                  (arrayy(0),arrayy(1))
                }}
def f(x:(Int,Int),y:(Int,Int)) = (Int,Int) : { case(a,b)if (x._2 > y._2) x else y }

val reduced = listOfTuples.reduceLeft()

//.map((line: String) => line.split(" +"))