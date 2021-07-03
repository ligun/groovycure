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
