package com.fakhruddin.lfs.redis;

import static org.junit.Assert.assertTrue;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.spi.FileSystemProvider;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisFileSystemProviderTests {

	@Test
	public void fileSystemInstall() {
		List<FileSystemProvider> installedProviders = FileSystemProvider.installedProviders();
		boolean exists = installedProviders.stream().anyMatch(provider -> RedisFileSystemProvider.LFS_SCHEME.equalsIgnoreCase(provider.getScheme()));
		assertTrue("File system is not installed", exists);
	}


}
