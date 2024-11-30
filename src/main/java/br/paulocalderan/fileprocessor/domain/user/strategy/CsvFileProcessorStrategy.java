package br.paulocalderan.fileprocessor.domain.user.strategy;

import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import br.paulocalderan.fileprocessor.enums.FileFormat;
import br.paulocalderan.fileprocessor.exception.ProcessorError;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.CSV_ERROR;
import static br.paulocalderan.fileprocessor.util.Constants.CSV;

@Component("CSV")
class CsvFileProcessorStrategy implements FileProcessorStrategy {

    @Override
    public List<UserDTO> processFile(MultipartFile file) {
        List<UserDTO> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
            reader.lines().skip(1).forEach(line -> {
                String[] data = line.split(",");
                if (data.length == 2) {
                    users.add(
                            UserDTO.builder()
                                    .name(data[0].trim())
                                    .email(data[1].trim())
                                    .source(CSV)
                                    .build()
                    );
                }
            });
        } catch (Exception e) {
            throw new ProcessorError(CSV_ERROR);
        }
        return users;
    }

    @Override
    public String formatFile(List<UserDTO> userDTOS, String format) {
        if (!FileFormat.CSV.name().equalsIgnoreCase(format)) {
            throw new ProcessorError(CSV_ERROR);
        }

        StringBuilder csvBuilder = new StringBuilder();
        csvBuilder.append("name,email,source\n");

        for (UserDTO userDTO : userDTOS) {
            csvBuilder.append(userDTO.getName()).append(",")
                    .append(userDTO.getEmail()).append(",")
                    .append(userDTO.getSource()).append("\n");
        }
        return csvBuilder.toString();
    }
}

