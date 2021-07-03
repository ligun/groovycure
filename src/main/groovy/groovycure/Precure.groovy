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

class Precure implements GroovyInterceptable {
    private static final def precure

    private Precure() {}

    static {
        def conf = new ConfigSlurper().parse(Precure.class.getClassLoader().getResource('PrecureConfig.groovy'))
        def girls = conf.girls.collect { slug, girl -> new Girl(slug, girl.name, girl.precure_name, girl.prologue) }
        precure = conf.series.collect { slug, series ->
            new Series(
                    slug,
                    series.title,
                    new Date(series.broadcast_from),
                    series.broadcast_to ? new Date(series.broadcast_to) : null,
                    series.girls.collect { name -> girls.find { it.slug == name } }.asImmutable(),
                    !series.broadcast_to
            )
        }.asImmutable()

        precure.metaClass.now = { delegate.find { it.now } }
        precure.metaClass.slug = { delegate.collect { it.name } }
        precure.metaClass.series = { delegate.collect { it } }
        precure.metaClass.getProperty = { name -> precure.find { it.name == name } }

        Precure.metaClass.static.invokeMethod = { name, args ->
            precure."$name"(*args)
        }

        Precure.metaClass.static.propertyMissing = { name ->
            precure."$name"
        }
    }
}
