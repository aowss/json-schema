ajv -s references/internal-ref-no-id.schema.json -d references/sample.json
ajv -s references/internal-ref-id.schema.json -d references/sample.json
ajv -s references/internal-ref-id-1.schema.json -d references/sample.json
ajv -s references/external-ref-primary-no-id.schema.json -r references/external-ref-linked-no-id.schema.json -d references/sample.json
ajv -s references/external-ref-primary-id.schema.json -r references/external-ref-linked-id.schema.json -d references/sample.json

java -jar ../samples/target/json-schema-cli.jar references/internal-ref-no-id.schema.json references/sample.json
java -jar ../samples/target/json-schema-cli.jar references/internal-ref-id.schema.json references/sample.json
java -jar ../samples/target/json-schema-cli.jar references/internal-ref-id-1.schema.json references/sample.json
java -jar ../samples/target/json-schema-cli.jar references/external-ref-primary-no-id.schema.json references/sample.json
java -jar ../samples/target/json-schema-cli.jar references/external-ref-primary-id.schema.json references/sample.json