package com.docmatter.ims.config.auxiliary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

class Json2JavaGenerationConfigTest {
    private Json2JavaGenerationConfig jsonToJavaConversion = new Json2JavaGenerationConfig();

    @Test
    void convertJsonToJavaClass() throws IOException {
        String packageName = "com.docmatter.ims.domain.setting";

        // load input JSON file
        String jsonPath = "src/main/resources/";
        File inputJson = new File(jsonPath + "prod/appsettings.json");

        // create the local directory for generating the Java Class file
        String outputPath = "src/main/java/com/docmatter/ims/domain/setting/";
        File outputJavaClassDirectory = new File(outputPath);

        String javaClassName = "AppSettings";

        jsonToJavaConversion.convertJsonToJavaClass(inputJson.toURI()
                .toURL(), outputJavaClassDirectory, packageName, javaClassName);

        File outputJavaClassPath = new File(outputPath + packageName.replace(".", "/"));
        Assertions.assertTrue(Arrays.stream(outputJavaClassPath.listFiles())
                .peek(System.out::println).anyMatch(file -> ("ActionSetting.java").equalsIgnoreCase(file.getName())));


    }
}


