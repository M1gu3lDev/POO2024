package br.ufpb.amigo.secreto.miguel;

public class AmigoJaExisteException extends Exception {
    private  static  final long serialVersionUID = 1L;
    public AmigoJaExisteException(String msg){
        super(msg);
    }
}
