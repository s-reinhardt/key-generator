package org.samplestack.hash

import scala.util.Random

/**
 * Created by Stephan Reinhardt on 11.11.2015.
 */
object Id {

  val default = DefaultWordList.getWorkds
  val extended = ExtendedWordList.getWorkds

  def getReadable:String = {
    extended(Random.nextInt(extended.size)) + ' ' +  default(Random.nextInt(default.size))
  }

  def humanize(words: Int =4 , separator: String = "-"): String = {

    val numberList = Seq.fill(words)(Random.nextInt(default.size))
    numberList.map(x => default(x)).mkString(separator)
  }

}
