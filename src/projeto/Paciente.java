package projeto;

public class Paciente {
    private String nome;
    private int id;
    private int idade;
    private String sintoma;

    private static int proximoId = 1; // o contador do id

    public Paciente(String nome, int idade, String sintoma){
        this.id = proximoId;
        proximoId++; //preparando id novo pro proximo paciente

        this.nome = nome;
        this.idade = idade;
        this.sintoma = sintoma;
    }

    public static int getProximoId() {
        return proximoId;
    }

    //metodos get

    public String getNome(){
        return nome;
    }

    public int getId(){
        return id;
    }

    public int getIdade(){
        return idade;
    }

    public String getSintoma(){
        return sintoma;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setIdade(int idade){
        this.idade = idade;
    }

    public void setSintoma(String sintoma){
        this.sintoma = sintoma;
    }

    public String exibirInfo(){
        return ("Id: " + this.getId() + "| nome: " + this.getNome()+ "| idade: " + this.getIdade()+"| sintoma: "+this.getSintoma());
    }

}
