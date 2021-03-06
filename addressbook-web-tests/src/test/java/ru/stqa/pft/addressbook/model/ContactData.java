package ru.stqa.pft.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

// @XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class ContactData {
  @XStreamOmitField
  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "home")
  @Type(type = "text")
  private String homePhone;

  @Column(name = "mobile")
  @Type(type = "text")
  private String mobilePhone;

  @Column(name = "work")
  @Type(type = "text")
  private String workPhone;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  @Expose
  @Column(name = "firstname")
  private String firstName;
  @Expose
  @Column(name = "lastname")
  private String lastName;


  @Transient
  private String group;
  @Transient
  private String allPhones;
  @Transient
  private String email;
  @Transient
  private String email2;
  @Transient
  private String email3;
  @Transient
  private String allEmails;
  @Transient
  private String allAddress;
  @Transient
  private String address;
  @Transient
  private String address2;



  public ContactData withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

  public ContactData withAllAddress(String allAddress) {
    this.allAddress = allAddress;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }
  public ContactData withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withMobilePhone(String mobilePhone) {
    this.mobilePhone = mobilePhone;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return  this;
  }

  public File getPhoto() {return new File (photo);  }
  public String getMobilePhone() { return mobilePhone; }
  public String getHomePhone() { return homePhone; }
  public String getAllPhones() { return allPhones;  }
  public String getWorkPhone() { return workPhone; }
  public String getEmail() {    return email;  }
  public String getEmail2() { return email2;  }
  public String getEmail3() { return email3;  }
  public String getAllEmails() { return allEmails;  }
  public String getAllAddress() {return allAddress;  }
  public String getAddress() {return address;  }
  public String getAddress2() {return address2;  }

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
  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

}
