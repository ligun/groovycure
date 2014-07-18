package groovycure

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

  def "シリーズのkeyがslugになっている"() {
    expect:
    sut."$slug".toString() == title

    where:
    slug       | title
    'waterfall'| 'ウォーターフォールプリキュア'
    'agile'    | 'アジャイルプリキュア'
    
  }
}