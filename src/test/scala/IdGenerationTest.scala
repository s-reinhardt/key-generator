
import org.samplestack.hash.{UnsafeId}
import org.scalatest._

class IdGenerationTest extends FlatSpec with Matchers {
  "The id generator" must "generate correctly" in {
    val id = UnsafeId.randomId(2,2,"-")
    assert(!id.contains(" "))
    info("id generation seems to work: " + id)
  }



  it must "generate readable id" in {
    val id = UnsafeId.randomId(5,5,separator = "XXX")
    assert(id.size > 2)
    info("id generation seems to work: " + id)
  }

  it must "readable id should be a little unique" in {
    val count = 5000
    val list = List.fill(count)(UnsafeId.randomId(2,2,"-"))

    assert(list.size == count)
    implicit def enhanceWithContainsDuplicates[T](s:List[T]) = new {
      def containsDuplicates = (s.distinct.size != s.size)
    }
    list.distinct.size
    println(list.diff(list.distinct).distinct)
    assert(!list.containsDuplicates)
    info("masstest seems to work.")
  }
}
