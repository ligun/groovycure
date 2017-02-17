# groovycure

[![Join the chat at https://gitter.im/ligun/groovycure](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ligun/groovycure?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Download](https://api.bintray.com/packages/ligun/maven/groovycure/images/download.svg) ](https://bintray.com/ligun/maven/groovycure/_latestVersion)
[![Build Status](https://travis-ci.org/ligun/groovycure.svg?branch=master)](https://travis-ci.org/ligun/groovycure)
[![Stories in Ready](https://badge.waffle.io/ligun/groovycure.svg?label=ready&title=Ready)](http://waffle.io/ligun/groovycure)

All about Japanese battle heroine "Pretty Cure"

Inspired by [pycure](https://github.com/drillbits/pycure) & [rubicure](https://github.com/sue445/rubicure)

## groovycure library
Groovycure library is a implementation of Precure by Groovy.

### Installation
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

### Usage
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

## precure command
Groovycure can be used as a command.  
Command name is "precure".  
It supports Unix shell and Windows command prompt.

### Installation
You need to build & install yourself with Gradle.

```bash
git clone https://github.com/ligun/groovycure
cd groovycure
gradlew jarsh
```

Gradle jarsh task creates an executable Jar file wrapped in shell or batch script.  
If you success a build, command files are created to "./build/scripts/".
You can use precure command by moving the file to bin directory.  

```bash
cp ./build/scripts/precure /usr/local/bin
```

### Usage
#### Option
option | full name | description
-------|-----------|------------
-a     | --all     | Display all Precure information
-e     |           | Execute Groovy script with imported groovycure
-v     | --version | Display precure commad version
-h     | --help    | Display help

### Example
```bash
$ precure -e "prinntln Precure.now()"
キラキラ☆プリキュアアラモード
```

## Release Note
### 0.0.8
* Support キラキラ☆プリキュアアラモード

### 0.0.7
* Support 魔法使いプリキュア
* Change Series and Girls object to List from Map
* Change that Precure class behaves as an instance
* Add transformAll method to Girls class
* Add detransform method to Girls class
* Support "precure" shell command

### 0.0.6
* Add all of goprincess girls

### 0.0.5
* Bug fix (Add transform message to CureFlora)

### 0.0.4
* Support Go!プリンセスプリキュア

### 0.0.3
* Change so that girls object can not modified arbitrarily

### 0.0.2
* Sort by broadcast order of series
* Change so that series object can not modified arbitrarily

### 0.0.1
* First release
