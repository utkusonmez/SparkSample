import org.apache.spark.{SparkContext, SparkConf}

object LogRDD {

  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("BadLinesApp")
    val sc = new SparkContext(conf)

    val input = sc.textFile("files/log.txt")

    val errorsRDD = input.filter(line => line.contains("ERROR"))
    val warningRDD = input.filter(line => line.contains("WARNING"))

    val badLines = errorsRDD.union(warningRDD)

    println("Input had " + badLines.count() + " concerning lines")
    println("Here are 10 examples:")
    badLines.take(10).foreach(println)
  }

}
