package com.smarthome;

// --- 1. PRODUCT INTERFACE (Интерфейс продукта) ---
interface SmartLight {
    void turnOn();
    void applyBrightness(int level);
}

// --- CONCRETE PRODUCTS (Конкретные продукты A, B, C) ---
class EcoSmartLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("EcoSmart Light turned on in eco mode.");
    }
    @Override
    public void applyBrightness(int level) {
        System.out.println("EcoSmart Light brightness set to " + level + "%.");
    }
}

class NexusProLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("NexusPro Light turned on with RGB and Matter support.");
    }
    @Override
    public void applyBrightness(int level) {
        System.out.println("NexusPro Light precision brightness set to " + level + "%.");
    }
}

class TitanIndustrialLight implements SmartLight {
    @Override
    public void turnOn() {
        System.out.println("TitanIndustrial Light turned on in emergency high-power mode.");
    }
    @Override
    public void applyBrightness(int level) {
        System.out.println("TitanIndustrial Light fixed output set to " + level + "%.");
    }
}

// --- 2. CREATOR (Абстрактный создатель с бизнес-логикой) ---
abstract class LightCreator {
    // Сам фабричный метод, который переопределяют подклассы
    public abstract SmartLight createLight();

    // Осмысленная бизнес-логика (требование инструкции: не просто return new)
    public void prepareAndInstallLight(int defaultBrightness) {
        System.out.println("[LOG] Initializing smart lighting installation...");
        SmartLight light = createLight(); // Создаем продукт через фабричный метод
        System.out.println("[LOG] Running system diagnostics...");
        light.turnOn();
        light.applyBrightness(defaultBrightness);
        System.out.println("[LOG] Lighting successfully configured and added to the control loop!\n");
    }
}

// --- CONCRETE CREATORS (Конкретные создатели A, B, C) ---
class EcoSmartLightCreator extends LightCreator {
    @Override
    public SmartLight createLight() {
        return new EcoSmartLight();
    }
}

class NexusProLightCreator extends LightCreator {
    @Override
    public SmartLight createLight() {
        return new NexusProLight();
    }
}

class TitanIndustrialLightCreator extends LightCreator {
    @Override
    public SmartLight createLight() {
        return new TitanIndustrialLight();
    }
}

// --- 3. CLIENT DEMO (Точка входа) ---
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO PART B: FACTORY METHOD ===\n");

        LightCreator ecoCreator = new EcoSmartLightCreator();
        ecoCreator.prepareAndInstallLight(75);

        LightCreator nexusCreator = new NexusProLightCreator();
        nexusCreator.prepareAndInstallLight(90);

        LightCreator titanCreator = new TitanIndustrialLightCreator();
        titanCreator.prepareAndInstallLight(100);
    }
}