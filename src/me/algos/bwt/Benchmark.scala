package me.algos.bwt

import scala.util.Random

/**
 * Entry point, for benchmarking purpose
 */
object Benchmark {
  def main(args: Array[String]) {
    if (args.length != 2) {
      println("Usage: benchmark <iterations> <input length>")
      System.exit(1)
    }
    val e = new BurrowsWheelerCodec()
    val iterations = args(0).toInt
    val inputLength = args(1).toInt
    val input = Random.nextString(inputLength)
    for (i <- 0 until iterations) {
      e.encode(input)
    }
  }
}