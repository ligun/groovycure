package groovycure

class Precure implements GroovyInterceptable {
    private static final def precure
    private Precure() {}

    static void main(String... args) {
        def cli = new CliBuilder(usage:"Precure - Japanese battle heroine -")

        cli.e(argName: 'script', args: 1, 'run script')
        cli.h(longOpt: 'help', 'display to help')

        def opt = cli.parse(args)

        if(!opt) return

        if(opt.e){
            def shell = new GroovyShell(Precure.classLoader)
            shell.evaluate("""\
import groovycure.Precure
${opt.e}
"""
            )
            return
        }
        if(opt.h){
            cli.usage()
        }
    }

    static {
        def nagisa = new Girl(
                'nagisa',
                '美墨なぎさ',
                'キュアブラック',
                '''\
光の使者、キュアブラック
光の使者、キュアホワイト
ふたりはプリキュア！
闇の力のしもべたちよ！
とっととお家に帰りなさい！\
'''
        )
        def honoka = new Girl(
                'honoka',
                '雪城ほのか',
                'キュアホワイト',
                '''\
光の使者、キュアブラック
光の使者、キュアホワイト
ふたりはプリキュア！
闇の力のしもべたちよ！
とっととお家に帰りなさい！\
'''
        )
        def hikari = new Girl(
                'hikari',
                '九条ひかり',
                'シャイニールミナス',
                '輝く命！シャイニールミナス！\n光の心と光の意志、全てをひとつにするために！\n'
        )

        def saki = new Girl(
                'saki',
                '日向咲',
                'キュアブルーム',
                '''\
はばたけ大地に！
輝く金の花！キュアブルーム！
聖なる泉を汚すものよ！
阿漕な真似はおやめなさい！\
'''
        )
        def mai = new Girl(
                'mai',
                '美翔舞',
                'キュアイーグレット',
                '''\
はばたけ空に！
煌めく銀の翼！キュアイーグレット！
聖なる泉を汚すものよ！
阿漕な真似はおやめなさい！\
'''
        )

        def nozomi = new Girl(
                'nozomi',
                '夢空のぞみ',
                'キュアドリーム',
                '大いなる希望の力、キュアドリーム！'
        )
        def rin = new Girl(
                'rin',
                '夏木りん',
                'キュアルージュ',
                '情熱の赤い炎、キュアルージュ！'
        )
        def urara = new Girl(
                'urara',
                '春日野うらら',
                'キュアレモネード',
                'はじけるレモンの香り、キュアレモネード！'
        )
        def komachi = new Girl(
                'komachi',
                '秋元こまち',
                'キュアミント',
                'やすらぎの緑の大地、キュアミント！'
        )
        def karen = new Girl(
                'karen',
                '水無月かれん',
                'キュアアクア',
                '知性の青き泉、キュアアクア！'
        )
        def kurumi = new Girl(
                'kurumi',
                '美々野くるみ',
                'ミルキィローズ',
                '青いバラは秘密のしるし！ミルキィローズ！'
        )

        def love = new Girl(
                'love',
                '桃園ラブ',
                'キュアピーチ',
                'ピンクのハートはあいあるしるし！\nもぎたてフレッシュ、キュアピーチ！'
        )
        def miki = new Girl(
                'miki',
                '蒼乃美希',
                'キュアベリー',
                'ブルーのハートは希望のしるし！\n摘みたてフレッシュ、キュアベリー！'
        )

        def inori = new Girl(
                'inori',
                '山吹祈里',
                'キュアパイン',
                'イエローハートは祈りのしるし！\nとれたてフレッシュ、キュアパイン！'
        )

        def setsuna = new Girl(
                'setsuna',
                '東せつな',
                'キュアパッション',
                '真っ赤なハートは幸せの証！\n熟れたてフレッシュ、キュアパッション！'
        )

        def tsubomi = new Girl(
                'tsubomi',
                '花咲つぼみ',
                'キュアブロッサム',
                '大地に咲く一輪の花！キュアブロッサム！'
        )
        def erika = new Girl(
                'erika',
                '来海えりか',
                'キュアマリン',
                '海風に揺れる一輪の花！キュアマリン！'
        )
        def itsuki = new Girl(
                'itsuki',
                '明堂院いつき',
                'キュアサンシャイン',
                '陽の光浴びる一輪の花！キュアサンシャイン！'
        )
        def yuri = new Girl(
                'yuri',
                '月影ゆり',
                'キュアムーンライト',
                '月光に冴える一輪の花！キュアムーンライト！'
        )

        def hibiki = new Girl(
                'hibiki',
                '北条響',
                'キュアメロディ',
                '爪弾くは荒ぶる調べ！キュアメロディ！'
        )
        def kanade = new Girl(
                'kanade',
                '南野奏',
                'キュアリズム',
                '爪弾くはたおやかな調べ！キュアリズム！'
        )
        def eren = new Girl(
                'eren',
                '黒川エレン',
                'キュアビート',
                '爪弾くは魂の調べ！キュアビート！'
        )
        def ako = new Girl(
                'ako',
                '調辺アコ',
                'キュアミューズ',
                '爪弾くは女神の調べ！キュアミューズ！'
        )

        def miyuki = new Girl(
                'miyuki',
                '星空みゆき',
                'キュアハッピー',
                'キラキラ輝く未来の光！キュアハッピー！'
        )
        def akane = new Girl(
                'akane',
                '日野あかね',
                'キュアサニー',
                '太陽サンサン熱血パワー！キュアサニー！'
        )
        def yayoi = new Girl(
                'yayoi',
                '黄瀬やよい',
                'キュアピース',
                'ピカピカぴかりんじゃんけんポン！キュアピース！'
        )
        def nao = new Girl(
                'nao',
                '緑川なお',
                'キュアマーチ',
                '勇気リンリン直球勝負！キュアマーチ！'
        )
        def reika = new Girl(
                'reika',
                '青木れいか',
                'キュアビューティ',
                'しんしんと降り積もる清き心、キュアビューティ！'
        )

        def mana = new Girl(
                'mana',
                '相田マナ',
                'キュアハート',
                'みなぎる愛！キュアハート！'
        )
        def rikka = new Girl(
                'rikka',
                '菱川六花',
                'キュアダイヤモンド',
                '英知の光！キュアダイヤモンド'
        )
        def arisu = new Girl(
                'arisu',
                '四葉ありす',
                'キュアロゼッタ',
                'ひだまりポカポカ！キュアロゼッタ！'
        )
        def makoto = new Girl(
                'makoto',
                '剣崎真琴',
                'キュアソード',
                '勇気の刃！キュアソード！'
        )
        def aguri = new Girl(
                'aguri',
                '円亜久里',
                'キュアエース',
                '愛の切り札！キュアエース！'
        )

        def megumi = new Girl(
                'megumi',
                '愛乃めぐみ',
                'キュアラブリー',
                '世界に広がるビッグな愛！キュアラブリー！'
        )
        def hime = new Girl(
                'hime',
                '白雪ひめ',
                'キュアプリンセス',
                '天空に舞う蒼き風！キュアプリンセス！'
        )
        def yuuko = new Girl(
                'yuuko',
                '大森ゆうこ',
                'キュアハニー',
                '大地に実る命の光！キュアハニー！'
        )
        def iona = new Girl(
                'iona',
                '氷川いおな',
                'キュアフォーチュン',
                '夜空にきらめく希望の星！キュアフォーチュン！'
        )

        def haruka = new Girl(
                'haruka',
                '春野はるか',
                'キュアフローラ',
                '咲き誇る花のプリンセス！キュアフローラ！'
        )

        def minami = new Girl(
                'minami',
                '海藤みなみ',
                'キュアマーメイド',
                '澄みわたる海のプリンセス！キュアマーメイド！'
        )

        def kirara = new Girl(
                'kirara',
                '天ノ川きらら',
                'キュアトゥインクル',
                'きらめく星のプリンセス！キュアトゥインクル！'
        )

        def towa = new Girl(
                'towa',
                '紅城トワ',
                'キュアスカーレット',
                '真紅の炎のプリンセス！キュアスカーレット！'
        )

        def unmarked_girls =
                [
                        nagisa,
                        honoka
                ].asImmutable()

        def maxheart_girls =
                [
                        nagisa,
                        honoka,
                        hikari
                ].asImmutable()

        def splashstar_girls =
                [
                        saki,
                        mai
                ].asImmutable()

        def yes_girls =
                [
                        nozomi,
                        rin,
                        urara,
                        komachi,
                        karen
                ].asImmutable()

        def gogo_girls =
                [
                        nozomi,
                        rin,
                        urara,
                        komachi,
                        karen,
                        kurumi
                ].asImmutable()

        def fresh_girls =
                [
                        love,
                        miki,
                        inori,
                        setsuna
                ].asImmutable()

        def heartcatch_girls =
                [
                        tsubomi,
                        erika,
                        itsuki,
                        yuri
                ].asImmutable()

        def suite_girls =
                [
                        hibiki,
                        kanade,
                        eren,
                        ako
                ].asImmutable()

        def smile_girls =
                [
                        miyuki,
                        akane,
                        yayoi,
                        nao,
                        reika
                ].asImmutable()

        def dokidoki_girls =
                [
                        mana,
                        rikka,
                        arisu,
                        makoto,
                        aguri
                ].asImmutable()

        def happinesscharge_girls =
                [
                        megumi,
                        hime,
                        yuuko,
                        iona
                ].asImmutable()

        def goprincess_girls =
                [
                        haruka,
                        minami,
                        kirara,
                        towa,
                ].asImmutable()

        precure = [
                new Series('unmarked','ふたりはプリキュア',new Date('2004/2/1'),new Date('2005/1/30'),unmarked_girls),
                new Series('maxheart','ふたりはプリキュア Max Heart',new Date('2005/2/6'),new Date('2006/1/29'),maxheart_girls),
                new Series('splashstar','ふたりはプリキュア Splash Star',new Date('2006/2/5'),new Date('2007/1/28'),splashstar_girls),
                new Series('yes','Yes！プリキュア5',new Date('2007/2/4'),new Date('2008/1/27'),yes_girls),
                new Series('gogo','Yes！プリキュア5 Go Go！',new Date('2008/2/3'),new Date('2009/1/25'),gogo_girls),
                new Series('fresh','フレッシュプリキュア',new Date('2009/2/1'),new Date('2010/1/31'),fresh_girls),
                new Series('heartcatch','ハートキャッチプリキュア',new Date('2010/2/7'),new Date('2011/1/30'),heartcatch_girls),
                new Series('suite','スイートプリキュア',new Date('2011/2/6'),new Date('2012/2/29'),suite_girls),
                new Series('smile','スマイルプリキュア',new Date('2012/2/5'),new Date('2013/1/27'),smile_girls),
                new Series('dokidoki','ドキドキ！プリキュア',new Date('2013/2/3'),new Date('2014/1/26'),dokidoki_girls),
                new Series('happinesscharge','ハピネスチャージプリキュア',new Date('2014/2/2'),new Date('2015/1/25'),happinesscharge_girls),
                new Series('goprincess','Go！プリンセスプリキュア',new Date('2015/2/1'),null,goprincess_girls,true),
        ].asImmutable()

        precure.metaClass.now = { delegate.find{ it.now } }
        precure.metaClass.slug = { delegate.collect{ it.name } }
        precure.metaClass.series = { delegate.collect{ it } }
        precure.metaClass.getProperty = { name -> precure.find{ it.name == name } }

        Precure.metaClass.static.invokeMethod = { name, args ->
            precure."$name"(*args)
        }

        Precure.metaClass.static.propertyMissing = { name ->
            precure."$name"
        }
    }
}

