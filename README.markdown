# Console Wars

[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](https://opensource.org/licenses/Apache-2.0)
![GitHub last commit](https://img.shields.io/github/last-commit/CarloMicieli/console-wars)

[![Micronaut JDBC CI](https://github.com/CarloMicieli/console-wars/actions/workflows/java-micronaut-jdbc-ci.yaml/badge.svg)](https://github.com/CarloMicieli/console-wars/actions/workflows/java-micronaut-jdbc-ci.yaml)
[![Spring MVC CI](https://github.com/CarloMicieli/console-wars/actions/workflows/java-spring-mvc-ci.yaml/badge.svg)](https://github.com/CarloMicieli/console-wars/actions/workflows/java-spring-mvc-ci.yaml)
[![Spring WebFlux CI](https://github.com/CarloMicieli/console-wars/actions/workflows/kotlin-spring-webflux-ci.yaml/badge.svg)](https://github.com/CarloMicieli/console-wars/actions/workflows/kotlin-spring-webflux-ci.yaml)

Implementing the same web api using different back-end technologies.

## Requirements

* Java 17 [sdkman.io/](https://sdkman.io/)
* Rust [rustup.rs/](https://rustup.rs/)
* Git
* Docker (and Docker Compose)

## The REST Api

The REST Api implements two endpoints:

* `platforms`: to manage game platforms (consoles)
* `games`: to manage games

More information are available [here](_http/README.markdown)

## How to run

```bash
  git clone https://github.com/CarloMicieli/console-wars.git
  cd console-wars
```

### Running a Postgres Database

```bash
  docker compose up postgres
```  

### Build the docker images

* `java-micronaut-jdbc`: `./gradlew java-micronaut-jdbc:dockerBuildNative`
* `java-spring-mvc`: `./gradlew java-spring-mvc:bootBuildImage`
* `kotlin-spring-webflux`: `./gradlew kotlin-spring-webflux:bootBuildImage`

### The Services

|        Service	         | Port number |
|:-----------------------:|:-----------:|
|  `java-micronaut-jdbc`  |    8000     | 
|    `java-spring-mvc`    |    8004     | 
| `kotlin-spring-webflux` |    8006     | 

## Conventional commits

This repository is following the conventional commits practice.

### Enforcing using git hooks

```bash
  chmod +x .githooks/commit-msg
  git config core.hooksPath .githooks
```

The hook itself can be found in `.githooks/commit-msg`.

### Using Commitizen

Install [commitizen](https://github.com/commitizen-tools/commitizen)

```bash
  pip install commitizen
```

and then just use it

```bash
  cz commit
```

## License

[Apache 2.0 License](https://choosealicense.com/licenses/apache-2.0/)

```
   Copyright 2023 Carlo Micieli

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
