package br.paulocalderan.fileprocessor.exception;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionConstants {

    public static final String UPLOAD_ERROR = "Por favor, envie um arquivo para o upload!";
    public static final String FORMAT_NOT_SUPPORTED = "O formato do arquivo não é suportado: %s";

    public static final String CSV_ERROR = "Erro ao processar o arquivo no formato CSV.";
    public static final String JSON_ERROR = "Erro ao processar o arquivo no formato JSON.";
    public static final String XML_ERROR = "Erro ao processar o arquivo no formato XML.";
    public static final String JSON_FORMAT_ERROR = "Erro ao formatar os dados para JSON.";
    public static final String XML_FORMAT_ERROR = "Erro ao formatar os dados para XML.";

    public static final String PARSE_ERROR = "Não foi possível realizar o parse do arquivo.";
    public static final String INTERNAL_ERROR = "Erro interno ao processar o arquivo.";

}
