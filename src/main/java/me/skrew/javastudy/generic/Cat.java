package me.skrew.javastudy.generic;

record Cat(String name) implements Pet<Mammal> {
    @Override
    public Mammal getType() {
        return new Mammal();
    }

    @Override
    public String getName() {
        return name;
    }
}