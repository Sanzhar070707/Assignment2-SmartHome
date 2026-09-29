package com.smarthome;
// --- Продукты (Интерфейсы) ---
interface SmartLight {
    void turnOn();
}

interface SmartThermostat {
    void setTemperature(int temp);
}

interface SmartCamera {
    void startRecording();
}

// --- Семейство A: EcoSmart ---
class EcoSmartLight implements SmartLight {
    public void turnOn() { System.out.println("EcoSmart Light: включено в эко-режиме."); }
}
class EcoSmartThermostat implements SmartThermostat {
    public void setTemperature(int temp) { System.out.println("EcoSmart Thermostat: температура установлена на " + temp + "°C (энергосбережение)."); }
}
class EcoSmartCamera implements SmartCamera {
    public void startRecording() { System.out.println("EcoSmart Camera: запись в HD разрешении."); }
}

// --- Семейство B: NexusPro ---
class NexusProLight implements SmartLight {
    public void turnOn() { System.out.println("NexusPro Light: плавная активация с RGB подсветкой."); }
}
class NexusProThermostat implements SmartThermostat {
    public void setTemperature(int temp) { System.out.println("NexusPro Thermostat: точная климат-регулировка на " + temp + "°C."); }
}
class NexusProCamera implements SmartCamera {
    public void startRecording() { System.out.println("NexusPro Camera: 4K запись с ИИ-распознаванием."); }
}

// --- Семейство C: TitanIndustrial ---
class TitanIndustrialLight implements SmartLight {
    public void turnOn() { System.out.println("TitanIndustrial Light: аварийное яркое освещение."); }
}
class TitanIndustrialThermostat implements SmartThermostat {
    public void setTemperature(int temp) { System.out.println("TitanIndustrial Thermostat: усиленный режим для цеха, " + temp + "°C."); }
}
class TitanIndustrialCamera implements SmartCamera {
    public void startRecording() { System.out.println("TitanIndustrial Camera: защищенная бронированная запись 24/7."); }
}

// --- Клиентский код без фабрик ---
 class ClientWithoutFactories {
    public static void main(String[] args) {
        String platform = "A"; // Допустим, выбрали семейство A

        SmartLight light = null;
        SmartThermostat thermostat = null;
        SmartCamera camera = null;

        // ПРОБЛЕМА 2: Большой разросшийся if/else или switch для создания объектов
        if (platform.equals("A")) {
            light = new EcoSmartLight();
            thermostat = new EcoSmartThermostat();
            camera = new EcoSmartCamera();
        } else if (platform.equals("B")) {
            light = new NexusProLight();
            thermostat = new NexusProThermostat();
            camera = new NexusProCamera();
        } else if (platform.equals("C")) {
            light = new TitanIndustrialLight();
            thermostat = new TitanIndustrialThermostat();
            camera = new TitanIndustrialCamera();
        } else {
            throw new IllegalArgumentException("Неизвестная платформа!");
        }

        // ПРОБЛЕМА 3: Риск случайного смешивания несовместимых продуктов (Compatibility Risk)
        // Ничто не мешает разработчику написать вот так по ошибке:
        // SmartThermostat badThermostat = new TitanIndustrialThermostat();
        // и попытаться связать его с EcoSmartLight, что вызовет сбой протоколов.

        light.turnOn();
        thermostat.setTemperature(22);
        camera.startRecording();
    }
}