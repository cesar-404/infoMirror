package br.com.infomirror.util;

public class CPFUtils {

    public static String format(String cpf) {
        if (cpf == null || cpf.length() != 11) {
            throw new IllegalArgumentException("CPF inválido");
        }


        cpf = cpf.replace("\\D", "");

        return String.format("%03d.%03d.%03d-%02d",
                Integer.parseInt(cpf.substring(0, 3)),
                Integer.parseInt(cpf.substring(3, 6)),
                Integer.parseInt(cpf.substring(6, 9)),
                Integer.parseInt(cpf.substring(9, 11))
        );
    }
}
