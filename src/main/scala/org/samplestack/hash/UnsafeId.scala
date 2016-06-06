package org.samplestack.hash

import scala.util.Random

/**
 * Generates some not very unique IDs. There are some cases where such IDs make sense, but be carefull.
 * Created by Stephan Reinhardt
 */
object UnsafeId{

  private val default = DefaultWordList.getWorkds
  private val extended = PreWordList.getWorkds

  private def randomId(pre: Int, post: Int, separator: String):String = {
    if(pre < 0 && post < 0) return ""

    val preNumberList = Seq.fill(pre)(Random.nextInt(extended.size))
    val postNumberList = Seq.fill(post)(Random.nextInt(default.size))
    preNumberList.map(x => extended(x)).mkString(separator) + postNumberList.map(x => default(x)).mkString(separator)
  }

  def apply () = randomId(1,1,"-")

  def apply (pre: Int) = randomId(pre,1,"-")

  def apply (pre: Int, post: Int, seperator: String) = randomId(pre, post, seperator)
}

trait Words {
  def getWorkds(): Seq[String]
}
