package groovycure

class Precure {
  public static final def precure = Collections.unmodifiableMap(
    new LinkedHashMap<String, Series>(){{
	put('unmarked',new Series('ふたりはプリキュア',new Date('2004/2/1'),new Date('2005/1/30')))
	put('maxheart',new Series('ふたりはプリキュア Max Heart',new Date('2005/2/6'),new Date('2006/1/29')))
	put('splashstar',new Series('ふたりはプリキュア Splash Star',new Date('2006/2/5'),new Date('2007/1/28')))
	put('yes',new Series('Yes！プリキュア5',new Date('2007/2/4'),new Date('2008/1/27')))
	put('gogo',new Series('Yes！プリキュア5 Go Go！',new Date('2008/2/3'),new Date('2009/1/25')))
	put('fresh',new Series('フレッシュプリキュア',,new Date('2009/2/1'),new Date('2010/1/31')))
	put('heartcatch',new Series('ハートキャッチプリキュア',new Date('2010/2/7'),new Date('2011/1/30')))
	put('suite',new Series('スイートプリキュア',new Date('2011/2/6'),new Date('2012/2/29')))
	put('smile',new Series('スマイルプリキュア',new Date('2012/2/5'),new Date('2013/1/27')))
	put('dokidoki',new Series('ドキドキ！プリキュア',new Date('2013/2/3'),new Date('2014/1/26')))
	put('happinesscharge',new Series('ハピネスチャージプリキュア',new Date('2014/2/2'),null,true))
      }}
  )
  
