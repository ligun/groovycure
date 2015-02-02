# groovycure
[![Build Status](https://travis-ci.org/ligun/groovycure.svg?branch=master)](https://travis-ci.org/ligun/groovycure)

All about Japanese battle heroine "Pretty Cure"

Inspired by [pycure](https://github.com/drillbits/pycure) & [rubicure](https://github.com/sue445/rubicure)

## Installation
Use Grape in Groovy script file.
```groovy
@Grab('groovycure:groovycure')
```

Or install it using Gradle
```groovy
repositories {
  jcenter()
}
dependencies {
  compile 'groovycure:groovycure:+'
}
```

## Usage
Run with Grape
```groovy
@Grab('groovycure:groovycure')
import static groovycure.Precure.precure

println precure.now()
```

Or run with Gradle
```groovy
import static groovycure.Precure.precure

println precure.now()
```
If you execute groovycure in groovysh
```groovy
$ groovysh

> groovy.grape.Grape.grab(group:'groovycure',module:'groovycure')
> import static grooycure.Precure.precure
>
> Precure.precure.now()
```