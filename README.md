# parquet-cli-standalone

[![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/apache/maven.svg?label=License)][license]
[![Maven Central](https://img.shields.io/maven-central/v/de.m3y.parquet/parquet-cli-standalone.svg?style=flat-square)][maven_repo_search]
[![ci](https://github.com/marcelmay/parquet-cli-standalone/actions/workflows/ci.yml/badge.svg)](https://github.com/marcelmay/parquet-cli-standalone/actions/workflows/ci.yml)

Provides a standalone [Apache Parquet](https://parquet.apache.org/) [CLI JAR](https://github.com/apache/parquet-java/tree/master/parquet-cli) by including [required Hadoop dependencies](https://github.com/apache/parquet-java/tree/master/parquet-cli#running), for simple distribution and usage.

## Usage
```java -jar <JAR> <PARQUET CLI ARGS>```
See the [Apache Parquet CLI documentation](https://github.com/apache/parquet-java/tree/master/parquet-cli#help) for details on the CLI arguments.

[license]: https://www.apache.org/licenses/LICENSE-2.0
[maven_repo_search]: http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22de.m3y.parquet%22%20AND%20a%3A%22parquet-cli-standalone%22
