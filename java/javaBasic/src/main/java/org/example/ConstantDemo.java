package org.example;

enum Fruit{
    APPLE("red"), PEACH("pink"), BANANA("yellow");
    private String color;

    Fruit(){
        System.out.println("Call constructor");
    }

    Fruit(String color) {
        this.color = color;
    }

    public static void main(String[] args) {
            Fruit type = Fruit.APPLE;
            switch(type){
                case APPLE:
                    System.out.println(57+" kcal"+ Fruit.APPLE.color);
                    break;
                case PEACH:
                    System.out.println(34+" kcal");
                    break;
                case BANANA:
                    System.out.println(93+" kcal");
                    break;
            }
        }
    }


