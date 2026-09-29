package com.smarthome;

// --- 1. Products Interfaces ---
interface SmartLight {
    void turnOn();
    void applyBrightness(int level);
    void triggerEmergencyLight();
}

interface SmartThermostat {
    void setTemperature(int temp);
    void enableEcoMode();
    void shutDownForSafety();
}

interface SmartCamera {
    void startRecording();
    void enableNightVision();
    void lockdownRecording();
}

// --- 2. Concrete Products (Family A - EcoSmart) ---
class EcoSmartLight implements SmartLight {
    public void turnOn() { System.out.println("EcoSmart Light turned on."); }
    public void applyBrightness(int level) { System.out.println("EcoSmart Light brightness set to " + level + "%."); }
    public void triggerEmergencyLight() { System.out.println("EcoSmart Light flashing green for safety."); }
}

class EcoSmartThermostat implements SmartThermostat {
    public void setTemperature(int temp) { System.out.println("EcoSmart Thermostat set to " + temp + "°C."); }
    public void enableEcoMode() { System.out.println("EcoSmart Thermostat enabled eco mode."); }
    public void shutDownForSafety() { System.out.println("EcoSmart Thermostat safe shutdown."); }
}

class EcoSmartCamera implements SmartCamera {
    public void startRecording() { System.out.println("EcoSmart Camera recording started."); }
    public void enableNightVision() { System.out.println("EcoSmart Camera night vision ON."); }
    public void lockdownRecording() { System.out.println("EcoSmart Camera secured lockdown."); }
}

// --- Concrete Products (Family B - NexusPro) ---
class NexusProLight implements SmartLight {
    public void turnOn() { System.out.println("NexusPro Light powered up."); }
    public void applyBrightness(int level) { System.out.println("NexusPro Light lumens adjusted to " + level + "."); }
    public void triggerEmergencyLight() { System.out.println("NexusPro Light high-intensity strobe."); }
}

class NexusProThermostat implements SmartThermostat {
    public void setTemperature(int temp) { System.out.println("NexusPro Climate control set to " + temp + "°C."); }
    public void enableEcoMode() { System.out.println("NexusPro Climate power-save active."); }
    public void shutDownForSafety() { System.out.println("NexusPro Climate emergency halt."); }
}

class NexusProCamera implements SmartCamera {
    public void startRecording() { System.out.println("NexusPro Cam 4K recording."); }
    public void enableNightVision() { System.out.println("NexusPro Cam IR vision active."); }
    public void lockdownRecording() { System.out.println("NexusPro Cam cloud lockdown."); }
}

// --- Concrete Products (Family C - TitanIndustrial) ---
class TitanIndustrialLight implements SmartLight {
    public void turnOn() { System.out.println("Titan Industrial Light grid active."); }
    public void applyBrightness(int level) { System.out.println("Titan Light power output: " + level + "%."); }
    public void triggerEmergencyLight() { System.out.println("Titan Light industrial hazard beacon."); }
}

class TitanIndustrialThermostat implements SmartThermostat {
    public void setTemperature(int temp) { System.out.println("Titan HVAC core set to " + temp + "°C."); }
    public void enableEcoMode() { System.out.println("Titan HVAC energy regulation on."); }
    public void shutDownForSafety() { System.out.println("Titan HVAC thermal trip triggered."); }
}

class TitanIndustrialCamera implements SmartCamera {
    public void startRecording() { System.out.println("Titan Heavy Cam recording."); }
    public void enableNightVision() { System.out.println("Titan Heavy Cam thermal optics ON."); }
    public void lockdownRecording() { System.out.println("Titan Heavy Cam armored vault lock."); }
}

// --- Concrete Products (Family D - ZenithSmart - Added for Part G) ---
class ZenithSmartLight implements SmartLight {
    public void turnOn() { System.out.println("Zenith Smart Light activated smoothly."); }
    public void applyBrightness(int level) { System.out.println("Zenith Light ambient level: " + level + "."); }
    public void triggerEmergencyLight() { System.out.println("Zenith Light emergency pulse."); }
}

