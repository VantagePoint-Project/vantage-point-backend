package com.vantagepoint.backend.architecture;

import com.tngtech.archunit.core.importer.ImportOption;
import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.base.DescribedPredicate.alwaysTrue;
import static com.tngtech.archunit.core.domain.JavaClass.Predicates.resideInAPackage;
import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;
import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(
        packages = "com.vantagepoint.backend",
        importOptions = ImportOption.DoNotIncludeTests.class
)
public class HexagonalArchitectureTest {

    @ArchTest
    static final ArchRule shouldBeRespectedOnionArchitectureTest = onionArchitecture()
            .domainModels("..domain..model..")
            .domainServices("..domain..service..", "..domain..port..")
            .applicationServices("..application..")
            .adapter("web", "..infrastructure..adapter.in.web..")
            .adapter("persistence", "..infrastructure..adapter.out.persistence..")
            .adapter("outbound_services", "..infrastructure..adapter.out..")
            .ignoreDependency(
                    resideInAPackage("..infrastructure.common.config.."),
                    alwaysTrue()
            );

    @ArchTest
    static final ArchRule shouldNotDependOnSpringFrameworkDomainClassesTest =
            noClasses()
                    .that().resideInAPackage("..domain..")
                    .should().dependOnClassesThat().resideInAPackage("org.springframework..");

}
