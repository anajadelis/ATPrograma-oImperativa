package atfinal;

public class Empregados {

    public String nome;
       public int salario;
       public String cargo;
       public int matricula;
       
       public Empregados(String nome, int salario, int matricula, String cargo){
           this.nome = nome;
           this.salario=salario;
           this.matricula=matricula;
           this.cargo=cargo;
       }
       
       
       public String getNome() {
           return nome;
           }

           public int getSalario() {
           return salario;
           }

           public String getCargo() {
           return cargo;
           }
           
           public int getMatricula() {
               return matricula;
               }
   }