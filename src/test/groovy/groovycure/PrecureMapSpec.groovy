import spock.lang.*

class PrecureMapSpec extends Specification {
  def sut

  def setup() {
    sut = new PrecureMap()

    sut.put(
      'ウォーターフォールプリキュア',
      'waterfall',
      new Date('2013/01/01'),
      new Date('2013/12/31'),
    )
    
    sut.put(
      'アジャイルプリキュア',
      'agile',
      new Date('2014/01/01'),
      null,
      true
    )
  }

  def "放送中チェックのテスト"() {
    when:
    String now = sut.now()

    then:
    now == "アジャイルプリキュア"
  }

  def "slugリストの取得テスト"() { 
    when:
    def slug_list = sut.slug()

    then:
    slug_list == ["waterfall","agile"]
  }

  def "seriesリストの取得テスト"() {
    when:
    def series_list = sut.series()
    def expected_list = [sut.waterfall, sut.agile]

    then:
    series_list == expected_list
  }
}