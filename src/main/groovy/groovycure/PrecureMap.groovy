class PrecureMap extends HashMap<String, Series> {
  def put(title, slug, broadcast_from, broadcast_to, now = flase){
    this[slug] = new Series(title, slug, broadcast_from, broadcast_to, now)
  }

  def now(){
    this.find{ it.value.now }.value
  }

  def slug(){
    this.collect{ it.key }
  }

  def series(){
    this.collect{ it.value }
  }
}