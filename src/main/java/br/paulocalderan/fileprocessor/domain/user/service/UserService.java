package br.paulocalderan.fileprocessor.domain.user.service;

import br.paulocalderan.fileprocessor.domain.user.dto.UserDTO;
import br.paulocalderan.fileprocessor.domain.user.factory.FileProcessorFactory;
import br.paulocalderan.fileprocessor.domain.user.repository.UserDataSource;
import br.paulocalderan.fileprocessor.domain.user.strategy.FileProcessorStrategy;
import br.paulocalderan.fileprocessor.enums.FileFormat;
import br.paulocalderan.fileprocessor.exception.ProcessorError;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Objects;

import static br.paulocalderan.fileprocessor.enums.FileFormat.getFileFormat;
import static br.paulocalderan.fileprocessor.enums.FileFormat.isFileFormat;
import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.FORMAT_NOT_SUPPORTED;
import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.INTERNAL_ERROR;

@Service
public class UserService {

    private final UserDataSource userDataSource;
    private final FileProcessorFactory fileProcessorFactory;

    public UserService(UserDataSource userDataSource, FileProcessorFactory fileProcessorFactory) {
        this.userDataSource = userDataSource;
        this.fileProcessorFactory = fileProcessorFactory;
    }

    public void processFile(MultipartFile file) {
        String fileFormat = getFileFormat(Objects.requireNonNull(file.getOriginalFilename()));
        FileProcessorStrategy strategy = fileProcessorFactory.getStrategy(fileFormat);
        List<UserDTO> userDTOS = strategy.processFile(file);

        if (userDTOS.isEmpty()) {
            throw new ProcessorError(INTERNAL_ERROR);
        }

        userDataSource.saveAll(userDTOS);
    }

    public String findAllUsers(String source) {
        if (source == null || source.isEmpty()) {
            source = FileFormat.JSON.name();
        }

        if (!isFileFormat(source)) {
            throw new ProcessorError(String.format(FORMAT_NOT_SUPPORTED, source));
        }

        List<UserDTO> users = userDataSource.fetchAllUser();
        FileProcessorStrategy strategy = fileProcessorFactory.getStrategy(source);
        return strategy.formatFile(users, source);
    }

}
