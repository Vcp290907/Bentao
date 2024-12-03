package models;

public class Contato {
  private int id;
  private String nome;
  private String email;
  private String telefone;

  // Construtores
  public Contato() {
  }

  public Contato(String nome, String email, String telefone) {
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }

  public Contato(int id, String nome, String email, String telefone) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
  }

  // Getters e Setters
  public int getId() {
    return id;
  }

  // ID somente leitura, sem setter
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  // toString
  @Override
  public String toString() {
    return "Contato [id=" + id + ", nome=" + nome + ", email=" + email + ", telefone=" + telefone + "]";
  }
}
