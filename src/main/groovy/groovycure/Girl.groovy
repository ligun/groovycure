package groovycure

class Girl { 
  private final String name
  private final String  precure_name
  private boolean transformed = false
  private final String prologue

  Girl(name, precure_name, prologue) {
    this.name = name
    this.precure_name = precure_name
    this.prologue = prologue
  }

  @Override
  String toString() {
    return "${this.name}(${this.precure_name})"
  }

  def transform(){
    this.transformed = true
    return this.prologue
  }

  String getName(){
    if(this.transformed){
      return this.precure_name
    }else{
      return this.name
    }
  }
}