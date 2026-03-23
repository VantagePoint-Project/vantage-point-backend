package com.vantagepoint.backend.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.classes;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.methods;

@AnalyzeClasses(packages = "com.vantagepoint.backend")
public class NamingConventionTest {

    @ArchTest
    static final ArchRule shouldBeNamedWithTestSuffixTestClassesTest = classes()
            .that().resideInAPackage("..")
            .and().haveSimpleNameEndingWith("Test")
            .should().haveSimpleNameEndingWith("Test")
            .as("Las clases de prueba deben terminar en 'Test'");

    @ArchTest
    static final ArchRule shouldStartWithShouldPrefixTestMethodsTest = methods()
            .that().areAnnotatedWith(org.junit.jupiter.api.Test.class)
            .should().haveNameStartingWith("should")
            .andShould().haveNameEndingWith("Test")
            .as("Todos los métodos de prueba deben comenzar con el prefijo 'should'");
}
