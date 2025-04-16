package br.senac.tads.dsw.exemplo.rest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/pessoas/imagens")
public class UploadController {

    @PostMapping("/upload")
    public ResponseEntity<?> uploadArquivo(@RequestParam MultipartFile arquivo) {
        Path destino = Path.of("C:/tads/dswa/uploads-server", arquivo.getOriginalFilename());
        try {
            Files.copy(arquivo.getInputStream(), destino, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException ex) {
            ex.printStackTrace();
            return ResponseEntity.unprocessableEntity().body("Erro - Arquivo já existe");
        }
        return ResponseEntity.ok().build();
    }

}
