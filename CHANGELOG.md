# Changelog

All notable changes to this project will be documented in this file.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/),
and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Fixed

- build workflow

## [1.3.2-hub.1] - 2024-02-10

### Added

- maven build and scan
- Dockerfile
- docker publish workflow

### Removed

- maven wrapper

### Fixed

- initialization sql scripts

## [1.3.2] - 2023-12-27

### Changed

- fj-version set to 8.4.6
- fj-daogen-version set to 1.3.2
- spring-boot version set to 3.2.1

### Fixed

- LICENSE placeholder

## [1.3.1] - 2023-09-25

### Added

- att attribute 'jee-target-mode' with value 'jakarta' to [daogen-config](src/main/daogen/daogen-config.xml)
- att attribute 'jdk-target-versiov' with value '17' to [daogen-config](src/main/daogen/daogen-config.xml)

### Changed

- fj-daogen-version set to 1.3.1

### Removed

- removed dependency : javax - javaee-api
- github action workflows

## [1.3.0] - 2023-09-24

### Added

- [Code of conduct](https://github.com/fugerit-org/fj-universe/blob/main/CODE_OF_CONDUCT.md) badge.

### Changed

- fj-daogen-version set to 1.3.0
- spring-boot version set to 3.1.4

## [1.1.10] - 2023-09-05

### Added

- [workflow codeql on branch main](.github/workflows/codeql-analysis.yml)

### Changed

- fj-daogen-version set to 1.1.10
- changelog style based on : [https://github.com/olivierlacan/keep-a-changelog](https://github.com/olivierlacan/keep-a-changelog)
- updated documentation

## [1.1.5] - 2023-08-29

### Added

- fj-daogen-maven-plugin configuration

### Changed

- fj-daogen-version to 1.1.5
- fj-version to 8.2.0
- spring boot version to 3.1.3
- packaging type from war to default (jar)

## [0.4.4] - 2022-12-05

### Changed

- Now the quickstart run on spring boot only
- Java 17 is required

### Removed

* websphere liberty support
* daogen maven plugin sample
