package com.fakhruddin.lfs;

import java.io.IOException;
import java.nio.file.FileStore;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.WatchService;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.spi.FileSystemProvider;
import java.util.Set;

class RedisFileSystem extends FileSystem {

    /**
	 *
	 */
	
	private static final String SEPERATOR = "/";
	private final RedisFileSystemProvider provider;

    public RedisFileSystem(RedisFileSystemProvider provider){
        this.provider = provider;
    }

	@Override
	public FileSystemProvider provider() {
		return provider;
	}

	@Override
	public void close() throws IOException {
		
	}

	@Override
	public boolean isOpen() {
		return false;
	}

	@Override
	public boolean isReadOnly() {
		return false;
	}

	@Override
	public String getSeparator() {
		return SEPERATOR;
	}

	@Override
	public Iterable<Path> getRootDirectories() {
		return null;
	}

	@Override
	public Iterable<FileStore> getFileStores() {
		return null;
	}

	@Override
	public Set<String> supportedFileAttributeViews() {
		return null;
	}

	@Override
	public Path getPath(String first, String... more) {
		return null;
	}

	@Override
	public PathMatcher getPathMatcher(String syntaxAndPattern) {
		return null;
	}

	@Override
	public UserPrincipalLookupService getUserPrincipalLookupService() {
		return null;
	}

	@Override
	public WatchService newWatchService() throws IOException {
		return null;
	}

}