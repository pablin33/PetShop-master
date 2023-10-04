package entidades;


public class Animal {

    private int id_animal;

    private String nome;

    private String raca;

    private int idade;

    private String especie;

    private String genero;



    public Animal(){

    }

    public Animal(int id_animal, String nome, String raca, int idade, String especie, String genero) {
        this.id_animal = id_animal;
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.especie = especie;
        this.genero = genero;
    }


    public int getId_animal() {
        return id_animal;
    }

    public void setId_animal(int id_animal) {
        this.id_animal = id_animal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

}
