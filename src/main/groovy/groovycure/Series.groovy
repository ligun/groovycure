class Series {
  private String title = ''
  private String slug = ''
  private Date broadcast_from
  private Date broadcast_to
  private boolean now = false
  private List<Girl> girls = []

  Series(title, slug, broadcast_from, broadcast_to, now = false){
    this.title = title
    this.slug = slug
    this.broadcast_from = broadcast_from
    this.broadcast_to = broadcast_to
    this.now = now
  }

  @Override
  String toString(){
    this.title
  }
}