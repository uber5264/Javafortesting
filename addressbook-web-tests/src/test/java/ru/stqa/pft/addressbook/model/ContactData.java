package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firstName;
 // private final String middleName;
  private final String lastName;
  //private final String nickName;
  //private final String title;
  //private final String companyName;
  //private final String address;
  //private final String mobilePhone;
  //private final String email;
  //private final String homePage;
  //private final String bYear;
  //private final String bMonth;
  //private final String bDay;
  //private final String aDay;
  //private final String aMonth;
  //private final String aYear;
  private String group;


  public ContactData(String firstName, String lastName, String group) {
    this.firstName = firstName;
    //this.middleName = middleName;
    this.lastName = lastName;
    //this.nickName = nickName;
    // this.title = title;
    //this.companyName = companyName;
    //this.address = address;
    //this.mobilePhone = mobilePhone;
    //this.email = email;
    //this.homePage = homePage;
    //this.bYear = bYear;
    //this.bMonth = bMonth;
    //this.bDay = bDay;
    //this.aDay = aDay;
    //this.aMonth = aMonth;
    //this.aYear = aYear;
    this.group = group;
  }
  public String getFirstName() {
    return firstName;
  }

  //public String getMiddleName() {
  //  return middleName;
  //}

  public String getLastName() {
    return lastName;
  }

  //public String getNickName() {
  //  return nickName;
  //}

  //public String getTitle() {
  //  return title;
  //}

  //public String getCompanyName() {
  //  return companyName;
  //}

  //public String getAddress() {
  //  return address;
  //}

  //public String getMobilePhone() {
  //  return mobilePhone;
  //}

  //public String getEmail() {
  //  return email;
  //}

  //public String getHomePage() {
  //  return homePage;
  //}

  //public String getbYear() {
  //  return bYear;
  //}

  //public String getbMonth() {
  //  return bMonth;
  //}

  //public String getbDay() {
  //  return bDay;
  //}

  //public String getaDay() {
  //  return aDay;
  //}

  //public String getaMonth() {return aMonth; }

  //public String getaYear() {return aYear; }

  public String getGroup() {
    return group;
  }

}
