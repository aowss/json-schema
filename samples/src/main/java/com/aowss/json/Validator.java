package com.aowss.json;

import org.everit.json.schema.ValidationException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.everit.json.schema.Schema;
import org.everit.json.schema.loader.SchemaLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class Validator {

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            System.err.println("Usage : java com.aowss.json.Validator schemaPath instancePath");
        }
        try {
            Optional<List<? extends Exception>> validationErrors = validate(args[0], args[1]);
            if (validationErrors.isPresent()) {
                System.out.println(args[1] + " is INVALID with respect to " + args[0] + " : \n" + validationErrors.get());
            } else {
                System.out.println(args[1] + " is valid with respect to " + args[0]);
            }
        } catch (Exception e) {
            System.out.println("An error occured while validating " + args[1] + " with respect to " + args[0] + " : " + getRootCauseMessage.apply(e));
        }
    }

    public static Optional<List<? extends Exception>> validate(String schemaPath, String instancePath) throws IOException {
//        try (InputStream schemaInputStream = Validator.class.getResourceAsStream(schemaPath); InputStream instanceInputStream = Validator.class.getResourceAsStream(instancePath)) {
        try (Reader schemaInputStream = Files.newBufferedReader(Paths.get(schemaPath), StandardCharsets.UTF_8); Reader instanceInputStream = Files.newBufferedReader(Paths.get(instancePath), StandardCharsets.UTF_8)) {
            JSONObject rawSchema = new JSONObject(new JSONTokener(schemaInputStream));
            JSONObject rawInstance = new JSONObject(new JSONTokener(instanceInputStream));
            Schema schema = SchemaLoader.load(rawSchema);
            schema.validate(rawInstance);
            return Optional.empty();
        } catch (ValidationException ve) {
            List<ValidationException> exceptions = ve.getCausingExceptions();
            if (exceptions == null || exceptions.size() == 0) {
                return Optional.empty();
            } else {
                return Optional.<List<? extends Exception>>of(exceptions);
            }
        }
    }

    public static final Function<Throwable,String> getRootCauseMessage = e -> e.getCause() != null ? Validator.getRootCauseMessage.apply(e.getCause()) : e.getMessage();

}
