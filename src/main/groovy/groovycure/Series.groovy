package groovycure

class Series {
  private final String title
  private final Date broadcast_from
  private final Date broadcast_to
  private final boolean now = false
  private final Map<String,Girl> girls 

  Series(title, broadcast_from, broadcast_to, girls, now = false){
    this.title = title
    this.broadcast_from = broadcast_from
    this.broadcast_to = broadcast_to
    this.girls = girls
    this.now = now

    girls.getMetaClass().slug = { delegate.collect{ it.key } }
    girls.getMetaClass().member = { delegate.collect{ it.value } }
  }

  @Override
  String toString(){
    this.title
  }
}