package br.paulocalderan.fileprocessor.domain.user.strategy;

import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface FileProcessorStrategy {

    /**
     * Processa os arquivos com base no formato
     *
     * @param file Deve informar o arquivo a ser processado eg. XML, JSON ou CSV
     * @return uma Lista de usuarios
     */
    List<UserDTO> processFile(MultipartFile file);

    /**
     * Formata os dados no formato especificado.
     *
     * @param userDTOS Os dados a serem formatados.
     * @param format   O formato desejado (JSON, XML ou CSV).
     * @return Uma String contendo os dados formatados.
     */
    String formatFile(List<UserDTO> userDTOS, String format);

}
