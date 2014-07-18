package groovycure

class PrecureMap extends LinkedHashMap<String, Series> {
  def put(title, slug, broadcast_from, broadcast_to, now = flase){
    this[slug] = new Series(title, broadcast_from, broadcast_to, now)
  }
}