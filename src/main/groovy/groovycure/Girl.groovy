package groovycure

class Girl {
    private final String slug
    private final String name
    private final String  precure_name
    private boolean transformed = false
    private final String prologue

    Girl(slug, name, precure_name, prologue) {
        this.slug = slug
        this.name = name
        this.precure_name = precure_name
        this.prologue = prologue
    }

    @Override
    String toString() {
        return "${this.name}(${this.precure_name})"
    }

    String transform(){
        if(transformed) return ""
        this.transformed = true
        return this.prologue
    }

    void detransform() {
        this.transformed = false
        return
    }

    String getName(){
        if(this.transformed){
            return this.precure_name
        }else{
            return this.name
        }
    }
}