package com.smarthome;

// --- 1. PRODUCT INTERFACES ---
interface SmartLight {
    void turnOn();
    void applyBrightness(int level);
}

interface SmartThermostat {
    void setTemperature(int temp);
}

interface SmartCamera {
    void startRecording();
}

// --- 2. FAMILY A: EcoSmart ---
class EcoSmartLight implements SmartLight {
    @Override public void turnOn() { System.out.println("EcoSmart Light turned on in eco mode."); }
    @Override public void applyBrightness(int level) { System.out.println("EcoSmart Light brightness set to " + level + "%."); }
}

class EcoSmartThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("EcoSmart Thermostat temperature set to " + temp + "°C (energy saving)."); }
}

class EcoSmartCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("EcoSmart Camera recording in standard resolution."); }
}

// --- 3. FAMILY B: NexusPro ---
class NexusProLight implements SmartLight {
    @Override public void turnOn() { System.out.println("NexusPro Light turned on with RGB and Matter support."); }
    @Override public void applyBrightness(int level) { System.out.println("NexusPro Light precision brightness set to " + level + "%."); }
}

class NexusProThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("NexusPro Thermostat temperature set to " + temp + "°C (smart climate)."); }
}

class NexusProCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("NexusPro Camera recording in 4K with AI recognition."); }
}

// --- 4. FAMILY C: TitanIndustrial ---
class TitanIndustrialLight implements SmartLight {
    @Override public void turnOn() { System.out.println("TitanIndustrial Light turned on in emergency high-power mode."); }
    @Override public void applyBrightness(int level) { System.out.println("TitanIndustrial Light fixed output set to " + level + "%."); }
}

class TitanIndustrialThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("TitanIndustrial Thermostat temperature set to " + temp + "°C (industrial control)."); }
}

class TitanIndustrialCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("TitanIndustrial Camera recording securely 24/7."); }
}

// --- 5. ABSTRACT FACTORY & CONCRETE FACTORIES ---
interface SystemFactory {
    SmartLight createLight();
    SmartThermostat createThermostat();
    SmartCamera createCamera();
}

class FamilyAFactory implements SystemFactory {
    @Override public SmartLight createLight() { return new EcoSmartLight(); }
    @Override public SmartThermostat createThermostat() { return new EcoSmartThermostat(); }
    @Override public SmartCamera createCamera() { return new EcoSmartCamera(); }
}

class FamilyBFactory implements SystemFactory {
    @Override public SmartLight createLight() { return new NexusProLight(); }
    @Override public SmartThermostat createThermostat() { return new NexusProThermostat(); }
    @Override public SmartCamera createCamera() { return new NexusProCamera(); }
}

class FamilyCFactory implements SystemFactory {
    @Override public SmartLight createLight() { return new TitanIndustrialLight(); }
    @Override public SmartThermostat createThermostat() { return new TitanIndustrialThermostat(); }
    @Override public SmartCamera createCamera() { return new TitanIndustrialCamera(); }
}

// --- 6. RUNTIME FACTORY SELECTOR (Configuration / Resolver) ---
class FactoryProvider {
    public static SystemFactory getFactory(String familyType) {
        if (familyType == null) {
            familyType = "A"; // Дефолтное значение
        }
        switch (familyType.toUpperCase()) {
            case "A":
            case "ECOSMART":
                System.out.println("[Config] Selected Product Family: A (EcoSmart)");
                return new FamilyAFactory();
            case "B":
            case "NEXUSPRO":
                System.out.println("[Config] Selected Product Family: B (NexusPro)");
                return new FamilyBFactory();
            case "C":
            case "TITANINDUSTRIAL":
                System.out.println("[Config] Selected Product Family: C (TitanIndustrial)");
                return new FamilyCFactory();
            default:
                throw new IllegalArgumentException("Unknown product family type: " + familyType);
        }
    }
}

// --- 7. ECOSYSTEM CLIENT (Works only with abstractions) ---
class SmartHomeEcosystem {
    private final SmartLight light;
    private final SmartThermostat thermostat;
    private final SmartCamera camera;

    // Принимает абстрактную фабрику, не зная конкретного производителя
    public SmartHomeEcosystem(SystemFactory factory) {
        this.light = factory.createLight();
        this.thermostat = factory.createThermostat();
        this.camera = factory.createCamera();
    }

    public void runEcosystemTest() {
        System.out.println("[Ecosystem] Running diagnostic and startup sequence...");
        light.turnOn();
        light.applyBrightness(85);
        thermostat.setTemperature(22);
        camera.startRecording();
        System.out.println("[Ecosystem] All devices successfully synchronized!\n");
    }
}

// --- 8. CLIENT DEMO (Runtime selection via command-line arguments) ---
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO PART E: RUNTIME FACTory SELECTION ===\n");

        // Определяем семейство через аргументы командной строки или ставим "A" по умолчанию
        String familyArg = (args.length > 0) ? args[0] : "A";

        // Динамический выбор фабрики на старте программы
        SystemFactory selectedFactory = FactoryProvider.getFactory(familyArg);

        // Основная бизнес-логика работает только с абстракциями
        SmartHomeEcosystem ecosystem = new SmartHomeEcosystem(selectedFactory);
        ecosystem.runEcosystemTest();

        // Для демонстрации работы других семейств прямо из IDEA:
        if (args.length == 0) {
            System.out.println("--- Demo switching via config/runtime argument programmatically ---");
            SystemFactory factoryB = FactoryProvider.getFactory("B");
            new SmartHomeEcosystem(factoryB).runEcosystemTest();
        }
    }
}