public class Turma {

	// Caio Massao Guimaraes Hatano - RA: 201920718
	// Francisco Correa Neto - RA: 201920736
	
	int id;
	String dataIni;
	String turno;
	int capacidadeAlunos;
	
	public Turma() {
	}
	
	public Turma(int id, String dataIni, String turno, int capacidadeAlunos) {
		
		this.id = id;
		this.dataIni = dataIni;
		this.turno = turno;
		this.capacidadeAlunos = capacidadeAlunos;
		
	}
	
	public int getid() {
		return id;
	}
	
	public void setid(int id) {
		this.id = id;
	}
	
	public String getdataIni() {
		return dataIni;
	}
	
	public void setdataIni(String dataIni) {
		this.dataIni = dataIni;
	}
	
	public String getturno() {
		return turno;
	}
	
	public void setturno(String turno) {
		this.turno = turno;
	}
	
	public int getcapacidadeAlunos() {
		return capacidadeAlunos;
	}
	
	public void setcapacidadeAlunos(int capacidadeAlunos) {
		this.capacidadeAlunos = capacidadeAlunos;
	}

	
}