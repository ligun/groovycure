package groovycure

import spock.lang.*

class PrecureSpec extends Specification{
  def sut = Precure.precure

  def "順番通り出力される"() {
    when:
    def slug = sut.slug()

    then:
    slug == ['unmarked','maxheart','splashstar','yes','gogo',
	    'fresh','heartcatch','suite','smile','dokidoki','happinesscharge']
  }

  def "現在のプリキュアが取得できる"() { 
    when:
    def current = sut.now()

    then:
    current.toString() == 'ハピネスチャージプリキュア'
  }
}