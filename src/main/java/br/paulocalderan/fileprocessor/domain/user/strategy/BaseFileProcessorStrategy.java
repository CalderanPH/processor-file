package br.paulocalderan.fileprocessor.domain.user.strategy;

import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import br.paulocalderan.fileprocessor.exception.ProcessorError;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.PARSE_ERROR;

public abstract class BaseFileProcessorStrategy {

    protected List<UserDTO> parseFile(
            MultipartFile file,
            TypeReference<List<UserDTO>> typeReference,
            Object mapper,
            String source,
            String errorMessage) {
        try {
            List<UserDTO> users;
            if (mapper instanceof ObjectMapper) {
                users = ((ObjectMapper) mapper).readValue(file.getInputStream(), typeReference);
            } else if (mapper instanceof XmlMapper) {
                users = ((XmlMapper) mapper).readValue(file.getInputStream(), typeReference);
            } else {
                throw new ProcessorError(PARSE_ERROR);
            }

            users.forEach(user -> user.setSource(source));
            return users;
        } catch (Exception e) {
            throw new ProcessorError(errorMessage);
        }
    }
}
