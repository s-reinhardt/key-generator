package org.samplestack.hash

import scala.util.Random

/**
 * Generates some not very unique IDs. There are some cases where such IDs make sense, but be carefull.
 * Created by Stephan Reinhardt
 */
object UnsafeId{

  val default = DefaultWordList.getWorkds
  val extended = ExtendedWordList.getWorkds

  def getReadable(pre: Int = 1, post: Int = 1, separator: String = "-"):String = {
    if(pre < 0 && post < 0) return ""

    val preNumberList = Seq.fill(pre)(Random.nextInt(extended.size))
    val postNumberList = Seq.fill(post)(Random.nextInt(default.size))
    preNumberList.map(x => extended(x)).mkString(separator) + postNumberList.map(x => default(x)).mkString(separator)
  }

  def humanize(words: Int =4 , separator: String = "-"): String = {
    val numberList = Seq.fill(words)(Random.nextInt(default.size))
    numberList.map(x => default(x)).mkString(separator)
  }
}
