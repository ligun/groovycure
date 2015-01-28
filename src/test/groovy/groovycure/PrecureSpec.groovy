package groovycure

import spock.lang.*

class PrecureSpec extends Specification{
  def sut = Precure.precure

  def "slugが順番通り出力される"() {
    when:
    def slug = sut.slug()

    then:
    slug == ['unmarked','maxheart','splashstar','yes','gogo',
	    'fresh','heartcatch','suite','smile','dokidoki','happinesscharge','goprincess']
  }

  def "シリーズが順番通り取得できる"() {
    when:
    def series = sut.series()*.toString()

    then:
    series == [
      'ふたりはプリキュア',
      'ふたりはプリキュア Max Heart',
      'ふたりはプリキュア Splash Star',
      'Yes！プリキュア5',
      'Yes！プリキュア5 Go Go！',
      'フレッシュプリキュア',
      'ハートキャッチプリキュア',
      'スイートプリキュア',
      'スマイルプリキュア',
      'ドキドキ！プリキュア',
      'ハピネスチャージプリキュア',
      'Go！プリンセスプリキュア'
    ]
  }

  def "現在のプリキュアが取得できる"() { 
    when:
    def current = sut.now()

    then:
    current.toString() == 'Go！プリンセスプリキュア'
  }

  def "勝手シリーズを追加しようとしたら例外が出る"() {
    given:
    def slug = 'agile'
    def title = 'アジャイルプリキュア'
    def girls = ['ligun':
		 new Girl('りぐん','キュアニート','あふれる汗！キュアニート！')]

    when:
    sut[slug] = new Series(title, new Date(), null, girls)

    then:
    thrown(UnsupportedOperationException)
    
  }

  def "勝手キュアを追加しようとしたら例外が出る"() {
    given:
    def slug = 'ligun'
    def girl = new Girl('りぐん','キュアニート','あふれる汗！キュアニート！')

    when:
    sut.unmarked.girls.put(slug,girl)
    
    then:
    thrown(UnsupportedOperationException)
  }

  def "ふたりはプリキュアの放送開始日が正しい"() {
    when:
    def date = sut.unmarked.broadcast_from

    then:
    date == new Date('2004/02/01')
  }

  def "ふたりはプリキュアの放送終了日が正しい"() {
    when:
    def date = sut.unmarked.broadcast_to

    then:
    date == new Date('2005/01/30')
  }
}