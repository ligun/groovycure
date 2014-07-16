import spock.lang.*

class GirlsSpec extends Specification {
  def sut

  def setup(){
    sut = new Girl("りぐん", "キュアニート", "あふれる汗！キュアニート！")
  }

  def "変身前の名前テスト"() {
    when:
    sut.transformed = false

    then:
    sut.name == "りぐん"
  }

  def "変身後の名前テスト"() {
    when:
    sut.transformed = true

    then:
    sut.name == "キュアニート"
  }

  def "名前のテスト"() {
    when:
    String name = sut
    
    then:
    name == "りぐん(キュアニート)"
  }
}