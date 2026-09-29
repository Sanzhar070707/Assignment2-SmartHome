package com.smarthome;

// --- 1. PRODUCT INTERFACES (Интерфейсы трех типов продуктов) ---
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
    @Override public void turnOn() { System.out.println("EcoSmart Light: включено в эко-режиме."); }
    @Override public void applyBrightness(int level) { System.out.println("EcoSmart Light яркость: " + level + "%."); }
}

class EcoSmartThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("EcoSmart Thermostat температура: " + temp + "°C (энергосбережение)."); }
}

class EcoSmartCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("EcoSmart Camera: запись в стандартном разрешении."); }
}

// --- 3. FAMILY B: NexusPro ---
class NexusProLight implements SmartLight {
    @Override public void turnOn() { System.out.println("NexusPro Light: плавная RGB активация."); }
    @Override public void applyBrightness(int level) { System.out.println("NexusPro Light кадровая яркость: " + level + "%."); }
}

class NexusProThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("NexusPro Thermostat температура: " + temp + "°C (умный климат-контроль)."); }
}

class NexusProCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("NexusPro Camera: запись в 4K с ИИ-распознаванием."); }
}

// --- 4. FAMILY C: TitanIndustrial ---
class TitanIndustrialLight implements SmartLight {
    @Override public void turnOn() { System.out.println("TitanIndustrial Light: аварийный мощный режим."); }
    @Override public void applyBrightness(int level) { System.out.println("TitanIndustrial Light фиксация: " + level + "%."); }
}

class TitanIndustrialThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("TitanIndustrial Thermostat температура: " + temp + "°C (промышленный контроль)."); }
}

class TitanIndustrialCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("TitanIndustrial Camera: защищенная бронированная запись 24/7."); }
}

// --- 5. ABSTRACT FACTORY & CONCRETE FACTORIES (Абстрактная фабрика и семейства) ---
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

// --- 6. CLIENT DEMO (Точка входа) ---
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO PART C: ABSTRACT FACTORY ===\n");

        // Тестируем Семейство А (EcoSmart)
        System.out.println("--- Building Family A (EcoSmart) ---");
        SystemFactory factoryA = new FamilyAFactory();
        factoryA.createLight().turnOn();
        factoryA.createThermostat().setTemperature(20);
        factoryA.createCamera().startRecording();

        // Тестируем Семейство B (NexusPro)
        System.out.println("\n--- Building Family B (NexusPro) ---");
        SystemFactory factoryB = new FamilyBFactory();
        factoryB.createLight().turnOn();
        factoryB.createThermostat().setTemperature(22);
        factoryB.createCamera().startRecording();

        // Тестируем Семейство C (TitanIndustrial)
        System.out.println("\n--- Building Family C (TitanIndustrial) ---");
        SystemFactory factoryC = new FamilyCFactory();
        factoryC.createLight().turnOn();
        factoryC.createThermostat().setTemperature(18);
        factoryC.createCamera().startRecording();
    }
}