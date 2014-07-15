class Girl { 
  private def name = "";
  private def precure_name = "";
  private def transformed = false

  Girl(name, precure_name) {
    this.name = name
    this.precure_name = precure_name
  }

  @Override
  String toString() {
    return "${this.name}(${this.precure_name})"
  }

  String getName(){
    if(this.transformed){
      return this.precure_name
    }else{
      return this.name
    }
  }
}