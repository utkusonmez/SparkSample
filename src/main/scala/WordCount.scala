import org.apache.spark.{SparkContext, SparkConf}


object WordCount {
  def main(args: Array[String]) {
    val conf = new SparkConf().setMaster("local").setAppName("My App")
    val sc = new SparkContext(conf)

    val input = sc.textFile("files/wordCount.txt")

    val words = input.flatMap(line => line.split(" "))

    val counts = words.map(word => (word, 1)).reduceByKey { case (x, y) => x + y}

    counts.saveAsTextFile("files/wordCountOutput")
  }
}
