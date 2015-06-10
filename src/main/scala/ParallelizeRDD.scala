import org.apache.spark.{SparkContext, SparkConf}


object ParallelizeRDD {

  def main(args : Array[String]){

    val conf = new SparkConf().setMaster("local").setAppName("ParallelizeApp")
    val sc = new SparkContext(conf)

    val input = sc.parallelize(List("utku sonmez", "java developer"))

    val words = input.flatMap(i => i.split(" "))

    println("words count paralelize: " + words.count())
  }

}
