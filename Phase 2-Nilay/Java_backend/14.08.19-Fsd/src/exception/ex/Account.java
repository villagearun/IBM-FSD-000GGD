package exception.ex;

public class Account {
private String name;
private int salary;
public Account() {
	super();
}
public Account(String name, int salary) {
	super();
	this.name = name;
	this.salary = salary;
}
public void setName(String name) {
	this.name = name;
}
public void setSalary(int salary) {
	this.salary = salary;
}
public String getName() {
	return name;
}
public int getSalary() {
	return salary;
}
@Override
public String toString() {
	return "Name="+name+",Salary="+salary;
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((name == null) ? 0 : name.hashCode());
	result = prime * result + salary;
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Account other = (Account) obj;
	if (name == null) {
		if (other.name != null)
			return false;
	} else if (!name.equals(other.name))
		return false;
	if (salary != other.salary)
		return false;
	return true;
}
}
