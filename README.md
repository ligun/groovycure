# groovycure

All about Japanese battle heroine "Pretty Cure"

Inspired by [pycure](https://github.com/drillbits/pycure) & [rubicure](https://github.com/sue445/rubicure)

## Installation
```shell
git clone https://github.com/ligun/groovycure.git
cd ./groovycure
gradle install
```

## Usage
Run groovy command or groovyConsole
```groovy
@Grab('groovycure:groovycure')
import static groovycure.Precure.precure

precure.now()
```
Run groovysh
```groovy
> groovy.grape.Grape.grab(group:'groovycure',module:'groovycure')
> import grooycure.Precure
>
> Precure.precure.now()
```