package com.fbatista.codigoafonso;

public class Palavra {

    public static final String TYPE_VERBO = "verbo";
    public static final String TYPE_VERBO_PRIMEIRA_PESSOA = "verboPrimeiraPessoa";
    public static final String TYPE_PREPOSICAO = "preposicao";
    public static final String NO_TYPE = "semTipo";
    public static final char[] LETRAS_FOO = { 's', 'l', 'f', 'w', 'k'};


    private String texto;
    private String tipo;

    public Palavra(String texto){
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    private void definirTipo() {

        //Caso seja um verbo, uma nova verificação é feita para verificar se este está na primeira pessoa
        if(isVerbo()) {
            if(isVerboPrimeiraPessoa())
                tipo = TYPE_VERBO_PRIMEIRA_PESSOA;
            else
                tipo = TYPE_VERBO;

        } else if(isPreposicao()) {
            tipo = TYPE_PREPOSICAO;
        } else {
            tipo = NO_TYPE;
        }
    }

    private Boolean isVerbo() {
        String ultimaLetra = texto.substring(texto.length() - 1);
        texto = texto.toLowerCase();
        if(texto.length() >= 8) {
            for (char letraFoo : LETRAS_FOO) {
                if(ultimaLetra.equals(letraFoo))
                    return true;
            }
        }
        return false;
    }

    private Boolean isVerboPrimeiraPessoa() {
        String primeiraLetra = texto.substring(texto.length() - 1);
        texto = texto.toLowerCase();
        if(texto.length() >=8) {
            for(char letraFoo : LETRAS_FOO) {
                if(!primeiraLetra.equals(letraFoo))
                    return true;
            }
        }
        return false;
    }

    private Boolean isPreposicao() {
        String ultimaLetra = texto.substring(texto.length() - 1);
        texto = texto.toLowerCase();
        if(texto.length() == 3) {
            for(char letraFoo : LETRAS_FOO) {
                if(!ultimaLetra.equals(letraFoo) && !ultimaLetra.equals('d') && !ultimaLetra.equals('D'))
                    return true;
            }
        }
        return false;
    }


}