class ZenithSmartThermostat implements SmartThermostat {
    public void setTemperature(int temp) { System.out.println("Zenith Thermostat precise temp: " + temp + "°C."); }
    public void enableEcoMode() { System.out.println("Zenith Thermostat AI eco optimization."); }
    public void shutDownForSafety() { System.out.println("Zenith Thermostat safety bypass."); }
}

class ZenithSmartCamera implements SmartCamera {
    public void startRecording() { System.out.println("Zenith AI Camera recording feed."); }
    public void enableNightVision() { System.out.println("Zenith AI Camera stellar night mode."); }
    public void lockdownRecording() { System.out.println("Zenith AI Camera isolated lockdown."); }
}

// --- Abstract Factory Interface ---
interface SystemFactory {
    SmartLight createLight();
    SmartThermostat createThermostat();
    SmartCamera createCamera();
}

// --- Concrete Factories ---
class FamilyAFactory implements SystemFactory {
    public SmartLight createLight() { return new EcoSmartLight(); }
    public SmartThermostat createThermostat() { return new EcoSmartThermostat(); }
    public SmartCamera createCamera() { return new EcoSmartCamera(); }
}

class FamilyBFactory implements SystemFactory {
    public SmartLight createLight() { return new NexusProLight(); }
    public SmartThermostat createThermostat() { return new NexusProThermostat(); }
    public SmartCamera createCamera() { return new NexusProCamera(); }
}

class FamilyCFactory implements SystemFactory {
    public SmartLight createLight() { return new TitanIndustrialLight(); }
    public SmartThermostat createThermostat() { return new TitanIndustrialThermostat(); }
    public SmartCamera createCamera() { return new TitanIndustrialCamera(); }
}

class FamilyDFactory implements SystemFactory {
    public SmartLight createLight() { return new ZenithSmartLight(); }
    public SmartThermostat createThermostat() { return new ZenithSmartThermostat(); }
    public SmartCamera createCamera() { return new ZenithSmartCamera(); }
}

// --- Factory Method Component ---
abstract class LightCreator {
    public abstract SmartLight createLight();
    public void prepareAndInstallLight() {
        SmartLight light = createLight();
        light.turnOn();
        light.applyBrightness(80);
    }
}

class EcoSmartLightCreator extends LightCreator {
    public SmartLight createLight() { return new EcoSmartLight(); }
}

// --- Runtime Factory Provider (Part E) ---
class FactoryProvider {
    public static SystemFactory getFactory(String type) {
        if (type == null) {
            throw new IllegalArgumentException("Factory type cannot be null");
        }
        return switch (type.toUpperCase()) {
            case "A", "ECO" -> new FamilyAFactory();
            case "B", "NEXUS" -> new FamilyBFactory();
            case "C", "TITAN" -> new FamilyCFactory();
            case "D", "ZENITH" -> new FamilyDFactory();
            default -> throw new IllegalArgumentException("Unknown factory type: " + type);
        };
    }
}

// --- Client Class / Ecosystem (Part D & F) ---
class SmartHomeEcosystem {
    private final SmartLight light;
    private final SmartThermostat thermostat;
    private final SmartCamera camera;

    public SmartHomeEcosystem(SystemFactory factory) {
        this.light = factory.createLight();
        this.thermostat = factory.createThermostat();
        this.camera = factory.createCamera();
    }

    public void executeAwayModeScenario() {
        System.out.println("--- Executing Away Mode ---");
        light.turnOn();
        light.applyBrightness(20);
        thermostat.setTemperature(18);
        thermostat.enableEcoMode();
        camera.startRecording();
        camera.enableNightVision();
    }

    public void executeEmergencyScenario() {
        System.out.println("--- Executing Emergency Scenario ---");
        light.triggerEmergencyLight();
        thermostat.shutDownForSafety();
        camera.lockdownRecording();
        System.out.println();
    }
}

// --- Main Execution Class ---
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO PART G: ADDING NEW FAMILY D (ZENITH SMART) ===\n");

        // Тестируем новое четвертое семейство (Family D) без изменения бизнес-логики!
        SystemFactory factoryD = FactoryProvider.getFactory("D");
        SmartHomeEcosystem ecosystem = new SmartHomeEcosystem(factoryD);

        ecosystem.executeAwayModeScenario();
        ecosystem.executeEmergencyScenario();
    }
}