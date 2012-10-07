package me.algos.bwt

object BWT {

  def usage {
    println("Usage: bwt\n" +
      "  --encode <decoded-input> => (encoded-output, position)\n" +
      "  --decode <encoded-input> <position> => decoded-output")
    System.exit(1)
  }

  def main(args: Array[String]) {
    val bc = new BurrowsWheelerCodec();
    if (args.length < 2) usage
    if (args(0) == "--decode") {
      if (args.length != 3) usage
      println(bc.decode(args(1), args(2).toInt))
    }
    if (args(0) == "--encode") {
      println(bc.encode(args(1)))
    }
  }
}