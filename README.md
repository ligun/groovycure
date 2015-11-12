# groovycure

[![Join the chat at https://gitter.im/ligun/groovycure](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ligun/groovycure?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Download](https://api.bintray.com/packages/ligun/maven/groovycure/images/download.svg) ](https://bintray.com/ligun/maven/groovycure/_latestVersion)
[![Build Status](https://travis-ci.org/ligun/groovycure.svg?branch=master)](https://travis-ci.org/ligun/groovycure)
[![Stories in Ready](https://badge.waffle.io/ligun/groovycure.svg?label=ready&title=Ready)](http://waffle.io/ligun/groovycure) 

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