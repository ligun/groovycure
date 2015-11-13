package groovycure

class Series {
    private final String name
    private final String title
    private final Date broadcast_from
    private final Date broadcast_to
    private final boolean now = false
    private final List<Girl> girls

    Series(name, title, broadcast_from, broadcast_to, girls, now = false){
        this.name = name
        this.title = title
        this.broadcast_from = broadcast_from
        this.broadcast_to = broadcast_to
        this.girls = girls
        this.now = now

        girls.metaClass.slug = { delegate.collect{ it.slug } }
        girls.metaClass.member = { delegate.collect{ it.name } }
        girls.metaClass.getProperty = { property -> delegate.find{ it.slug == property } }

    }

    @Override
    String toString(){
        this.title
    }
}