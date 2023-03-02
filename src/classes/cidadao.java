package classes;

public class cidadao {

    private String name;
    private String cpf;
    private String primeira;
    private String segunda;
    private String terceira;
    private String quarta;

    public cidadao(String name, String cpf, String primeira, String segunda, String terceira, String quarta) {
        this.name = name;
        this.cpf = cpf;
        this.primeira = primeira;
        this.segunda = segunda;
        this.terceira = terceira;
        this.quarta = quarta;
    }

    public cidadao() {

    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getPrimeira() {
        return primeira;
    }
    public void setPrimeira(String primeira) {
        this.primeira = primeira;
    }
    public String getSegunda() {
        return segunda;
    }
    public void setSegunda(String segunda) {
        this.segunda = segunda;
    }
    public String getTerceira() {
        return terceira;
    }
    public void setTerceira(String terceira) {
        this.terceira = terceira;
    }
    public String getQuarta() {
        return quarta;
    }
    public void setQuarta(String quarta) {
        this.quarta = quarta;
    }
    public String toString(){
        return String.format("Nome: %s%n",name)
                +String.format("CPF: %s%n", cpf)
                +String.format("1° dose: %s%n", primeira)
                +String.format("2° dose: %s%n", segunda)
                +String.format("3° dose: %s%n", terceira)
                +String.format("4° dose: %s%n", quarta);


    }
}