  static {
    Map.metaClass.now = { delegate.find{ it.value.now }.value }
    Map.metaClass.slug = { delegate.collect{ it.key } }
    Map.metaClass.series = { delegate.collect{ it.value } }
    
    def nagisa = new Girl(
      '美墨なぎさ',
      'キュアブラック',
	'''光の使者、キュアブラック
光の使者、キュアホワイト
ふたりはプリキュア！
闇の力のしもべたちよ！
とっととお家に帰りなさい！'''
    )
    def honoka = new Girl(
      '雪城ほのか',
      'キュアホワイト',
      '''光の使者、キュアブラック
光の使者、キュアホワイト
ふたりはプリキュア！
闇の力のしもべたちよ！
とっととお家に帰りなさい！'''
    )
    
    precure.unmarked.girls = [nagisa,honoka]
    
    precure.maxheart.girls = [
      nagisa,
      honoka,
      new Girl('九条ひかり',
	       'シャイニールミナス',
	       '輝く命！シャイニールミナス！\n光の心と光の意志、全てをひとつにするために！'
	      )
    ]
    
    precure.splashstar.girls = [
      new Girl(
	'日向咲',
	'キュアブルーム',
	'''はばたけ大地に！
輝く金の花！キュアブルーム！
聖なる泉を汚すものよ！
阿漕な真似はおやめなさい！'''
      ),
      new Girl(
	'美翔舞',
	'キュアイーグレット',
	'''はばたけ空に！
煌めく銀の翼！キュアイーグレット！
聖なる泉を汚すものよ！
阿漕な真似はおやめなさい！'''
      )
    ]
    
    def nozomi = new Girl(
      '夢空のぞみ',
      'キュアドリーム',
      '大いなる希望の力、キュアドリーム！'
    )
    def rin = new Girl(
      '夏木りん',
      'キュアルージュ',
      '情熱の赤い炎、キュアルージュ！'
    )
    def urara = new Girl(
      '春日野うらら',
      'キュアレモネード',
      'はじけるレモンの香り、キュアレモネード！'
    )
    def komachi = new Girl(
      '秋元こまち',
      'キュアミント',
      'やすらぎの緑の大地、キュアミント！'
    )
    def karen = new Girl(
      '水無月かれん',
      'キュアアクア',
      '知性の青き泉、キュアアクア！'
    )
    
    precure.yes.girls = [
      nozomi,rin,urara,komachi,karen
    ]
    
    precure.gogo.girls = [
      nozomi,rin,urara,komachi,karen,
	new Girl(
	  '美々野くるみ',
	  'ミルキィローズ',
	  '青いバラは秘密のしるし！ミルキィローズ！'
	)
    ]
    
    precure.fresh.girls = [
      new Girl(
	'桃園ラブ',
	'キュアピーチ',
	'ピンクのハートはあいあるしるし！\nもぎたてフレッシュ、キュアピーチ！'
      ),
      new Girl(
	'蒼乃美希',
	'キュアベリー',
	'ブルーのハートは希望のしるし！\n摘みたてフレッシュ、キュアベリー！'
      ),
      new Girl(
	'山吹祈里',
	'キュアパイン',
	'イエローハートは祈りのしるし！\nとれたてフレッシュ、キュアパイン！'
	),
      new Girl(
	'東せつな',
	'キュアパッション',
	'真っ赤なハートは幸せの証！\n熟れたてフレッシュ、キュアパッション！'
      )
    ]

    precure.heartcatch.girls = [
      new Girl(
	'花咲つぼみ',
	'キュアブロッサム',
	'大地に咲く一輪の花！キュアブロッサム！'
      ),
      new Girl(
	'来海えりか',
	'キュアマリン',
	'海風に揺れる一輪の花！キュアマリン！'
      ),
      new Girl(
	'明堂院いつき',
	'キュアサンシャイン',
	'陽の光浴びる一輪の花！キュアサンシャイン！'
      ),
      new Girl(
	'月影ゆり',
	'キュアムーンライト',
	'月光に冴える一輪の花！キュアムーンライト！'
      )
    ]
    
    precure.suite.girls = [
      new Girl(
	'北条響',
	'キュアメロディ',
	'爪弾くは荒ぶる調べ！キュアメロディ！'
      ),
      new Girl(
	'南野奏',
	'キュアリズム',
	'爪弾くはたおやかな調べ！キュアリズム！'
      ),
      new Girl(
	'黒川エレン',
	'キュアビート',
	'爪弾くは魂の調べ！キュアビート！'
      ),
      new Girl(
	'調辺アコ',
	'キュアミューズ',
	'爪弾くは女神の調べ！キュアミューズ！'
      )
    ]
    
    precure.smile.girls = [
      new Girl(
	'星空みゆき',
	'キュアハッピー',
	'キラキラ輝く未来の光！キュアハッピー！'
      ),
      new Girl(
	'日野あかね',
	'キュアサニー',
	'太陽サンサン熱血パワー！キュアサニー！'
      ),
      new Girl(
	'黄瀬やよい',
	'キュアピース',
	'ピカピカぴかりんじゃんけんポン！キュアピース！'
      ),
      new Girl(
	'緑川なお',
	'キュアマーチ',
	'勇気リンリン直球勝負！キュアマーチ！'
      ),
      new Girl(
	'青木れいか',
	'キュアビューティ',
	'しんしんと降り積もる清き心、キュアビューティ！'
      )
    ]
    
    precure.dokidoki.girls = [
      new Girl(
	'相田マナ',
	'キュアハート',
	'みなぎる愛！キュアハート！'
      ),
      new Girl(
	'菱川六花',
	'キュアダイヤモンド',
	'英知の光！キュアダイヤモンド'
      ),
      new Girl(
	'四葉ありす',
	'キュアロゼッタ',
	'ひだまりポカポカ！キュアロゼッタ！'
      ),
      new Girl(
	'剣崎真琴',
	'キュアソード',
	'勇気の刃！キュアソード！'
      ),
      new Girl(
	'円亜久里',
	'キュアエース',
	'愛の切り札！キュアエース！'
      )
    ]
    
    precure.happinesscharge.girls = [
      new Girl(
	'愛乃めぐみ',
	'キュアラブリー',
	'世界に広がるビッグな愛！キュアラブリー！'
      ),
      new Girl(
	'白雪ひめ',
	'キュアプリンセス',
	'天空に舞う蒼き風！キュアプリンセス！'
      ),
      new Girl(
	'大森ゆうこ',
	'キュアハニー',
	'大地に実る命の光！キュアハニー！'
      ),
      new Girl(
	'氷川いおな',
	'キュアフォーチュン',
	'夜空にきらめく希望の星！キュアフォーチュン！'
      )
    ]
  }
}

