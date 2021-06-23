package groovycure

class Precure implements GroovyInterceptable {
    private static final def precure
    private static final String VERSION = '0.1.0-SNAPSHOT'
    private static final String DESCRIPTION = 'PreCure(Pretty Cure)'

    private Precure() {}

    static void main(String... args) {
        def cli = new CliBuilder(usage: 'PreCure')

        cli.a(longOpt: 'all', 'show all Precure information')
        cli.e(argName: 'script', args: 1, 'run script')
        cli.h(longOpt: 'help', 'display to help')
        cli.v(longOpt: 'version', 'show version')

        def opt = cli.parse(args)

        if (!opt) return

        if (opt.a) {
            Precure.series().each { series ->
                println series.title
                println "  - 放送開始：${series.broadcast_from.format('yyyy/MM/dd')}"
                println "  - 放送終了：${series.broadcast_to?.format('yyyy/MM/dd') ?: 'On air'}"
                println "  - プリキュア："
                series.girls.each { girls ->
                    println "    * ${girls.name}(${girls.precure_name})"
                    girls.prologue.split('\n').each { println "      $it" }
                }
                println()
            }
        }

        if (opt.e) {
            def shell = new GroovyShell(Precure.classLoader)
            shell.evaluate("""\
import groovycure.Precure
${opt.e}
"""
            )
            return
        }
        if (opt.h) {
            cli.usage()
        }
        if (opt.v) {
            println "${DESCRIPTION} Base:groovycure Version:${VERSION}"
        }
    }

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
