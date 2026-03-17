# Java Document Generator

## Overview
Java Document Generator is a powerful tool designed to automate the generation of documentation for Java applications. This tool analyzes your codebase and provides a comprehensive documentation output in various formats.

## Features
- **Automatic Documentation Generation**: Generate documentation based on your code comments and annotations.
- **Multi-Format Support**: Export documentation in formats like HTML, PDF, and Markdown.
- **Customizable Templates**: Use predefined templates or create your own.
- **Integration**: Easily integrate with CI/CD pipelines.

## Installation
To install Java Document Generator, follow these steps:

1. Clone the repository:
   ```bash
   git clone https://github.com/gunank/java-document-generator.git
   ```
2. Navigate to the directory:
   ```bash
   cd java-document-generator
   ```
3. Build the project using Maven:
   ```bash
   mvn clean install
   ```

## Configuration
To configure the Java Document Generator, modify the `config.properties` file located in the `src/main/resources` directory:

```properties
# Configuration for Java Document Generator
output.format=html
output.directory=docs/
template.path=templates/default
``` 

## API Endpoints

The following endpoints are available:

### Generate Documentation
- **Endpoint**: `/api/generate`
- **Method**: `POST`
- **Payload**:
  ```json
  {
      "sourcePath": "src/main/java",
      "outputFormat": "html"
  }
  ```
- **Responses**:
  - `200`: Documentation generated successfully.
  - `400`: Invalid request.

### Get Status
- **Endpoint**: `/api/status`
- **Method**: `GET`
- **Responses**:
  - `200`: Status of the last documentation generation.

## Usage Examples

### Basic Usage
To generate documentation from the command line:
```bash
java -jar java-document-generator.jar --src src/main/java --output docs/ --format html
```

### Using the API
You can also generate documentation via the API as shown below:

```bash
curl -X POST http://localhost:8080/api/generate \
     -H 'Content-Type: application/json' \
     -d '{"sourcePath":"src/main/java", "outputFormat":"html"}'
```

## Conclusion
Java Document Generator simplifies the process of creating and maintaining documentation for Java projects. With its rich feature set, you can ensure your projects are well-documented and easy to understand.