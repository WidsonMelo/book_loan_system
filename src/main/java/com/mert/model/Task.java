package com.mert.model;

/**
 * Created by Yasin Mert on 25.02.2017.
 */
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "task")
public class Task implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String description;

	@Column(name = "dateCreated")
	private String dateCreated;

	@Column(name = "finished")
	private boolean finished;

	@Column(name = "userid")
	private int userid;
	
	@Column(name = "emprestado")
	private String emprestado;
	
	@Column(name = "editora")
	private String editora;
	
	@Column(name = "edicao")
	private String edicao;
	
	@Column(name = "isbn")
	private String isbn;
	
	@Column(name = "assunto")
	private String assunto;
	
	@Column(name = "idioma")
	private String idioma;
	
	@Column(name = "anopublicacao")
	private String anopublicacao;
	
	@OneToMany(mappedBy = "task")
	private Set<UserTask> userTask = new HashSet<UserTask>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmprestado() {
		return emprestado;
	}

	public void setEmprestado(String emprestado) {
		this.emprestado = emprestado;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getEdicao() {
		return edicao;
	}

	public void setEdicao(String edicao) {
		this.edicao = edicao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAssunto() {
		return assunto;
	}

	public void setAssunto(String assunto) {
		this.assunto = assunto;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}

	public String getAnopublicacao() {
		return anopublicacao;
	}

	public void setAnopublicacao(String anopublicacao) {
		this.anopublicacao = anopublicacao;
	}

	public Set<UserTask> getUserTask() {
		return userTask;
	}

	public void setUserTask(Set<UserTask> userTask) {
		this.userTask = userTask;
	}

}
