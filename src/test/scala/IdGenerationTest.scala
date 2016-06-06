
import org.samplestack.hash.{UnsafeId}
import org.scalatest._

class IdGenerationTest extends FlatSpec with Matchers {
  "The id generator" must "generate correctly" in {
    val id = UnsafeId(2,2,"-")
    assert(!id.contains(" "))
    info("id generation seems to work: " + id)
  }



  it must "generate readable id" in {
    val id = UnsafeId(5,5,"XXX")
    assert(id.size > 2)
    info("id generation seems to work: " + id)
  }

  it must "readable id should be a little unique" in {
    val count = 5000
    val list = List.fill(count)(UnsafeId(1,2,"-"))

    assert(list.size == count)
    assert(list.distinct.size == list.size)

    info("masstest seems to work.")
  }
}
