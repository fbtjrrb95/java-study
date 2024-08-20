package me.skrew.javastudy.generic;

record Dog(String name) implements Pet<Mammal> {
    @Override
    public Mammal getType() {
        return new Mammal();
    }

    @Override
    public String getName() {
        return name;
    }
}
