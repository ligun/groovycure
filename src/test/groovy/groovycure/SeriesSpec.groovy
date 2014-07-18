package groovycure

import spock.lang.*

class SeriesSpec extends Specification {
  def sut;

  def setup(){
    sut = new Series("アジャイルプリキュア",
			 new Date("2014/01/01"),
			 new Date("2015/01/01"))
  }

  def "toStringのテスト"() {
    when:
    String title = sut

    then:
    title == "アジャイルプリキュア"
  }
}