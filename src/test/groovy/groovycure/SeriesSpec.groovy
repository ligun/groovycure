package groovycure

import spock.lang.*

class SeriesSpec extends Specification {
    def sut;

    def setup(){
        def girls = ['ligun':
                             new Girl(
                                     'りぐん',
                                     'キュアニート','あふれる汗！キュアニート！'
                             )]
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

    def "Girlsのkeyを取得する"() {
        when:
        def girls = sut.girls*.key

        then:
        girls == ['ligun']
    }

    @Unroll
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
        'girls'         | ['ligun':new Girl('りぐん','キュアニート','あふれる汗！キュアニート！')]
    }

    def "メンバーのslugリストを取得する"() {
        when:
        def slug = sut.girls.slug()

        then:
        slug == ['ligun']
    }

    def "メンバーの名前リストを取得する"() {
        when:
        def member = sut.girls.member()
        def expected = sut.girls.ligun

        then:
        member == [expected]
    }
}