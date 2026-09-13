package ru.br1ghtless.ap1_jv_t01.exercise10;

public class User {
  private String name;
  private int age;

  // конструктор
  public User(String name, int age) {
    this.name = name;
    this.age = age;
  }

  public String getName() {
    return this.name;
  }

  public int getAge() {
    return this.age;
  }
}
