package com.company;

public class Main {

    private static void updateProgress(double percentage) {
        final int width = 50; // progress bar width in chars
        System.out.print("\r[");
        int i = 0;
        for (; i <= (int) (percentage * width); i++) {
            System.out.print(".");
        }
        for (; i < width; i++) {
            System.out.print(" ");
        }
        System.out.print("]");

        double filesize = 100 /*file.content.length()*/;
        double a = 0;
        double x = filesize / 10;

        while (x <= filesize){
            for (a : x){
                System.out.println();
                a++;
            }
            x += x;

        }
    }

    public static void main(String[] args) {
        try {
            for (double progressPercentage = 0.0; progressPercentage < 1.0; progressPercentage += 0.01) {
                updateProgress(progressPercentage);
                Thread.sleep(20);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


/*    public static void main(String[] args) {
        ChainHTable<String, String> table = new ChainHTable<>();



        try{
            while (true){
                System.out.print("");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        table.put("91", "единицы");
        table.put("92", "двойки");
        table.put("93", "тройки");
        table.put("94", "тройки");
        table.put("95", "тройки");
        table.put("96", "тройки");
        table.put("97", "тройки");
        table.put("98", "тройки");
        table.put("99", "тройки");
        table.remove("100");
        System.out.println(table.get("92"));

    }*/
}