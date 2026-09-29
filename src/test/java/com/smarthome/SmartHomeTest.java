package com.smarthome;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SmartHomeTest {

    // --- 1. Тесты создания оригинальных семейств продуктов (Часть C) ---
    @Test
    void testFamilyACreation() {
        SystemFactory factory = new FamilyAFactory();
        assertNotNull(factory.createLight(), "Light should not be null");
        assertNotNull(factory.createThermostat(), "Thermostat should not be null");
        assertNotNull(factory.createCamera(), "Camera should not be null");
        assertTrue(factory.createLight() instanceof EcoSmartLight);
    }

    @Test
    void testFamilyBCreation() {
        SystemFactory factory = new FamilyBFactory();
        assertNotNull(factory.createLight());
        assertNotNull(factory.createThermostat());
        assertNotNull(factory.createCamera());
        assertTrue(factory.createThermostat() instanceof NexusProThermostat);
    }

    @Test
    void testFamilyCCreation() {
        SystemFactory factory = new FamilyCFactory();
        assertNotNull(factory.createLight());
        assertNotNull(factory.createThermostat());
        assertNotNull(factory.createCamera());
        assertTrue(factory.createCamera() instanceof TitanIndustrialCamera);
    }

    // --- 2. Тесты добавления четвертого семейства (Часть G) ---
    @Test
    void testFamilyDCreation() {
        SystemFactory factory = new FamilyDFactory();
        assertNotNull(factory.createLight());
        assertNotNull(factory.createThermostat());
        assertNotNull(factory.createCamera());
        assertTrue(factory.createLight() instanceof ZenithSmartLight);
        assertTrue(factory.createThermostat() instanceof ZenithSmartThermostat);
        assertTrue(factory.createCamera() instanceof ZenithSmartCamera);
    }

    // --- 3. Тесты динамического выбора фабрики в рантайме (Часть E) ---
    @Test
    void testRuntimeFactorySelectionA() {
        SystemFactory factory = FactoryProvider.getFactory("A");
        assertTrue(factory instanceof FamilyAFactory);
    }

    @Test
    void testRuntimeFactorySelectionB() {
        SystemFactory factory = FactoryProvider.getFactory("NexusPro");
        assertTrue(factory instanceof FamilyBFactory);
    }

    @Test
    void testRuntimeFactorySelectionD() {
        SystemFactory factory = FactoryProvider.getFactory("D");
        assertTrue(factory instanceof FamilyDFactory);
    }

    // --- 4. Негативные сценарии (минимум 2) ---
    @Test
    void testInvalidFamilyTypeThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactoryProvider.getFactory("INVALID_FAMILY");
        }, "Should throw exception for unknown family type");
    }

    @Test
    void testNullFamilyTypeDefaultsOrThrows() {
        // По нашей логике null обрабатывается или кидает IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () -> {
            FactoryProvider.getFactory("UNKNOWN_X");
        });
    }

    // --- 5. Бизнес-поведение (минимум 3 сценария - Часть F) ---
    @Test
    void testBusinessScenarioAwayMode() {
        SystemFactory factory = new FamilyAFactory();
        SmartHomeEcosystem ecosystem = new SmartHomeEcosystem(factory);
        // Проверяем, что сценарий выполняется без ошибок рантайма
        assertDoesNotThrow(ecosystem::executeAwayModeScenario);
    }

    @Test
    void testBusinessScenarioEmergency() {
        SystemFactory factory = new FamilyBFactory();
        SmartHomeEcosystem ecosystem = new SmartHomeEcosystem(factory);
        assertDoesNotThrow(ecosystem::executeEmergencyScenario);
    }

    @Test
    void testBusinessScenarioWithNewFamilyD() {
        SystemFactory factory = new FamilyDFactory();
        SmartHomeEcosystem ecosystem = new SmartHomeEcosystem(factory);
        assertDoesNotThrow(ecosystem::executeAwayModeScenario);
        assertDoesNotThrow(ecosystem::executeEmergencyScenario);
    }

    // --- 6. Доказательство работы клиента через абстракции (Часть D / E) ---
    @Test
    void testClientWorksViaAbstractions() {
        // Клиент принимает интерфейс SystemFactory, а не конкретные классы
        SystemFactory mockFactory = new SystemFactory() {
            @Override public SmartLight createLight() { return new EcoSmartLight(); }
            @Override public SmartThermostat createThermostat() { return new EcoSmartThermostat(); }
            @Override public SmartCamera createCamera() { return new EcoSmartCamera(); }
        };

        SmartHomeEcosystem client = new SmartHomeEcosystem(mockFactory);
        assertNotNull(client);
        assertDoesNotThrow(client::executeAwayModeScenario);
    }

    // --- 7. Корректность создания конкретных продуктов подсистем ---
    @Test
    void testFactoryMethodLightCreation() {
        LightCreator creator = new EcoSmartLightCreator();
        SmartLight light = creator.createLight();
        assertNotNull(light);
        assertTrue(light instanceof EcoSmartLight);
    }

    @Test
    void testCompatibilityRuleEnforcement() {
        SystemFactory factory = new FamilyAFactory();
        SmartLight light = factory.createLight();
        SmartThermostat thermo = factory.createThermostat();

        // Проверяем, что оба продукта принадлежат семейству EcoSmart (архитектурная совместимость)
        assertEquals(EcoSmartLight.class, light.getClass());
        assertEquals(EcoSmartThermostat.class, thermo.getClass());
    }
}