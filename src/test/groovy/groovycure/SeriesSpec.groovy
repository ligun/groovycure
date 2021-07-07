package groovycure

import spock.lang.*

class SeriesSpec extends Specification {
    def sut;

    def setup(){
        def girls = [
                new Girl(
                        'ligun',
                        'りぐん',
                        'キュアニート',
                        'あふれる汗！キュアニート！'),
                new Girl(
                        'gulin',
                        'ぐりん',
                        'キュアハケンシャイン',
                        '罵声浴びる一輪の花！キュアハケンシャイン！')

        ]
        sut = new Series(
                "agile",
                "アジャイルプリキュア",
                new Date("2014/01/01"),
                new Date("2015/01/01"),
                girls
        )
    }

    def "toStringのテスト"() {
        when:
        String title = sut

        then:
        title == "アジャイルプリキュア"
    }

    def "#propertyの値を変更できない"() {
        when:
        sut."$property" = data

        then:
        thrown(ReadOnlyPropertyException)

        where:
        property        | data
        'title'         | 'アジャイルプリキュア'
        'broadcast_from'| new Date()
        'broadcast_to'  | new Date()
        'girls'         | [new Girl('ligun','りぐん','キュアニート','あふれる汗！キュアニート！')]
    }

    def "メンバーのslugリストを取得する"() {
        when:
        def slug = sut.girls.slug()

        then:
        slug == ['ligun','gulin']
    }

    def "メンバーの名前リストを取得する"() {
        when:
        def member = sut.girls.member()
        def expected = ['りぐん','ぐりん']

        then:
        member == expected
    }

    def "全員変身する"() {
        when:
        sut.transformAll()

        then:
        sut.girls.each{ assert it.transformed == true }
    }

    def "全員変身時みんながしゃべる"() {
        expect:
        sut.transformAll() == 'あふれる汗！キュアニート！\n罵声浴びる一輪の花！キュアハケンシャイン！'
    }
}