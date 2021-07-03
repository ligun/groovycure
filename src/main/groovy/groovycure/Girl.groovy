/*
Copyright 2021 ligun

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
 */

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