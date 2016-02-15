import org.samplestack.hash.{UnsafeId}
import org.scalatest._

class IdGenerationTest extends FlatSpec with Matchers {
  "The id generator" must "generate correctly" in {
    val id = UnsafeId.humanize(3,"-")
    assert(!id.contains(" "))
    info("id generation seems to work: " + id)
  }

  it must "generate readable id" in {
    val id = UnsafeId.getReadable()
    assert(id.size > 2)
    info("id generation seems to work: " + id)
  }

  it must "readable id should be a little unique" in {
    val count = 1000
    val list = List.fill(count)(UnsafeId.getReadable())

    assert(list.size == count)
    implicit def enhanceWithContainsDuplicates[T](s:List[T]) = new {
      def containsDuplicates = (s.distinct.size != s.size)
    }
    println(list.diff(list.distinct).distinct)
    assert(!list.containsDuplicates)
    info("masstest seems to work.")
  }
}
