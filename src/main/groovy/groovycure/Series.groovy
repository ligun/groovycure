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

    String transformAll() {
        girls.collect{ it.transform() }.join('\n')
    }

    @Override
    String toString(){
        this.title
    }
}