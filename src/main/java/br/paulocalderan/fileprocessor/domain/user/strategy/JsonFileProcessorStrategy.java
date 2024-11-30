package br.paulocalderan.fileprocessor.domain.user.strategy;

import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import br.paulocalderan.fileprocessor.enums.FileFormat;
import br.paulocalderan.fileprocessor.exception.ProcessorError;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.JSON_ERROR;
import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.JSON_FORMAT_ERROR;
import static br.paulocalderan.fileprocessor.util.Constants.JSON;

@AllArgsConstructor
@Component("JSON")
public class JsonFileProcessorStrategy extends BaseFileProcessorStrategy implements FileProcessorStrategy {

    private final ObjectMapper objectMapper;

    @Override
    public List<UserDTO> processFile(MultipartFile file) {
        return parseFile(
                file,
                new TypeReference<>() {
                },
                objectMapper,
                JSON,
                JSON_ERROR
        );
    }

    @Override
    public String formatFile(List<UserDTO> userDTOS, String format) {
        if (!FileFormat.JSON.name().equalsIgnoreCase(format)) {
            throw new ProcessorError(JSON_ERROR);
        }

        try {
            return objectMapper.writeValueAsString(userDTOS);
        } catch (JsonProcessingException e) {
            throw new ProcessorError(JSON_FORMAT_ERROR);
        }
    }
}
