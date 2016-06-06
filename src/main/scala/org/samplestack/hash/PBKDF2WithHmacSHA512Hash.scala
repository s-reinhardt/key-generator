package org.samplestack.hash

import java.security.NoSuchAlgorithmException
import scala.language.implicitConversions
/**
  * Created by stephan on 07.06.16.
  */
object PBKDF2WithHmacSHA512Hash {

  def apply(password: String, salt: String, iterations: Int, keyLength: Int) = {

    import javax.crypto.spec.PBEKeySpec
    import javax.crypto.SecretKeyFactory

    try {
      val skf = SecretKeyFactory.getInstance( "PBKDF2WithHmacSHA512" )
      val spec = new PBEKeySpec( password.toCharArray, salt.getBytes("UTF-8"), iterations, keyLength)
      val key = skf.generateSecret( spec )
      val encoded = key.getEncoded
      encoded.map( "%02x".format(_) ).mkString("")
    } catch {
      case e : NoSuchAlgorithmException => throw new IllegalStateException("PBKDF2WithHmacSHA512 algorithm is unknown for this system.",e)
      case e:Exception => throw new IllegalStateException("There is an error", e)
    }
  }
}
