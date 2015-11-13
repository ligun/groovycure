package groovycure

import spock.lang.*

class GirlsSpec extends Specification {
    def sut
    def slug = 'ligun'
    def name = 'りぐん'
    def precure_name = 'キュアニート'
    def prologue = 'あふれる汗！キュアニート！'

    def setup(){
        sut = new Girl(slug, name, precure_name, prologue)
    }

    def "変身前の名前テスト"() {
        when:
        sut.transformed = false

        then:
        sut.name == name
    }

    def "変身後の名前テスト"() {
        when:
        sut.transformed = true

        then:
        sut.name == precure_name
    }

    def "名前のテスト"() {
        when:
        String precure = sut

        then:
        precure == "${name}(${precure_name})"
    }

    @Unroll
    def "#propertyの値を変更できない"() {
        when:
        sut."$property" = data

        then:
        thrown(ReadOnlyPropertyException)

        where:
        property        | data
        'name'          | 'ぐりん'
        'precure_name'  | 'キュアハケンシャイン'
        'prologue'      | '罵声浴びる一輪の花！キュアハケンシャイン！'
    }

    def "変身バンクのテスト"() {
        when:
        sut.transformed = false

        then:
        sut.transform() == prologue
    }

    def "変身解除のテスト"() {
        setup:
        sut.transformed = true

        when:
        sut.detransform()

        then:
        sut.transformed == false
    }
}