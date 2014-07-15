import spock.lang.*

class GirlsSpec extends Specification {
  def "変身前の名前テスト"() {
    setup:
    def sut = new Girl("りぐん", "キュアニート")

    when:
    sut.transformed = false

    then:
    sut.name == "りぐん"
  }

  def "変身後の名前テスト"() {
    setup:
    def sut = new Girl("りぐん", "キュアニート")
    
    when:
    sut.transformed = true

    then:
    sut.name == "キュアニート"
  }
}