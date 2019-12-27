package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastName='" + lastName + '\'' +
            '}';
  }

  private final String firstName;
  private final String lastName;
  private String group;


  public ContactData(String firstName, String lastName, String group) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.group = group;
  }

  public String getFirstName() {
    return firstName;
  }
  public String getLastName() {
    return lastName;
  }
  public String getGroup() {
    return group;
  }

}
