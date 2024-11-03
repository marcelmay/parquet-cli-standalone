# parquet-cli-standalone

[![Apache License, Version 2.0, January 2004](https://img.shields.io/github/license/apache/maven.svg?label=License)][license]
[![Maven Central](https://img.shields.io/maven-central/v/de.m3y.parquet/parquet-cli-standalone.svg?style=flat-square)][maven_repo_search]
[![ci](https://github.com/marcelmay/parquet-cli-standalone/actions/workflows/ci.yml/badge.svg)](https://github.com/marcelmay/parquet-cli-standalone/actions/workflows/ci.yml)

Provides a standalone [Apache Parquet](https://parquet.apache.org/) [CLI JAR](https://github.com/apache/parquet-java/tree/master/parquet-cli) by including [required Hadoop dependencies](https://github.com/apache/parquet-java/tree/master/parquet-cli#running),  
for simple distribution and usage.

## Usage

See the [Apache Parquet CLI documentation](https://github.com/apache/parquet-java/tree/master/parquet-cli#help) for details on the CLI arguments.

```bash
# General
java -jar <JAR> <PARQUET CLI ARGS>
# Concrete example
java -jar target/parquet-cli-standalone-*-shaded.jar meta target/test-classes/part-m-00000.gz.parquet

File path:  target/test-classes/part-m-00000.gz.parquet
Created by: parquet-mr version 1.15.0-SNAPSHOT (build 73a4430af6c40f8eb246ad4911eb6d103c9a2abe)
Properties:
         pig.schema: name: chararray,age: chararray,gender: chararray
  writer.model.name: thrift
  thrift.descriptor: {
  "id" : "STRUCT",
  "children" : [ {
    "name" : "name",
    "fieldId" : 1,
    "requirement" : "REQUIRED",
    "type" : {
      "id" : "STRING",
      "logicalTypeAnnotation" : null,
      "binary" : false
    }

...

Schema:
message ParquetSchema {
  required binary name (STRING) = 1;
  optional binary age (STRING) = 2;
  optional binary gender (STRING) = 3;
}


Row group 0:  count: 3  92,33 B records  start: 4  total(compressed): 277 B total(uncompressed):181 B 
--------------------------------------------------------------------------------
        type      encodings count     avg size   nulls   min / max
name    BINARY    G   _     3         23,67 B    0       "Alice3" / "Charles3"
age     BINARY    G _ R     3         33,67 B    0       "average" / "average"
gender  BINARY    G _ R     3         35,00 B    0       "unavailable" / "unavailable"
```

[license]: https://www.apache.org/licenses/LICENSE-2.0
[maven_repo_search]: http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22de.m3y.parquet%22%20AND%20a%3A%22parquet-cli-standalone%22
