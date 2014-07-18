package groovycure

class Series {
  private String title = ''
  private Date broadcast_from
  private Date broadcast_to
  private boolean now = false
  private List<Girl> girls = []

  Series(title, broadcast_from, broadcast_to, now = false){
    this.title = title
    this.broadcast_from = broadcast_from
    this.broadcast_to = broadcast_to
    this.now = now
  }

  @Override
  String toString(){
    this.title
  }
}