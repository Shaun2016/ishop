package com.zjm.service.impl;

import com.zjm.exception.StorageException;
import com.zjm.exception.StorageFileNotFoundException;
import com.zjm.service.StorageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Created by ZJM on 2017/5/28.
 */
@Service
public class FileSystemStorageService implements StorageService {

    @Value("${filePath}")
    private String filePath;

    private Path rootLocation;

    @Override
    public void init(int shopId) {
        rootLocation = Paths.get(filePath + shopId);
        try {
            if(Files.isDirectory(rootLocation)) {
                return;
            }
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }

    @Override
    public void store(MultipartFile file) {
        try {
            if(file.isEmpty()) {
                throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
            }
            if(Files.exists(rootLocation.resolve(file.getOriginalFilename()))) {
                deleteOne(file.getOriginalFilename());
            }
            Files.copy(file.getInputStream(),rootLocation.resolve(file.getOriginalFilename()));
        } catch (FileAlreadyExistsException e) {
            throw new StorageException("File is exist" + file.getOriginalFilename(), e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Stream<Path> loadAll() {
        try {
            return Files.walk(this.rootLocation, 1)
                    .filter(path -> !path.equals(this.rootLocation))
                    .map(path -> this.rootLocation.relativize(path));
        } catch (IOException e) {
            throw new StorageException("Failed to read stored files", e);
        }

    }

    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }

    @Override
    public Resource loadAsResource(String filename) {
        try {
            Path file = load(filename);
            Resource resource = new UrlResource(file.toUri());
            if(resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new StorageFileNotFoundException("Could not read file: " + filename);

            }
        } catch (MalformedURLException e) {
            throw new StorageFileNotFoundException("Could not read file: " + filename, e);
        }
    }

    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void deleteOne(String filename) {
        Path path = rootLocation.resolve(filename);
        System.out.println(path);
        try {
            Files.deleteIfExists(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
