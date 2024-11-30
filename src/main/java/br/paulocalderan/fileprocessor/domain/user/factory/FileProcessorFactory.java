package br.paulocalderan.fileprocessor.domain.user.factory;

import br.paulocalderan.fileprocessor.domain.user.strategy.FileProcessorStrategy;
import br.paulocalderan.fileprocessor.exception.ProcessorError;
import org.springframework.stereotype.Component;

import java.util.Map;

import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.FORMAT_NOT_SUPPORTED;

@Component
public class FileProcessorFactory {

    private final Map<String, FileProcessorStrategy> strategies;

    public FileProcessorFactory(Map<String, FileProcessorStrategy> strategies) {
        this.strategies = strategies;
    }

    public FileProcessorStrategy getStrategy(String fileType) {
        FileProcessorStrategy strategy = strategies.get(fileType.toUpperCase());
        if (strategy == null) {
            throw new ProcessorError(String.format(FORMAT_NOT_SUPPORTED, fileType));
        }
        return strategy;
    }

}
