package com.concepts.elasticsearch.model;

import java.util.Collection;
import java.util.Date;
import java.util.HashSet;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonDeserialize(using = EmployeeDeserializer.class)
public class Employee {

    private Integer employeeId;
    private String firstName;
    private String lastName;
    private String designation;
    private Long salary;
    private Date joiningDate;
    private String address;
    private Gender gender;
    private Integer age;
    private MaritalStatus maritalStatus;
    private Collection<Project> projects;
    private Collection<String> interests;
    private Employee supervisor;

    private Employee(EmployeeBuilder builder) {
        super();
        employeeId = builder.employeeId;
        firstName = builder.firstName;
        lastName = builder.lastName;
        designation = builder.designation;
        salary = builder.salary;
        joiningDate = builder.joiningDate;
        address = builder.address;
        gender = builder.gender;
        age = builder.age;
        maritalStatus = builder.maritalStatus;
        projects = builder.projects;
        interests = builder.interests;
        supervisor = builder.supervisor;
    }

    @JsonProperty("employee_id")
    public Integer getEmployeeId() {
        return employeeId;
    }

    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    @JsonProperty("date_of_joining")
    @JsonSerialize(using = CustomDateSerializer.class)
    public Date getJoiningDate() {
        return joiningDate;
    }

    @JsonProperty("salary")
    public Long getSalary() {
        return salary;
    }

    @JsonProperty("designation")
    public String getDesignation() {
        return designation;
    }

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("gender")
    public Gender getGender() {
        return gender;
    }

    @JsonProperty("age")
    public Integer getAge() {
        return age;
    }

    @JsonProperty("marital_status")
    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    @JsonProperty("projects")
    public Collection<Project> getProjects() {
        return projects;
    }

    @JsonProperty("interests")
    public Collection<String> getInterests() {
        return interests;
    }

    @JsonProperty("supervisor")
    @JsonSerialize(using = SupervisorSerializer.class)
    public Employee getSupervisor() {
        return supervisor;
    }

    @Override
    public String toString() {
        return "Employee [employeeId=" + employeeId + ", firstName=" + firstName + ", lastName="
                + lastName + ", designation=" + designation + ", salary=" + salary
                + ", joiningDate=" + joiningDate + ", address=" + address + ", gender=" + gender
                + ", age=" + age + ", maritalStatus=" + maritalStatus + ", projects=" + projects
                + ", interests=" + interests + ", supervisor="
                + (supervisor != null ? supervisor.getFirstName() : null) + "]";
    }

    public static class EmployeeBuilder {

        private Integer employeeId;
        private String firstName;
        private String lastName;
        private String designation;
        private Long salary;
        private Date joiningDate;
        private String address;
        private Gender gender;
        private Integer age;
        private MaritalStatus maritalStatus;
        private Collection<Project> projects;
        private Collection<String> interests;
        private Employee supervisor;

        public EmployeeBuilder(Integer employeeId, String firstName, String lastName,
                String designation, String address, Gender gender, Integer age,
                MaritalStatus maritalStatus) {
            this.employeeId = employeeId;
            this.firstName = firstName;
            this.lastName = lastName;
            this.designation = designation;
            this.address = address;
            this.gender = gender;
            this.age = age;
            this.maritalStatus = maritalStatus;
        }

        public EmployeeBuilder joiningDate(Date joiningDate) {
            this.joiningDate = joiningDate;
            return this;
        }

        public EmployeeBuilder salary(Long salary) {
            this.salary = salary;
            return this;
        }

        public EmployeeBuilder projects(Collection<Project> projects) {
            this.projects = new HashSet<>(projects);
            return this;
        }

        public EmployeeBuilder interests(Collection<String> interests) {
            this.interests = new HashSet<>(interests);
            return this;
        }

        public EmployeeBuilder supervisor(Employee supervisor) {
            this.supervisor = supervisor;
            return this;
        }

        public Employee build() {
            return new Employee(this);
        }
    }

}
