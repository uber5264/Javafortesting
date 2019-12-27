package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {

  private int id;

  private final String firstName;
  private final String lastName;
  private String group;


  public ContactData(int id, String firstName, String lastName, String group) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
    this.group = group;
  }

  public ContactData( String firstName, String lastName, String group) {
    this.id = 0;
    this.firstName = firstName;
    this.lastName = lastName;
    this.group = group;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firstName, that.firstName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, firstName, lastName);
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public int getId() {
    return id;
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
  public void setId(int id) { this.id = id; }
}
