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

// --- 6. ARCHITECTURAL ENFORCEMENT (Client encapsulates family consistency) ---
class SmartHomeEcosystem {
    private final SmartLight light;
    private final SmartThermostat thermostat;
    private final SmartCamera camera;

    // Dependency injection of the factory guarantees 100% compatible product family
    public SmartHomeEcosystem(SystemFactory factory) {
        this.light = factory.createLight();
        this.thermostat = factory.createThermostat();
        this.camera = factory.createCamera();
    }

    public void runEcosystemTest() {
        light.turnOn();
        light.applyBrightness(80);
        thermostat.setTemperature(21);
        camera.startRecording();
    }
}

// --- 7. CLIENT DEMO ---
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO PART D: COMPATIBILITY RULE (BY DESIGN) ===\n");

        System.out.println("Initializing EcoSmart Ecosystem (Family A):");
        SmartHomeEcosystem ecoSystem = new SmartHomeEcosystem(new FamilyAFactory());
        ecoSystem.runEcosystemTest();

        System.out.println("\nInitializing NexusPro Ecosystem (Family B):");
        SmartHomeEcosystem nexusSystem = new SmartHomeEcosystem(new FamilyBFactory());
        nexusSystem.runEcosystemTest();
    }
}