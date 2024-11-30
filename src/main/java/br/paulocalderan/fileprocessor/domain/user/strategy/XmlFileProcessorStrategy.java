package br.paulocalderan.fileprocessor.domain.user.strategy;

import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import br.paulocalderan.fileprocessor.enums.FileFormat;
import br.paulocalderan.fileprocessor.exception.ProcessorError;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.XML_ERROR;
import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.XML_FORMAT_ERROR;
import static br.paulocalderan.fileprocessor.util.Constants.XML;

@AllArgsConstructor
@Component("XML")
public class XmlFileProcessorStrategy extends BaseFileProcessorStrategy implements FileProcessorStrategy {

    private final XmlMapper xmlMapper;

    @Override
    public List<UserDTO> processFile(MultipartFile file) {
        return parseFile(
                file,
                new TypeReference<>() {
                },
                xmlMapper,
                XML,
                XML_ERROR
        );
    }

    @Override
    public String formatFile(List<UserDTO> userDTOS, String format) {
        if (!FileFormat.XML.name().equalsIgnoreCase(format)) {
            throw new ProcessorError(XML_ERROR);
        }

        try {
            return xmlMapper.writeValueAsString(userDTOS);
        } catch (Exception e) {
            throw new ProcessorError(XML_FORMAT_ERROR);
        }
    }

}
