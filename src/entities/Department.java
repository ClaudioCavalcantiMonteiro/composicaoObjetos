package entities;
//Departamento do Trabalhador
public class Department {

	private String name;
	//construtor padrao vazio
	public Department() {
	}
	//construtor com argumentos
	public Department(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}


