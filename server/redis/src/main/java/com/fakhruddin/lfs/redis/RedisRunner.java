package com.fakhruddin.lfs.redis;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;

public class RedisRunner {
    public static void main (String[] args) throws Exception{

        List<FileSystemProvider> installedProviders = FileSystemProvider.installedProviders();
        for (FileSystemProvider fileSystemProvider : installedProviders)
            {
                  System.out.println("--> FS: " + fileSystemProvider.getScheme());
        }
        
        Files.exists(Paths.get(new URI("lfs://temp")));

    }
}