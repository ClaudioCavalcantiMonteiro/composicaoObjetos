package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;
//tem duas associacoes e varios contratos
public class Worker {
	
	private String name;
	private WorkerLevel level;
	private Double baseSalary;
	//Associacoes
	private Department department;
	//Representando Lista dos contratos
	//Instanciando já na declaraçao do meu atributo
	private List<HourContract> contracts = new ArrayList<>();//composicao de objetos tem muitos, nao inclui (contracts)no construtor
	//inicia a sua lista vazia
	
	//construtor Padrao
	public Worker() {
	}
	//construtor com argumentos
	public Worker(String name, WorkerLevel level, Double baseSalary, Department department) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.department = department;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	public List<HourContract> getContracts() {
		return contracts;
	}
	/*Nao criaremos o( setContracts )porquea lista de contatos do trabalhador inicialmente vai ser instanciada como lista vazia,
	e depois eu vou poder adicionar e remover contratos nesta lista,so que de maneira alguma eu posso permitir que a lista seja trocada,
	nesse metodo set ele iria receber uma outra lista,e essa outra lista ta sendo atribuida a lista de contato de trabalhador, nao podemos
	deixar isso acontecer!! porisso nao criaremos setContracts.
	*/
	
	//Pega a lista de contrato e adiciona o contrato que veio com argumento
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	//remove o contrato informado dos contratos associados ao trabalhador
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	/*calcula quanto a pessoa vai ganhar baseando no ano e no mes
	 salario base mais o tanto que ele ganhou no contrato daquele mes soma-se
	*/
	public double income(int year, int month) {
		double sum = baseSalary;
		
		Calendar cal = Calendar.getInstance();
		//Percorre os contratos testando se e desse ano e desse mas se sim acrescenta na soma
		for (HourContract c : contracts) {
			//setando a data 
			cal.setTime(c.getDate());
			//Testa se o contrato e ref. ao mes e ano
			int c_year = cal.get(Calendar.YEAR);
			int c_month = 1 + cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.totalValue();
			}
		}
		return sum;
	}
}


