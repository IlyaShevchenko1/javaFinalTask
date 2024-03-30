package Homework6;

import Seminar6.Task3.Cat;

class Notebook {
    public String tradeMark;
    public double processorSequence;
    public double screenSize;
    public int ram;
    public int ssd;
    public String colour;
    public String system;



    @Override
    public String toString() {
        return "Производитель: " + tradeMark + "\n" + "Частота процессора: " + processorSequence + "\n" +
                "Диагональ экрана: " + screenSize + "\n" + "Оперативная память: " + ram + "\n" +
                "Объем памяти SSD: " + ssd + "\n" + "Цвет: " + colour + "\n" +
                "Операционная система: " + system + "\n" + "\n";
    }



}
