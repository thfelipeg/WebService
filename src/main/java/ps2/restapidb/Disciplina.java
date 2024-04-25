package ps2.restapidb;

import javax.persistence.*;

@Entity
@Table(name="disciplinas")
public class Disciplina {
    @Id @GeneratedValue
	private long id;
    private String nome;
    private String codigo;
    private int cargaHoraria;

    public Disciplina() {
		super();
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCargaHoraria() {
		return cargaHoraria;
	}
	public void setArea(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

}
