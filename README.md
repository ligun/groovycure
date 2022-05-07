# groovycure

[![Java](https://img.shields.io/badge/java-8+-4c7e9f.svg)](https://www.oracle.com/technetwork/java/javase/downloads)
[![Groovy](https://img.shields.io/badge/Groovy-3.0+-4c7e9f.svg)](https://groovy.apache.org/download.html)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/net.ligun/groovycure/badge.svg)](https://maven-badges.herokuapp.com/maven-central/net.ligun/groovycure)
[![Join the chat at https://gitter.im/ligun/groovycure](https://badges.gitter.im/Join%20Chat.svg)](https://gitter.im/ligun/groovycure?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)
[![Run unit test](https://github.com/ligun/groovycure/actions/workflows/test.yaml/badge.svg)](https://github.com/ligun/groovycure/actions/workflows/test.yaml)

All about Japanese battle heroine "Pretty Cure"

Inspired by [pycure](https://github.com/drillbits/pycure) & [rubicure](https://github.com/sue445/rubicure)

## Requirements
### JDK
Java 8 or later

### Groovy
Groovy 3.0 or later

## Installation
This library is registered in MavenCentral repository.  
Install it using Gradle

```groovy
dependencies {
  implementation 'net.ligun:groovycure:1.1'
}
```

Or use Grape in Groovy script file

```groovy
@Grab('net.ligun:groovycure:1.1')
```

## Usage
Run with Grape

```groovy
@Grab('net.ligun:groovycure')
import groovycure.Precure

println Precure.now()
```

Or run with Gradle, you only import Precure class

```groovy
import groovycure.Precure

println Precure.now()
```

You can execute groovycure in groovysh

```groovy
$ groovysh

groovy:000> :grab 'net.ligun:groovycure:1.1'
groovy:000> import groovycure.Precure
===> groovycure.Precure
groovy:000> Precure.now()
===> トロピカル～ジュ！プリキュア
```

## Release Note

### 1.1.2
* Supported Delicious-Party Precure

### 1.1.1
* Tropical-rouge Precure was over

### 1.1
* Fix the bug that library malfunction when Groovy version is less than 3.0.8
* Fix the bug that library malfunction when Java version is less than 15
* Delete standalone command function

### 1.0
* Support all to Tropical-rouge Precure
* Migrate configuration to ConfigSlurper
* Chane license
* Change package name
* Change repository to ManvenCentral

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
