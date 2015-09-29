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

  @Unroll
  def "#seriesの放送開始日は#dateである"() {
    when:
      def broadcast_from = sut."$series".broadcast_from
      
    then:
      broadcast_from == new Date("$date")
      
    where:
      series            |  date
      'unmarked'        |  '2004/02/01'
      'goprincess'      |  '2015/02/01'
  }
  
  @Unroll
  def "#seriesの放送終了日は#dateである"() {
    when:
      def broadcast_to = sut."$series".broadcast_to
      
    then:
      broadcast_to == new Date("$date")
      
    where:
      series            |  date
      'unmarked'        |  '2005/01/30'
      'happinesscharge' |  '2015/01/25'
  }
  
  def "放映中のシリーズの放送終了日は設定されていない"() {
    when:
      def date = sut.now().broadcast_to
      
    then:
      date == null
  }
  
  @Unroll
  def "#seriesヒロイン#nameの変身バンクは#speachから始まる"() {
    when:
      def girl = sut."$series".girls."$name"
      
    then:
      girl.transform().startsWith(speach)
      
    where:
      series        |  name      |  speach
      'goprincess'| 'haruka'  |  '咲き誇る花のプリンセス！キュアフローラ！'
      'goprincess'| 'minami'  | '澄みわたる海のプリンセス！キュアマーメイド！'
      'goprincess'| 'kirara'  | 'きらめく星のプリンセス！キュアトゥインクル！'
      'goprincess'| 'towa'    | '真紅の炎のプリンセス！キュアスカーレット！'


  }
}