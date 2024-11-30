package br.paulocalderan.fileprocessor.enums;

import br.paulocalderan.fileprocessor.exception.ProcessorError;

import java.util.Arrays;

import static br.paulocalderan.fileprocessor.exception.ExceptionConstants.FORMAT_NOT_SUPPORTED;

public enum FileFormat {

    CSV("csv"),
    JSON("json"),
    XML("xml");

    private final String extension;

    FileFormat(String extension) {
        this.extension = extension;
    }

    public static boolean isFileFormat(String source) {
        return Arrays.stream(values())
                .anyMatch(format -> format.extension.equalsIgnoreCase(source));
    }

    public static String getFileFormat(String filename) {
        String extension = filename.substring(filename.lastIndexOf('.') + 1).toLowerCase();

        return Arrays.stream(values())
                .filter(format -> format.extension.equalsIgnoreCase(extension))
                .findFirst()
                .orElseThrow(() -> new ProcessorError(String.format(FORMAT_NOT_SUPPORTED, extension)))
                .toString();
    }

}
