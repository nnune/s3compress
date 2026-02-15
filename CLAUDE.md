# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

Spring Boot application for compressing and uploading files to S3 with streaming support. The project focuses on memory-efficient compression using Snappy algorithm with multipart S3 uploads.

**Key Goals:**
- Stream-based compression/decompression (avoid loading entire files into memory)
- Backward compatibility with `Snappy.compress()` byte array format
- Multipart upload support for large files
- Performance measurement (memory usage and throughput)

## Build & Development Commands

### Build
```bash
./gradlew build
```

### Run Application
```bash
./gradlew bootRun
```

### Run Tests
```bash
./gradlew test
```

### Run Single Test
```bash
./gradlew test --tests ClassName
./gradlew test --tests ClassName.methodName
```

### Clean Build
```bash
./gradlew clean build
```

## Project Structure

**Package:** `com.example.snappycompressstreams3`

### Architecture Layers

1. **Controller Layer** (`controller/compressS3.java`)
   - REST endpoints for S3 operations
   - Path pattern: `/{bucket}/{key}`
   - Three compression modes:
     - `POST /{bucket}/{key}/compress-streaming` - Stream-based compression
     - `POST /{bucket}/{key}/compress` - Non-streaming compression
     - `POST /{bucket}/{key}` - No compression upload
   - `GET /{bucket}/{key}` - Download with streaming decompression

2. **Compression Layer** (`compression/CCSnappy.java`)
   - `compress()` - Stream-based compression using `SnappyOutputStream`
   - `compressByteArray()` - Byte array compression using `Snappy.compress()` for backward compatibility
   - All methods use `@SneakyThrows` for exception handling

### Technology Stack

- **Framework:** Spring Boot 3.1.4 (Java 17)
- **Compression:** Xerial Snappy Java 1.1.10.3
- **AWS:** Spring Cloud AWS S3 Starter 3.0.0-RC2, AWS SDK S3 2.20.109
- **Utilities:** Commons IO 2.13.0, Lombok
- **Monitoring:** Spring Actuator with Prometheus metrics
- **Testing:** JUnit 5, Testcontainers

## Implementation Notes

### Streaming vs Non-Streaming Compression

The project distinguishes between two compression approaches:
- **Streaming:** Uses `SnappyOutputStream` wrapping the output stream, processes data in chunks
- **Non-streaming:** Uses `Snappy.compress()` on full byte arrays, loads entire content into memory

The streaming approach is preferred for large files to minimize memory footprint.

### AWS S3 Integration

Uses AWS SDK with CRT (Common Runtime) for optimized multipart upload performance. The Spring Cloud AWS starter provides S3 template abstraction.

### Metrics & Monitoring

Prometheus metrics are available via Spring Actuator for monitoring compression performance and memory usage.
