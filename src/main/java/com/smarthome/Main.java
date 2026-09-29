package com.smarthome;

// --- 1. PRODUCT INTERFACES ---
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

// --- 2. FAMILY A: EcoSmart ---
class EcoSmartLight implements SmartLight {
    @Override public void turnOn() { System.out.println("  [EcoSmart Light] Включено в эко-режиме."); }
    @Override public void applyBrightness(int level) { System.out.println("  [EcoSmart Light] Яркость: " + level + "%."); }
    @Override public void triggerEmergencyLight() { System.out.println("  [EcoSmart Light] Аварийный маяк: плавное мигание."); }
}

class EcoSmartThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("  [EcoSmart Thermostat] Температура: " + temp + "°C."); }
    @Override public void enableEcoMode() { System.out.println("  [EcoSmart Thermostat] Эко-режим: 18°C."); }
    @Override public void shutDownForSafety() { System.out.println("  [EcoSmart Thermostat] Приостановка контура."); }
}

class EcoSmartCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("  [EcoSmart Camera] Стандартная запись."); }
    @Override public void enableNightVision() { System.out.println("  [EcoSmart Camera] ИК-подсветка включена."); }
    @Override public void lockdownRecording() { System.out.println("  [EcoSmart Camera] Резервная копия в облако."); }
}

// --- 3. FAMILY B: NexusPro ---
class NexusProLight implements SmartLight {
    @Override public void turnOn() { System.out.println("  [NexusPro Light] RGB-активация."); }
    @Override public void applyBrightness(int level) { System.out.println("  [NexusPro Light] Точная яркость: " + level + "%."); }
    @Override public void triggerEmergencyLight() { System.out.println("  [NexusPro Light] Экстренный стробоскоп."); }
}

class NexusProThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("  [NexusPro Thermostat] Климат-контроль: " + temp + "°C."); }
    @Override public void enableEcoMode() { System.out.println("  [NexusPro Thermostat] ИИ-экорежим активирован."); }
    @Override public void shutDownForSafety() { System.out.println("  [NexusPro Thermostat] Перекрытие клапанов."); }
}

class NexusProCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("  [NexusPro Camera] 4K запись с ИИ."); }
    @Override public void enableNightVision() { System.out.println("  [NexusPro Camera] Матрица ночного видения активна."); }
    @Override public void lockdownRecording() { System.out.println("  [NexusPro Camera] Шифрование и пуш-уведомления."); }
}

// --- 4. FAMILY C: TitanIndustrial ---
class TitanIndustrialLight implements SmartLight {
    @Override public void turnOn() { System.out.println("  [TitanIndustrial Light] Промышленные прожекторы."); }
    @Override public void applyBrightness(int level) { System.out.println("  [TitanIndustrial Light] Мощный поток: " + level + "%."); }
    @Override public void triggerEmergencyLight() { System.out.println("  [TitanIndustrial Light] Желтые маяки высокой мощности."); }
}

class TitanIndustrialThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("  [TitanIndustrial Thermostat] Тяжелый климат: " + temp + "°C."); }
    @Override public void enableEcoMode() { System.out.println("  [TitanIndustrial Thermostat] Поддержка критической температуры."); }
    @Override public void shutDownForSafety() { System.out.println("  [TitanIndustrial Thermostat] Сброс давления."); }
}

class TitanIndustrialCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("  [TitanIndustrial Camera] Бронированная запись 24/7."); }
    @Override public void enableNightVision() { System.out.println("  [TitanIndustrial Camera] Тепловизор включен."); }
    @Override public void lockdownRecording() { System.out.println("  [TitanIndustrial Camera] Запись в черный ящик."); }
}

// --- 5. NEW FAMILY D: ZenithSmart (Добавлено по Части G) ---
class ZenithSmartLight implements SmartLight {
    @Override public void turnOn() { System.out.println("  [ZenithSmart Light] Квантовая подсветка активирована."); }
    @Override public void applyBrightness(int level) { System.out.println("  [ZenithSmart Light] Ультра-точная яркость: " + level + "%."); }
    @Override public void triggerEmergencyLight() { System.out.println("  [ZenithSmart Light] Квантовый аварийный маяк ультравысокой яркости."); }
}

class ZenithSmartThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("  [ZenithSmart Thermostat] Квантовый термостат: " + temp + "°C."); }
    @Override public void enableEcoMode() { System.out.println("  [ZenithSmart Thermostat] Зеленый квантовый режим энергосбережения."); }
    @Override public void shutDownForSafety() { System.out.println("  [ZenithSmart Thermostat] Мгновенное квантовое блокирование контура."); }
}

class ZenithSmartCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("  [ZenithSmart Camera] 8K голографическая запись потока."); }
    @Override public void enableNightVision() { System.out.println("  [ZenithSmart Camera] Квантовое ночное видение без потерь света."); }
    @Override public void lockdownRecording() { System.out.println("  [ZenithSmart Camera] Синхронизация с защищенным квантовым сервером."); }
}

// --- 6. ABSTRACT FACTORY & CONCRETE FACTORIES (Включая Family D) ---
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

class FamilyDFactory implements SystemFactory {
    @Override public SmartLight createLight() { return new ZenithSmartLight(); }
    @Override public SmartThermostat createThermostat() { return new ZenithSmartThermostat(); }
    @Override public SmartCamera createCamera() { return new ZenithSmartCamera(); }
}

// --- 7. FACTORY PROVIDER (Расширен для поддержки D) ---
class FactoryProvider {
    public static SystemFactory getFactory(String familyType) {
        if (familyType == null) familyType = "A";
        switch (familyType.toUpperCase()) {
            case "A": case "ECOSMART":
                System.out.println("[Config] Selected Family: A (EcoSmart)");
                return new FamilyAFactory();
            case "B": case "NEXUSPRO":
                System.out.println("[Config] Selected Family: B (NexusPro)");
                return new FamilyBFactory();
            case "C": case "TITANINDUSTRIAL":
                System.out.println("[Config] Selected Family: C (TitanIndustrial)");
                return new FamilyCFactory();
            case "D": case "ZENITHSMART":
                System.out.println("[Config] Selected Family: D (ZenithSmart)");
                return new FamilyDFactory();
            default:
                throw new IllegalArgumentException("Unknown family type: " + familyType);
        }
    }
}

// --- 8. BUSINESS SCENARIOS ---
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
        System.out.println("--- [Сценарий] Режим: Ухожу из дома ---");
        light.applyBrightness(0);
        thermostat.enableEcoMode();
        camera.startRecording();
        camera.enableNightVision();
        System.out.println();
    }

    public void executeEmergencyScenario() {
        System.out.println("--- [Сценарий] ВНИМАНИЕ! Экстренная тревога ---");
        light.triggerEmergencyLight();
        thermostat.shutDownForSafety();
        camera.lockdownRecording();
        System.out.println();
    }
}

// --- 9. CLIENT DEMO ---
public class Main {
    public static main(String[] args) {
        System.out.println("=== DEMO PART G: ADDING NEW FAMILY D (ZENITH SMART) ===\n");

        // Тестируем новое четвертое семейство (Family D) без изменения бизнес-логики!
        SystemFactory factoryD = FactoryProvider.getFactory("D");
        SmartHomeEcosystem ecosystem = new SmartHomeEcosystem(factoryD);

        ecosystem.executeAwayModeScenario();
        ecosystem.executeEmergencyScenario();
    }
}