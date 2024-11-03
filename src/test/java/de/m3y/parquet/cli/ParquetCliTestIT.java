package de.m3y.parquet.cli;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Smoke tests cli by invoking essential commands.
 */
public class ParquetCliTestIT {
    @Test
    public void testSimpleCommands() throws IOException, InterruptedException {
        Path cliJar = findCLiJar();
        for (String cmd : new String[]{
                "meta", "pages", "cat", "check-stats", "schema", "head",
                "column-index", "column-size", "footer", "scan"}) {
            Process proc = new ProcessBuilder().inheritIO()
                    .command("java", "-jar",
                            cliJar.toString(),
                            cmd,
                            cliJar.getParent().resolve("test-classes").resolve("part-m-00000.gz.parquet").toString())
                    .start();
            Assertions.assertEquals(proc.waitFor(), 0, "Command " + cmd + " should exit with success (0) instead of (" + proc.exitValue());
        }
    }

    private Path findCLiJar() throws IOException {
        final Pattern cliJarPattern = Pattern.compile(".*parquet-cli-standalone-.*-shaded\\.jar");
        try (final Stream<Path> targetFiles = Files.list(FileSystems.getDefault().getPath("target"))) {
            return targetFiles
                    .filter(path -> cliJarPattern.matcher(path.toString()).matches())
                    .findFirst().orElseThrow(IllegalStateException::new);
        }
    }
}
