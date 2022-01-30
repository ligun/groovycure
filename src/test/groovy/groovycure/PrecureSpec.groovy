package groovycure

import spock.lang.*

class PrecureSpec extends Specification{
    def sut = Precure.precure

    def "slugが順番通り出力される"() {
        when:
        def slug = sut.slug()

        then:
        slug == ['unmarked','maxheart','splashstar','yes','gogo',
                 'fresh','heartcatch','suite','smile','dokidoki',
                 'happinesscharge','goprincess', 'mahotsukai', 'kirakira',
                 'hugtto', 'startwinkle', 'healingood', 'tropicalrouge']
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
                'Go！プリンセスプリキュア',
                '魔法使いプリキュア',
                'キラキラ☆プリキュアアラモード',
                'HUGっと！プリキュア',
                'スター☆トゥインクルプリキュア',
                'ヒーリングっど♥プリキュア',
                'トロピカル～ジュ！プリキュア',
        ]
    }

    def "現在のシリーズは#expectedである"() {
        when:
        def current = sut.now()

        then:
        current?.toString() == expected

        where:
        expected = null
    }

    def "勝手シリーズを追加しようとしたら例外が出る"() {
        given:
        def slug = 'agile'
        def title = 'アジャイルプリキュア'
        def girls = [new Girl('ligun','りぐん','キュアニート','あふれる汗！キュアニート！')]

        when:
        sut.add(new Series(slug, title, new Date(), null, girls))

        then:
        thrown(UnsupportedOperationException)

    }

    def "勝手キュアを追加しようとしたら例外が出る"() {
        given:
        def girl = new Girl('ligun','りぐん','キュアニート','あふれる汗！キュアニート！')

        when:
        sut.unmarked.girls.add(girl)

        then:
        thrown(UnsupportedOperationException)
    }

    def "#seriesの放送開始日は#dateである"() {
        when:
        def broadcast_from = sut."$series".broadcast_from

        then:
        broadcast_from == new Date("$date")

        where:
        series            |  date
        'unmarked'        |  '2004/02/01'
        'goprincess'      |  '2015/02/01'
        'kirakira'        |  '2017/02/05'
        'hugtto'          |  '2018/02/04'
        'startwinkle'     |  '2019/02/03'
        'healingood'      |  '2020/02/02'
        'tropicalrouge'   |  '2021/02/28'
    }

    def "#seriesの放送終了日は#dateである"() {
        when:
        def broadcast_to = sut."$series".broadcast_to

        then:
        broadcast_to == new Date("$date")

        where:
        series            |  date
        'unmarked'        |  '2005/01/30'
        'happinesscharge' |  '2015/01/25'
        'kirakira'        |  '2018/01/28'
        'hugtto'          |  '2019/01/27'
        'startwinkle'     |  '2020/01/26'
        'healingood'      |  '2021/02/21'
        'tropicalrouge'   |  '2022/01/30'
    }

    def "放映中のシリーズの放送終了日は設定されていない"() {
        when:
        def date = sut.now()?.broadcast_to

        then:
        date == null
    }

    def "#seriesヒロイン#nameの変身バンクは#speachから始まる"() {
        when:
        def girl = sut."$series".girls."$name"

        then:
        girl.transform().startsWith(speach)

        where:
        series      |  name     |  speach
        'goprincess'| 'haruka'  |  '咲き誇る花のプリンセス！キュアフローラ！'
        'goprincess'| 'minami'  | '澄みわたる海のプリンセス！キュアマーメイド！'
        'goprincess'| 'kirara'  | 'きらめく星のプリンセス！キュアトゥインクル！'
        'goprincess'| 'towa'    | '真紅の炎のプリンセス！キュアスカーレット！'


    }

    def "#seriesのメンバーは#expectedである"(){
        when:
        def girls = sut."$series".girls.collect{ it.slug }

        then:
        girls == expected

        where:
        series             || expected
        'unmarked'         || ['nagisa', 'honoka']
        'maxheart'         || ['nagisa', 'honoka', 'hikari']
        'splashstar'       || ['saki', 'mai']
        'yes'              || ['nozomi', 'rin', 'urara', 'komachi', 'karen']
        'gogo'             || ['nozomi', 'rin', 'urara', 'komachi', 'karen', 'kurumi']
        'fresh'            || ['love', 'miki', 'inori', 'setsuna']
        'heartcatch'       || ['tsubomi', 'erika', 'itsuki', 'yuri']
        'suite'            || ['hibiki', 'kanade', 'eren', 'ako']
        'smile'            || ['miyuki', 'akane', 'yayoi', 'nao', 'reika']
        'dokidoki'         || ['mana', 'rikka', 'arisu', 'makoto', 'aguri']
        'happinesscharge'  || ['megumi', 'hime', 'yuuko', 'iona']
        'goprincess'       || ['haruka', 'minami', 'kirara', 'towa']
        'mahotsukai'       || ['mirai', 'riko', 'kotoha']
        'kirakira'         || ['ichika', 'himari', 'aoi', 'yukari', 'akira', 'shieru']
        'hugtto'           || ['hana', 'saaya', 'homare', 'emiru', 'amour']
        'startwinkle'      || ['hikaru', 'rara', 'erena', 'madoka', 'yuni']
        'healingood'       || ['nodoka', 'chiyu', 'hinata', 'asumi']
        'tropicalrouge'    || ['manatsu', 'sango', 'minori', "asuka", "laura"]
    }

    def "precureプロパティを使用せずにPrecureクラスから直接動作できる"() {
        expect:
        Precure.now() == Precure.precure.now()
    }
}
