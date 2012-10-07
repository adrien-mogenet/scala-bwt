package me.algos.rotation

/**
 * Perform rotations on collections
 * 
 * @author Adrien Mogenet <adrien.mogenet@gmail.com>
 */
object Rotation {

  def rotateLeft(coll: String, n: Int) =
    rotate(coll, n)

  def rotateRight(coll: String, n: Int) =
    rotate(coll, -n)

  /**
   * Perform a rotation. Default to the left, give a negative number for right
   * rotation.
   * 
   * @see: http://blog.flotsam.nl/2011/12/generic-rotation-in-scala.html
   */
  def rotate[A, C](coll: C, number: Int)(implicit c2i: C => Iterable[A], cbf: collection.generic.CanBuildFrom[C, A, C]): Option[C] = {
    if (coll.hasDefiniteSize) {
      val positions = number % coll.size match {
        case i if i < 0 => i + coll.size
        case i => i
      }
      val builder = cbf()
      builder ++= coll.drop(positions)
      builder ++= coll.take(positions)
      Some(builder.result())
    } else None
  }
}