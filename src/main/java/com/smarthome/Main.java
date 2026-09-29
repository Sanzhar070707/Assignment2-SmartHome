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
    @Override public void applyBrightness(int level) { System.out.println("  [EcoSmart Light] Яркость установлена на " + level + "% (сбережение энергии)."); }
    @Override public void triggerEmergencyLight() { System.out.println("  [EcoSmart Light] Аварийный маяк: плавное мигание белым светом."); }
}

class EcoSmartThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("  [EcoSmart Thermostat] Температура: " + temp + "°C."); }
    @Override public void enableEcoMode() { System.out.println("  [EcoSmart Thermostat] Эко-режим активирован: снижение до 18°C для экономии ресурсов."); }
    @Override public void shutDownForSafety() { System.out.println("  [EcoSmart Thermostat] Контроллер приостановлен в целях безопасности."); }
}

class EcoSmartCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("  [EcoSmart Camera] Запуск стандартной записи потока."); }
    @Override public void enableNightVision() { System.out.println("  [EcoSmart Camera] ИК-подсветка активирована (стандартный режим)."); }
    @Override public void lockdownRecording() { System.out.println("  [EcoSmart Camera] Сохранение резервной копии в облако EcoCloud."); }
}

// --- 3. FAMILY B: NexusPro ---
class NexusProLight implements SmartLight {
    @Override public void turnOn() { System.out.println("  [NexusPro Light] Плавная RGB-активация с поддержкой Matter."); }
    @Override public void applyBrightness(int level) { System.out.println("  [NexusPro Light] Точная кадровая настройка яркости: " + level + "%."); }
    @Override public void triggerEmergencyLight() { System.out.println("  [NexusPro Light] Экстренный режим: стробоскоп с изменением цвета (RGB Red Alert)."); }
}

class NexusProThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("  [NexusPro Thermostat] Климат-контроль настроен на " + temp + "°C с ИИ-балансировкой."); }
    @Override public void enableEcoMode() { System.out.println("  [NexusPro Thermostat] ИИ-экорежим: плавная адаптация под присутствие жильцов."); }
    @Override public void shutDownForSafety() { System.out.println("  [NexusPro Thermostat] Автоматическое перекрытие клапанов вентиляции."); }
}

class NexusProCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("  [NexusPro Camera] 4K запись с активным ИИ-распознаванием объектов."); }
    @Override public void enableNightVision() { System.out.println("  [NexusPro Camera] Сверхчувствительная матрица ночного видения включена."); }
    @Override public void lockdownRecording() { System.out.println("  [NexusPro Camera] Автономное шифрование архива и отправка пуш-уведомлений."); }
}

// --- 4. FAMILY C: TitanIndustrial ---
class TitanIndustrialLight implements SmartLight {
    @Override public void turnOn() { System.out.println("  [TitanIndustrial Light] Питание подано на промышленные прожекторы."); }
    @Override public void applyBrightness(int level) { System.out.println("  [TitanIndustrial Light] Фиксированный мощный выходной поток: " + level + "%."); }
    @Override public void triggerEmergencyLight() { System.out.println("  [TitanIndustrial Light] Промышленная тревога: включение ярких желтых маяков высокой мощности."); }
}

class TitanIndustrialThermostat implements SmartThermostat {
    @Override public void setTemperature(int temp) { System.out.println("  [TitanIndustrial Thermostat] Контроль тяжелой климатической установки: " + temp + "°C."); }
    @Override public void enableEcoMode() { System.out.println("  [TitanIndustrial Thermostat] Ночной промышленный режим: поддержка критической температуры."); }
    @Override public void shutDownForSafety() { System.out.println("  [TitanIndustrial Thermostat] Аварийный сброс давления и полное отключение контура."); }
}

class TitanIndustrialCamera implements SmartCamera {
    @Override public void startRecording() { System.out.println("  [TitanIndustrial Camera] Защищенная бронированная запись 24/7 (термостойкий корпус)."); }
    @Override public void enableNightVision() { System.out.println("  [TitanIndustrial Camera] Тепловизионное сканирование периметра активировано."); }
    @Override public void lockdownRecording() { System.out.println("  [TitanIndustrial Camera] Запись в защищенный черный ящик на объекте."); }
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

// --- 6. BUSINESS SCENARIOS (Collaborative interactions) ---
class SmartHomeEcosystem {
    private final SmartLight light;
    private final SmartThermostat thermostat;
    private final SmartCamera camera;

    public SmartHomeEcosystem(SystemFactory factory) {
        this.light = factory.createLight();
        this.thermostat = factory.createThermostat();
        this.camera = factory.createCamera();
    }

    // Сценарий 1: Режим "Ухожу из дома" (Away Mode)
    public void executeAwayModeScenario() {
        System.out.println("--- [Бизнес-сценарий 1] Активация режима: Ухожу из дома ---");
        light.applyBrightness(0); // Выключаем свет во всех комнатах
        thermostat.enableEcoMode(); // Переводим климат в режим энергосбережения
        camera.startRecording();    // Запускаем постоянное наблюдение
        camera.enableNightVision(); // Включаем ночное видение на случай темноты
        System.out.println("Система переведена в безопасный режим охраны.\n");
    }

    // Сценарий 2: Ночной режим (Night Security Mode)
    public void executeNightSecurityScenario() {
        System.out.println("--- [Бизнес-сценарий 2] Активация: Ночной режим ---");
        light.turnOn();
        light.applyBrightness(15);      // Мягкая подсветка-ночник
        thermostat.setTemperature(19);  // Комфортная прохладная температура для сна
        camera.enableNightVision();     // Активация ночного наблюдения за периметром
        System.out.println("Ночной режим успешно настроен.\n");
    }

    // Сценарий 3: Экстренная тревога / ЧП (Emergency Lockdown)
    public void executeEmergencyScenario() {
        System.out.println("--- [Бизнес-сценарий 3] ВНИМАНИЕ! Экстренная тревога ---");
        light.triggerEmergencyLight();  // Включение аварийного освещения семейства
        thermostat.shutDownForSafety(); // Отключение вентиляции/климата для предотвращения угрозы
        camera.lockdownRecording();     // Защищенное сохранение улик / черный ящик
        System.out.println("Протокол безопасности экосистемы выполнен.\n");
    }
}

// --- 7. RUNTIME SELECTION & CLIENT DEMO ---
public class Main {
    public static void main(String[] args) {
        System.out.println("=== DEMO PART F: BUSINESS SCENARIOS & COLLABORATION ===\n");

        // Выбираем семейство (например, NexusPro - Family B)
        SystemFactory factory = new FamilyBFactory();
        SmartHomeEcosystem ecosystem = new SmartHomeEcosystem(factory);

        // Запускаем совместные бизнес-сценарии
        ecosystem.executeAwayModeScenario();
        ecosystem.executeNightSecurityScenario();
        ecosystem.executeEmergencyScenario();
    }
}