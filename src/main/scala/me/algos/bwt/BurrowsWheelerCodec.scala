package me.algos.bwt

import me.algos.rotation.Rotation

/**
 * Implementation of BurrowsWheeler transform.
 * The Burrows-Wheeler transform (BWT, also called block-sorting compression),
 * is an algorithm used in data compression techniques such as bzip2. It was
 * invented by Michael Burrows and David Wheeler in 1994 while working at DEC
 * Systems Research Center in Palo Alto, California.[1] It is based on a
 * previously unpublished transformation discovered by Wheeler in 1983.
 *
 * When a character string is transformed by the BWT, none of its characters
 * change value. The transformation permutes the order of the characters. If the
 * original string had several substrings that occurred often, then the
 * transformed string will have several places where a single character is
 * repeated multiple times in a row. This is useful for compression, since it
 * tends to be easy to compress a string that has runs of repeated characters by
 * techniques such as move-to-front transform and run-length encoding.
 *
 * For example:
 * <pre>
 * Input SIX.MIXED.PIXIES.SIFT.SIXTY.PIXIE.DUST.BOXES
 * Output  TEXYDST.E.IXIXIXXSSMPPS.B..E.S.EUSFXDIIOIIIT
 * </pre>
 *
 * The output is easier to compress because it has many repeated characters.
 * In fact, in the transformed string, there are a total of six runs of
 * identical characters: XX, SS, PP, .., II, and III, which together make 13 out
 * of the 44 characters in it.
 *
 * @see http://en.wikipedia.org/wiki/Burrows-Wheeler_transform
 * @author Adrien Mogenet <adrien.mogenet@gmail.com>
 */
class BurrowsWheelerCodec {

  /**
   * Encode the input string
   */
  def encode(input: String): String = {
    val matrix = rotations(input)
      .sortWith((a: String, b: String) => a.compareTo(b) < 0)
    val pos = matrix.indexOf(input)
    val lasts = for (rotation <- matrix)
      yield rotation.last
    pos.toString + lasts.mkString
  }
  
  /**
   * Decode the input string
   */
  def decode(input: String): String = {
    val lasts = input.toSeq.map(c => String.valueOf(c))
    for (i <- 0 until input.length()) {
      input.sortWith((a: Char, b: Char) => a < b)
      for (j <- 0 until input.length()) {

      }
    }
    input
  }

  /**
   * Generate list of rotated versions
   */
  private def rotations(input: String): Seq[String] = {
    for (i <- 0 until input.length())
      yield Rotation.rotateRight(input, i).get
  }
}