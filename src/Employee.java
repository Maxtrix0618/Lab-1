public class Employee implements Comparable<Employee> {
    private String name;
    private int age;

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {this.name = name;}
    public void setAge(int age) {this.age = age;}

    public String getName() {return name;}
    public int getAge() {return age;}

    @Override
    public String toString() {
        return (name + " | " + age);
    }

    @Override
    public int compareTo(Employee that) {
        return (Character.compare(this.name.charAt(0), that.name.charAt(0)));
    }



}
