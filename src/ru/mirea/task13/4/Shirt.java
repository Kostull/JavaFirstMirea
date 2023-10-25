package ru.mirea.task13;

public class Shirt {
    private String itemCode;
    private String itemName;
    private String color;
    private String size;

    public Shirt(String itemCode, String itemName, String color, String size) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.color = color;
        this.size = size;
    }

    @Override
    public String toString() {
        return "Item Code: " + itemCode + "\n" +
                "Item Name: " + itemName + "\n" +
                "Color: " + color + "\n" +
                "Size: " + size + "\n";
    }

    public static void main(String[] args) {
        String[] shirtsData = {
                "S001,Black Polo Shirt,Black,XL",
                "S002,Black Polo Shirt,Black,L",
                "S003,Blue Polo Shirt,Blue,XL",
                "S004,Blue Polo Shirt,Blue,M",
                "S005,Tan Polo Shirt,Tan,XL",
                "S006,Black T-Shirt,Black,XL",
                "S007,White T-Shirt,White,XL",
                "S008,White T-Shirt,White,L",
                "S009,Green T-Shirt,Green,S",
                "S010,Orange T-Shirt,Orange,S",
                "S011,Maroon Polo Shirt,Maroon,S"
        };

        Shirt[] shirts = new Shirt[shirtsData.length];

        for (int i = 0; i < shirtsData.length; i++) {
            String[] shirtInfo = shirtsData[i].split(",");
            if (shirtInfo.length == 4) {
                shirts[i] = new Shirt(shirtInfo[0], shirtInfo[1], shirtInfo[2], shirtInfo[3]);
            }
        }

        for (Shirt shirt : shirts) {
            if (shirt != null) {
                System.out.println(shirt);
            }
        }
    }
}
