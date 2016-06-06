
import org.samplestack.hash.PBKDF2WithHmacSHA512Hash
import org.scalatest._

class PBKDF2WithHmacSHA512Test extends FlatSpec with Matchers {
  "The hash generator" must "generate correctly" in {
    val id = PBKDF2WithHmacSHA512Hash("testtesttest", "salt", 500, 50)

    info("id generation seems to work: " + id)
  }


}
