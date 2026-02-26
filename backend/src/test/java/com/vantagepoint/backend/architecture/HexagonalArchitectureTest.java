package com.vantagepoint.backend.architecture;

import com.tngtech.archunit.junit.AnalyzeClasses;
import com.tngtech.archunit.junit.ArchTest;
import com.tngtech.archunit.lang.ArchRule;

import static com.tngtech.archunit.library.Architectures.onionArchitecture;

@AnalyzeClasses(packages = "com.vantagepoint.backend")
public class HexagonalArchitectureTest {

    @ArchTest
    static final ArchRule onion_architecture_is_respected = onionArchitecture()
            .domainModels("..domain..model..")
            .domainServices("..domain..service..", "..domain..port..")
            .applicationServices("..application..")
            .adapter("web", "..infrastructure..adapter.in.web..")
            .adapter("persistence", "..infrastructure..adapter.out.persistence..");
}
